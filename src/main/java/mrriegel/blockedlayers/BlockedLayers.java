package mrriegel.blockedlayers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import mrriegel.blockedlayers.api.BlockedLayersApi;
import mrriegel.blockedlayers.api.core.Quest;
import mrriegel.blockedlayers.api.core.Reward;
import mrriegel.blockedlayers.client.GuiHandler;
import mrriegel.blockedlayers.client.KeyHandler;
import mrriegel.blockedlayers.handler.ConfigurationHandler;
import mrriegel.blockedlayers.handler.LayerHandler;
import mrriegel.blockedlayers.handler.QuestHandler;
import mrriegel.blockedlayers.handler.SyncHandler;
import mrriegel.blockedlayers.init.ModQuests;
import mrriegel.blockedlayers.lib.ModInfo;
import mrriegel.blockedlayers.packet.PacketHandler;
import mrriegel.blockedlayers.proxy.CommonProxy;
import mrriegel.blockedlayers.stuff.MyCommand;
import mrriegel.blockedlayers.stuff.Statics;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class BlockedLayers 
{
	@Mod.Instance(ModInfo.MOD_ID)
	public static BlockedLayers instance;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException 
	{
		File configDir = new File(event.getModConfigurationDirectory(), "BlockedLayers");
		ConfigurationHandler.load(new File(configDir, "config.cfg"));

		File questFile = new File(configDir, "quests.json");
		if (!questFile.exists()) 
		{
			questFile.createNewFile();
			FileWriter fw = new FileWriter(questFile);
			Statics.fillQuestsFirst(fw);
			fw.close();
		}

		BlockedLayersApi.questList = new Gson().fromJson(new BufferedReader(new FileReader(questFile)), new TypeToken<ArrayList<Quest>>(){}.getType());
		BlockedLayersApi.questMap = new HashMap<String, Quest>();
		for (Quest q : BlockedLayersApi.questList)
			BlockedLayersApi.questMap.put(q.getName(), q);

		File rewardFile = new File(configDir, "rewards.json");
		if (!rewardFile.exists()) 
		{
			rewardFile.createNewFile();
			FileWriter fw = new FileWriter(rewardFile);
			Statics.fillRewardsFirst(fw);
			fw.close();
		}
		ModQuests.init();

		BlockedLayersApi.rewardList = new Gson().fromJson(new BufferedReader(new FileReader(rewardFile)), new TypeToken<ArrayList<Reward>>(){}.getType());
		PacketHandler.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new LayerHandler());
		MinecraftForge.EVENT_BUS.register(new QuestHandler());
		FMLCommonHandler.instance().bus().register(new QuestHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new SyncHandler());
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(new KeyHandler());
		proxy.registerHandlers();
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) 
	{
		event.registerServerCommand(new MyCommand());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		Statics.validateQuests(BlockedLayersApi.questList);
		Statics.validateRewards(BlockedLayersApi.rewardList);
	}
}
