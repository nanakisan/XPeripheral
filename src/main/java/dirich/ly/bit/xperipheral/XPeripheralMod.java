package dirich.ly.bit.xperipheral;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import dirich.ly.bit.xperipheral.proxy.Server;

@Mod(modid = XPeripheralMod.modId, name = XPeripheralMod.modName, version = XPeripheralMod.version, dependencies = XPeripheralMod.dependencies)
public class XPeripheralMod{
	
	public static final String modId = "XPeripheral";
	public static final String modName = "XPeripheral";
	public static final String version = "1.7.10-R0B0";
	public static final String dependencies = "";
	
	private ConfigurationManager confmgr = new ConfigurationManager();
	
	@SidedProxy(clientSide="dirich.ly.bit.proxy.Client", serverSide="dirich.ly.bit.proxy.Server")
	public static Server proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		confmgr.setConfigFolderBase(evt.getModConfigurationDirectory());
		confmgr.loadConfig(confmgr.getCommonConfig());
		confmgr.loadLang();

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
