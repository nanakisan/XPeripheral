package resonant.api.map;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import universalelectricity.core.transform.region.Rectangle;
import universalelectricity.core.transform.vector.Vector2;
import universalelectricity.core.transform.vector.Vector3;

import java.util.*;

/**
 * This class allows you to register TileEntities and Entities to be detectable by the ICBM radar.
 * <p/>
 * Make sure you unregister your object when it invalidates!
 *
 * @author Calclavia
 */
public class RadarRegistry
{
	private static Set<TileEntity> detectableTileEntities = new HashSet<TileEntity>();
	private static Set<Entity> detectableEntities = new HashSet<Entity>();

	public static void register(TileEntity tileEntity)
	{
		if (!detectableTileEntities.contains(tileEntity))
		{
			detectableTileEntities.add(tileEntity);
		}
	}

	public static void unregister(TileEntity tileEntity)
	{
		if (detectableTileEntities.contains(tileEntity))
		{
			detectableTileEntities.remove(tileEntity);
		}
	}

	public static void register(Entity entity)
	{
		if (!detectableEntities.contains(entity))
		{
			detectableEntities.add(entity);
		}
	}

	public static void unregister(Entity entity)
	{
		if (detectableEntities.contains(entity))
		{
			detectableEntities.remove(entity);
		}
	}

	public static List<TileEntity> getTileEntitiesInArea(Vector2 minVector, Vector2 maxVector)
	{
		cleanUpArray();
		List<TileEntity> returnArray = new ArrayList();

		for (TileEntity tileEntity : detectableTileEntities)
		{
			Vector2 point = new Vector3(tileEntity).toVector2();

			if (new Rectangle(minVector, maxVector).intersects(point))
			{
				returnArray.add(tileEntity);
			}
		}

		return returnArray;
	}

	public static List<Entity> getEntitiesWithinRadius(Vector2 vector, int radius)
	{
		cleanUpArray();
		List<Entity> returnArray = new ArrayList<Entity>();

		for (Entity entity : detectableEntities)
		{
			if (vector.distance(new Vector3(entity).toVector2()) <= radius)
			{
				returnArray.add(entity);
			}
		}

		return returnArray;
	}

	public static Set<TileEntity> getTileEntities()
	{
		cleanUpArray();
		return detectableTileEntities;
	}

	public static Set<Entity> getEntities()
	{
		cleanUpArray();
		return detectableEntities;
	}

	public static void cleanUpArray()
	{
		try
		{
			Iterator<TileEntity> it = detectableTileEntities.iterator();

			while (it.hasNext())
			{
				TileEntity tileEntity = it.next();

				if (tileEntity == null)
				{
					it.remove();
				}
				else if (tileEntity.isInvalid())
				{
					it.remove();
				}
				else if (tileEntity.getWorldObj().getTileEntity(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) != tileEntity)
				{
					it.remove();
				}
			}

			Iterator<Entity> it2 = detectableEntities.iterator();

			while (it2.hasNext())
			{
				Entity entity = it2.next();

				if (entity == null)
				{
					it2.remove();
				}
				else if (entity.isDead)
				{
					it2.remove();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Failed to clean up radar list properly.");
			e.printStackTrace();
		}
	}
}
