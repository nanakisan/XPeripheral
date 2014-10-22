package dirich.ly.bit.xperipheral.worldgen;

import java.util.Random;

import dirich.ly.bit.xperipheral.api.IFeatureGenerator;
import net.minecraft.world.World;

public class WorldHandler  implements IFeatureGenerator
{
	private final String name = "XPeripherals:WorldGen";

	@Override
	public String getFeatureName()
	{
		return name;
	}

	@Override
	public boolean generateFeature(Random random, int chunkX, int chunkZ, World world, boolean newGen)
	{
		if (world.provider.dimensionId == -1)
		{
			// TODO: Implement setting to disable worldgen!
			//generate(world, random, chunkX * 16, chunkZ * 16, newGen);
			return true;
		}
		return false;
	}
}
