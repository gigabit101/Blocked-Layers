package mrriegel.blockedlayers.packet;

import mrriegel.blockedlayers.lib.ModInfo;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(ModInfo.MOD_ID);

	public static void init()
	{
		int id = 0;
		INSTANCE.registerMessage(KeyPacket.class, KeyPacket.class, id++, Side.SERVER);
		INSTANCE.registerMessage(SyncClientPacket.class, SyncClientPacket.class, id++, Side.CLIENT);
	}
}
