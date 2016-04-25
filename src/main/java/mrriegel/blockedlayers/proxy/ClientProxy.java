package mrriegel.blockedlayers.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import mrriegel.blockedlayers.client.KeyHandler;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerHandlers() 
	{
		ClientRegistry.registerKeyBinding(KeyHandler.gui);
	}
}
