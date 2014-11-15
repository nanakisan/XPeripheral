package dirich.ly.bit.xperipheral.librarys;

import java.util.HashMap;
import java.util.Map;

import dirich.ly.bit.xperipheral.blocks.BasicBlock;
import dirich.ly.bit.xperipheral.librarys.bases.BlockBase;
import dirich.ly.bit.xperipheral.librarys.bases.ItemBase;

public class BlockLib {

	private Map<String, BlockBase> Bank = new HashMap<String, BlockBase>();
	
	
	public void loadBlock(BlockBase _block){
		if(Bank.containsKey(_block.getUnlocalizedName())){
			Bank.put(_block.getUnlocalizedName(), _block);
		}
	}
	
	public BlockBase getBlock(String _identifier){
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
		new BasicBlock().register(this);
	}
}
