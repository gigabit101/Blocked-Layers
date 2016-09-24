package mrriegel.blockedlayers.proxy;

import mrriegel.blockedlayers.client.KeyHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerHandlers() 
	{
		ClientRegistry.registerKeyBinding(KeyHandler.gui);
	}
}
