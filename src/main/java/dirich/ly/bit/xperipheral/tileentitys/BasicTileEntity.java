package dirich.ly.bit.xperipheral.tileentitys;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import dirich.ly.bit.xperipheral.librarys.bases.TileEntityBase;
import dirich.ly.bit.xperipheral.models.BasicTileEntityModel;

public class BasicTileEntity extends TileEntityBase{

	public BasicTileEntity() {
		super(Material.circuits, "BasicTileEntity", new BasicTileEntityModel());
	}
}
