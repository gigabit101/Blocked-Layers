package mrriegel.blockedlayers.init;

import mrriegel.blockedlayers.BlockedLayers;
import mrriegel.blockedlayers.api.BlockedLayersApi;
import mrriegel.blockedlayers.api.core.Quest;

public class ModQuests 
{
	public static void init()
	{
		BlockedLayersApi.addQuest("apple", "eat", "apple", "minecraft", "This was added with the API", 64, 0, 1, 0);
	}
}
