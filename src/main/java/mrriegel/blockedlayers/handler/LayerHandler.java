package mrriegel.blockedlayers.handler;

import mrriegel.blockedlayers.old.entity.PlayerInformation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map.Entry;

public class LayerHandler 
{
	@SubscribeEvent
	public void disallow(BlockEvent.BreakEvent event) 
	{
		boolean currentBlacklisted = isIn(ConfigurationHandler.dimensionBlack, event.getWorld().provider.getDimension());
		boolean currentWhitelisted = isIn(ConfigurationHandler.dimensionWhite, event.getWorld().provider.getDimension());
		String bool = ConfigurationHandler.dimensionBlack.length == 0 ? ConfigurationHandler.dimensionWhite.length == 0 ? "nothing"
				: "white"
				: "black";
		if (event.getWorld().isRemote || event.getPlayer() == null
				|| event.getPlayer() instanceof FakePlayer
				|| event.getPlayer().capabilities.isCreativeMode
				|| (bool.equals("black") && currentBlacklisted)
				|| (bool.equals("white") && !currentWhitelisted))
			return;

		EntityPlayer player = event.getPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Entry<Integer, Boolean> entry : pro.getLayerBools().entrySet()) 
		{
			if (entry.getValue()) 
			{
				continue;
			}
			if (event.getPos().getY() < entry.getKey())
			{
				event.setCanceled(true);
				return;
			}
		}
	}

	boolean isIn(int[] ar, int i) 
	{
		for (int o : ar)
			if (i == o)
				return true;
		return false;
	}
}
