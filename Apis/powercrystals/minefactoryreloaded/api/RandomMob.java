package powercrystals.minefactoryreloaded.api;

import net.minecraft.entity.Entity;

public class RandomMob extends net.minecraft.util.WeightedRandom.Item
{
	private Entity _mob;
	
	public RandomMob(Entity savedMob, int weight)
	{
		super(weight);
		_mob = savedMob;
	}
	
	public Entity getMob()
	{
		if(_mob == null) return null;
		return _mob;
	}
}
