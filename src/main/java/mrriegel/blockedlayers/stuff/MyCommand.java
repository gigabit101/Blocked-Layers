package mrriegel.blockedlayers.stuff;

import mrriegel.blockedlayers.api.BlockedLayersApi;
import mrriegel.blockedlayers.api.core.Quest;
import mrriegel.blockedlayers.old.entity.PlayerInformation;
import mrriegel.blockedlayers.packet.PacketHandler;
import mrriegel.blockedlayers.packet.SyncClientPacket;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class MyCommand extends CommandBase
{
	@Override
	public String getCommandName() 
	{
		return "bl";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "commands.forge.usage";
	}

    @Override
    public int getRequiredPermissionLevel()
    {
        return 1;
    }

	@Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender.getEntityWorld().isRemote)
			return;
		if (args[0].equals("team")) 
		{
			EntityPlayer player = null;
			for (Object o : server.getPlayerList().getAllUsernames()) //MinecraftServer.getServer().getConfigurationManager().playerEntityList)
			{
				EntityPlayer p = (EntityPlayer) o;
				if (p.getDisplayName().equals(args[1])) 
				{
					player = p;
					break;
				}
			}
			if (player == null) 
			{
				sender.addChatMessage(new TextComponentString(I18n.format("bl.player.online", args[1])));
				return;
			}
			PlayerInformation pro = PlayerInformation.get(player);
			pro.setTeam(args[2]);
			PacketHandler.INSTANCE.sendTo(new SyncClientPacket((EntityPlayerMP) player), (EntityPlayerMP) player);
			sender.addChatMessage(new TextComponentString(I18n.format("bl.player.add", player.getDisplayName(), pro.getTeam())));
			Statics.syncTeams(pro.getTeam());
		}
		else if (args[0].equals("reset")) 
		{
			if (args[1].equals("quest")) 
			{
				EntityPlayer player = null;
				for (Object o : server.getPlayerList().getAllUsernames())//MinecraftServer.getServer().getConfigurationManager().playerEntityList)
				{
					EntityPlayer p = (EntityPlayer) o;
					if (p.getDisplayName().equals(args[2])) 
					{
						player = p;
						break;
					}
				}
				if (player == null) 
				{
					sender.addChatMessage(new TextComponentString(I18n.format("bl.player.online", args[2])));
					return;
				}
				PlayerInformation pro = PlayerInformation.get(player);
				if (pro.getQuestBools().containsKey(args[3])) 
				{
					pro.getQuestBools().put(args[3], false);
					pro.getQuestNums().put(args[3] + "Num", 0);
					player.addChatMessage(new TextComponentString(I18n.format("bl.quest.reset", args[3])));
					return;
				}
				sender.addChatMessage(new TextComponentString(I18n.format("bl.quest.exist", args[3])));
				return;
			}
			else if (args[1].equals("layer")) 
			{
				EntityPlayer player = null;
				for (Object o : server.getPlayerList().getAllUsernames())//MinecraftServer.getServer().getConfigurationManager().playerEntityList)
				{
					EntityPlayer p = (EntityPlayer) o;
					if (p.getDisplayName().equals(args[2]))
					{
						player = p;
						break;
					}
				}
				if (player == null) 
				{
					sender.addChatMessage(new TextComponentString(I18n.format("bl.player.online", args[2])));
					return;
				}
				PlayerInformation pro = PlayerInformation.get(player);
				if (pro.getLayerBools().containsKey(Integer.valueOf(args[3]))) 
				{
					pro.getLayerBools().put(Integer.valueOf(args[3]), false);
					for (Quest q : BlockedLayersApi.questList) 
					{
						if (q.getLayer() == Integer.valueOf(args[3])) 
						{
							pro.getQuestBools().put(q.getName(), false);
							pro.getQuestNums().put(q.getName() + "Num", 0);
						}

					}
					player.addChatMessage(new TextComponentString(I18n.format("bl.layer.reset", Integer.valueOf(args[3]))));
					return;
				}
				sender.addChatMessage(new TextComponentString(I18n.format("bl.layer.exist", Integer.valueOf(args[3]))));
				return;
			}
		}
	}



//	@Override
//	public boolean canCommandSenderUseCommand(ICommandSender sender)
//	{
//		if (sender instanceof EntityPlayer)
//		{
//			EntityPlayer player = (EntityPlayer) sender;
//			return MinecraftServer.getServer().isSinglePlayer() || MinecraftServer.getServer().getConfigurationManager().func_152596_g(player.getGameProfile());
//		}
//		return true;
//	}

//	@Override
//	public List addTabCompletionOptions(ICommandSender sender, String[] args)
//	{
//		return null;
//	}
}
