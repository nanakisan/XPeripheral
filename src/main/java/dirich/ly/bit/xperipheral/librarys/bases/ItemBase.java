package dirich.ly.bit.xperipheral.librarys.bases;

import cpw.mods.fml.common.registry.GameRegistry;
import dirich.ly.bit.xperipheral.XPeripheralMod;
import dirich.ly.bit.xperipheral.librarys.ItemLib;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item{
	
	public ItemBase(String _unlocalizedName){
		this.setUnlocalizedName(_unlocalizedName);
		this.setTextureName(XPeripheralMod.modId + ":" + _unlocalizedName);
		this.setCreativeTab(XPeripheralMod.tab);
	}
	
	public void register(ItemLib _lib){
		GameRegistry.registerItem(this, this.getUnlocalizedName(), XPeripheralMod.modId);
		_lib.loadItem(this);
	}
	
}
