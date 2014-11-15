package dirich.ly.bit.xperipheral.librarys;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import dirich.ly.bit.xperipheral.XPeripheralMod;
import dirich.ly.bit.xperipheral.items.BasicItem;
import dirich.ly.bit.xperipheral.librarys.bases.BlockBase;
import dirich.ly.bit.xperipheral.librarys.bases.ItemBase;

public class ItemLib {

	private Map<String, ItemBase> Bank = new HashMap<String, ItemBase>();
	
	public void loadItem(ItemBase _item){
		if(Bank.containsKey(_item.getUnlocalizedName())){
			Bank.put(_item.getUnlocalizedName(), _item);
		}
	}
	
	public ItemBase getBlock(String _identifier){
		if(Bank.containsKey(_identifier)){
			return Bank.get(_identifier);
		}
		else return null;
	}
	
	public void removeBlock(String _identifier){
		if(Bank.containsKey(_identifier)){
			Bank.remove(_identifier);
		}
	}
	
	
	public void registerAll(){
		new BasicItem().register(this);
	}
	
}
