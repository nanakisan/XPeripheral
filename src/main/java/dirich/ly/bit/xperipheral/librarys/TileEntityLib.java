package dirich.ly.bit.xperipheral.librarys;

import java.util.HashMap;
import java.util.Map;

import dirich.ly.bit.xperipheral.XPeripheralMod;
import dirich.ly.bit.xperipheral.librarys.bases.BlockBase;
import dirich.ly.bit.xperipheral.librarys.bases.TileEntityBase;
import dirich.ly.bit.xperipheral.tileentitys.BasicTileEntity;

public class TileEntityLib {

	private Map<String, TileEntityBase> Bank = new HashMap<String, TileEntityBase>();

	public void loadBlock(TileEntityBase _block){
		if(Bank.containsKey(_block.getUnlocalizedName())){
			Bank.put(_block.getUnlocalizedName(), _block);
		}
	}
	
	public TileEntityBase getBlock(String _identifier){
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
	
	
	public void registerAll(XPeripheralMod _mod){
		new BasicTileEntity().register(this, _mod);
	}
}
