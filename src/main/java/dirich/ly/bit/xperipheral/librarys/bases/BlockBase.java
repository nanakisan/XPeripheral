package dirich.ly.bit.xperipheral.librarys.bases;

import cpw.mods.fml.common.registry.GameRegistry;
import dirich.ly.bit.xperipheral.XPeripheralMod;
import dirich.ly.bit.xperipheral.librarys.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockBase extends Block{

	private boolean isRegistered = true;
	
	protected BlockBase(Material _material, String _unlocalizedName) {
		super(_material);
		this.setBlockName(_unlocalizedName);
		this.setBlockTextureName(XPeripheralMod.modId + ":" + _unlocalizedName);
		this.setCreativeTab(XPeripheralMod.tab);
	}
	
	public void register(BlockLib _lib){
		isRegistered = true;
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
		_lib.loadBlock(this);
	}
}
