package mrriegel.blockedlayers.api.core;

import java.util.ArrayList;

public class Reward 
{
	int layer;
	ArrayList<String> rewards;

	public Reward(int layer, ArrayList<String> rewards) 
	{
		this.layer = layer;
		this.rewards = rewards;
	}

	public int getLayer() 
	{
		return layer;
	}

	public ArrayList<String> getRewards() 
	{
		return rewards;
	}
}
