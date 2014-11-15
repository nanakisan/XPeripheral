package dirich.ly.bit.xperipheral;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dirich.ly.bit.xperipheral.librarys.ArmorLib;
import dirich.ly.bit.xperipheral.librarys.BlockLib;
import dirich.ly.bit.xperipheral.librarys.EntityLib;
import dirich.ly.bit.xperipheral.librarys.ItemLib;
import dirich.ly.bit.xperipheral.librarys.TileEntityLib;
import dirich.ly.bit.xperipheral.proxy.Client;
import dirich.ly.bit.xperipheral.proxy.Server;

@Mod(modid = XPeripheralMod.modId, name = XPeripheralMod.modName, version = XPeripheralMod.version, dependencies = XPeripheralMod.dependencies)
public class XPeripheralMod{
	
	public static final String modId = "XPeripheral";
	public static final String modName = "XPeripheral";
	public static final String version = "1.7.10-R0B2";
	public static final String dependencies = ""; // "required-after:ComputerCraft@[1.63,)";
	
	public static final CreativeTabs tab = new XPeripheralTab();
	
	private ArmorLib armorLib = new ArmorLib();
	private BlockLib blockLib = new BlockLib();
	private EntityLib entityLib = new EntityLib();
	private ItemLib itemLib = new ItemLib();
	private TileEntityLib tileEntityLib = new TileEntityLib();
	
	private ConfigurationManager confmgr = new ConfigurationManager();
	
	@SidedProxy(clientSide="dirich.ly.bit.xperipheral.proxy.Client", serverSide="dirich.ly.bit.xperipheral.proxy.Server")
	public static Server proxy;
	public Client client = new Client();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		confmgr.setConfigFolderBase(evt.getModConfigurationDirectory());
		confmgr.loadConfig(confmgr.getCommonConfig());
		confmgr.loadLang();
		
		itemLib.registerAll();
		blockLib.registerAll();
		tileEntityLib.registerAll(this);

	}

	@EventHandler
	public void load(FMLInitializationEvent evt)
	{
		proxy.load();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
	
	}

	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent evt)
	{
		
	}
	
	public String getModId()
	{
		return modId;
	}

	public String getModName()
	{
		return modName;
	}

	public String getModVersion()
	{
		return version;
	}

}
