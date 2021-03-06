package mrriegel.blockedlayers.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mrriegel.blockedlayers.entity.PlayerInformation;
import mrriegel.blockedlayers.packet.PacketHandler;
import mrriegel.blockedlayers.packet.SyncClientPacket;
import mrriegel.blockedlayers.stuff.Statics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class SyncHandler 
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityPlayer && !(event.entity instanceof FakePlayer)) 
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			if (PlayerInformation.get((EntityPlayer) event.entity) == null) 
			{
				PlayerInformation.register(player);
			}
		}
	}

	@SubscribeEvent
	public void join(EntityJoinWorldEvent e) 
	{
		if (e.world.isRemote)
			return;
		
		if (e.entity instanceof EntityPlayerMP) 
		{
			PacketHandler.INSTANCE.sendTo(new SyncClientPacket((EntityPlayerMP) e.entity), (EntityPlayerMP) e.entity);
			Statics.syncTeams(PlayerInformation.get((EntityPlayer) e.entity).getTeam());
		}
	}

	@SubscribeEvent
	public void onCloning(PlayerEvent.Clone event) 
	{
		PlayerInformation newInfo = PlayerInformation.get(event.entityPlayer);
		PlayerInformation oldInfo = PlayerInformation.get(event.original);
		newInfo.setLayerBools(oldInfo.getLayerBools());
		newInfo.setQuestBools(oldInfo.getQuestBools());
		newInfo.setQuestNums(oldInfo.getQuestNums());
		newInfo.setTeam(oldInfo.getTeam());
	}
}
