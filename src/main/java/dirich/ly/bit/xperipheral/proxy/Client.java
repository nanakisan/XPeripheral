package dirich.ly.bit.xperipheral.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class Client extends Server {
	
	@Override
	public void load()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityArmedOre.class, new RendererArmedOre());
		//TODO: Implement rendering system
		// See line above as example
	}
	
	public void registerSpecialRenderer(Class _tile,TileEntitySpecialRenderer _specialRenderer){
		ClientRegistry.bindTileEntitySpecialRenderer(_tile, _specialRenderer);
	}
}