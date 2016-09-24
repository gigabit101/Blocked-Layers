package mrriegel.blockedlayers.handler;

import mrriegel.blockedlayers.old.entity.PlayerInformation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SyncHandler 
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.getEntity() instanceof EntityPlayer && !(event.getEntity() instanceof FakePlayer))
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (PlayerInformation.get((EntityPlayer) event.getEntity()) == null)
			{
				PlayerInformation.register(player);
			}
		}
	}

	@SubscribeEvent
	public void join(EntityJoinWorldEvent e) 
	{
		if (e.getWorld().isRemote)
			return;
		
		if (e.getEntity() instanceof EntityPlayerMP)
		{
//			PacketHandler.INSTANCE.sendTo(new SyncClientPacket((EntityPlayerMP) e.getEntity()), (EntityPlayerMP) e.getEntity());
			//Statics.syncTeams(PlayerInformation.get((EntityPlayer) e.getEntity()).getTeam());
		}
	}

	@SubscribeEvent
	public void onCloning(PlayerEvent.Clone event) 
	{
		PlayerInformation newInfo = PlayerInformation.get(event.getEntityPlayer());
		PlayerInformation oldInfo = PlayerInformation.get(event.getOriginal());
		newInfo.setLayerBools(oldInfo.getLayerBools());
		newInfo.setQuestBools(oldInfo.getQuestBools());
		newInfo.setQuestNums(oldInfo.getQuestNums());
		newInfo.setTeam(oldInfo.getTeam());
	}
}
