package mrriegel.blockedlayers.api;

import java.util.ArrayList;
import java.util.HashMap;

import mrriegel.blockedlayers.api.core.Quest;
import mrriegel.blockedlayers.api.core.Reward;

public class BlockedLayersApi 
{
	//TODO switch internals to use api
	public static ArrayList<Quest> questList;
	
	public static HashMap<String, Quest> questMap;
	
	public static ArrayList<Reward> rewardList;
	

	//eg  ("apple", "eat", "apple", "minecraft", "eat apple", 64, 0, 6, 0));
	public static void addQuest(String name, String activity, String object, String modID, String text, int layer, int meta, int number, int dimetionID)
	{
		questList.add(new Quest(name, activity, object, modID, text, layer, meta, number, dimetionID));
	}
}
