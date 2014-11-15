package dirich.ly.bit.xperipheral;

import dirich.ly.bit.xperipheral.items.BasicItem;
import dirich.ly.bit.xperipheral.librarys.ItemLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class XPeripheralTab extends CreativeTabs{
	
	public XPeripheralTab() {
		super("XPeripheral");
	}

	@Override
	public Item getTabIconItem() {
		return new BasicItem();
	}

}
