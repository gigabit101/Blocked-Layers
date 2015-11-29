package mrriegel.blockedlayers.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import mrriegel.blockedlayers.Statics;
import mrriegel.blockedlayers.entity.PlayerInformation;
import mrriegel.blockedlayers.packet.SyncClientPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SyncHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer
				&& !(event.entity instanceof FakePlayer)) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (PlayerInformation.get((EntityPlayer) event.entity) == null) {
				PlayerInformation.register(player);
			}
		}
	}

	@SubscribeEvent
	public void join(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityPlayerMP) {
			PacketHandler.INSTANCE.sendTo(
new SyncClientPacket(
					(EntityPlayerMP) e.entity), (EntityPlayerMP) e.entity);
			Statics.syncTeams((EntityPlayerMP) e.entity);
		}
	}

	@SubscribeEvent
	public void onCloning(PlayerEvent.Clone event) {
		PlayerInformation newInfo = PlayerInformation.get(event.entityPlayer);
		PlayerInformation oldInfo = PlayerInformation.get(event.original);
		newInfo.setLayerBools(oldInfo.getLayerBools());
		newInfo.setQuestBools(oldInfo.getQuestBools());
		newInfo.setQuestNums(oldInfo.getQuestNums());
		newInfo.setTeam(oldInfo.getTeam());

	}

}
