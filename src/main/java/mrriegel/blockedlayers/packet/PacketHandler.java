package mrriegel.blockedlayers.packet;

import mrriegel.blockedlayers.BlockedLayers;
import mrriegel.blockedlayers.lib.ModInfo;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(
			ModInfo.MOD_ID);

	public static void init() {
		int id = 0;

		INSTANCE.registerMessage(KeyPacket.class, KeyPacket.class, id++,
				Side.SERVER);
		INSTANCE.registerMessage(SyncClientPacket.class,
				SyncClientPacket.class, id++, Side.CLIENT);

	}
}
