package dirich.ly.bit.xperipheral.librarys.bases;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.GameRegistry;
import scala.reflect.internal.Trees.Super;
import dirich.ly.bit.xperipheral.XPeripheralMod;
import dirich.ly.bit.xperipheral.librarys.TileEntityLib;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityBase extends BlockContainer{
	
	public TileEntityBase(Material _material, String _unlocalizedName, TechneModelBase _model) {
		super(_material);
		Renderer.resource =  new ResourceLocation(XPeripheralMod.modId + ":textures/models/" + _unlocalizedName + ".png");
		Renderer.model = _model;
		this.setBlockTextureName(XPeripheralMod.modId + ":" + _unlocalizedName);
		this.setBlockName(_unlocalizedName).setCreativeTab(XPeripheralMod.tab);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new Tile();
	}
	
	public void register(TileEntityLib _lib, XPeripheralMod _mod){
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
		_lib.loadBlock(this);
		_mod.client.registerSpecialRenderer(Tile.class, new Renderer());
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	protected class Tile extends TileEntity{
		
	}
	
	protected static class Renderer extends TileEntitySpecialRenderer{

		private static ResourceLocation resource;
		private static TechneModelBase model;
		
		@Override
		public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float w) {
			GL11.glPushMatrix();
				GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
				GL11.glRotatef(180, 0F, 0F, -1F);
				this.bindTexture(resource);
				GL11.glPushMatrix();
					this.model.renderModel(0.0625F);
				GL11.glPopMatrix();
			GL11.glPopMatrix();
			
		}
		
	}

}
