package mrriegel.blockedlayers.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import mrriegel.blockedlayers.BlockedLayers;
import mrriegel.blockedlayers.lib.ModInfo;
import mrriegel.blockedlayers.packet.KeyPacket;
import mrriegel.blockedlayers.packet.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

public class KeyHandler 
{
	public static KeyBinding gui = new KeyBinding(ModInfo.MOD_ID + ".clipboard", Keyboard.KEY_L, ModInfo.MOD_NAME);

	@SubscribeEvent
	public void onKey(InputEvent.KeyInputEvent e) 
	{
		if (gui.isPressed()) 
		{
			PacketHandler.INSTANCE.sendToServer(new KeyPacket());
			EntityPlayer p = Minecraft.getMinecraft().thePlayer;
			p.openGui(BlockedLayers.instance, 0, p.worldObj, 0, 0, 0);
		}
	}
}
