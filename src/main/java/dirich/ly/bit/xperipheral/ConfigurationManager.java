package dirich.ly.bit.xperipheral;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationManager{
	
	protected File _configFolder;
	
	void loadConfig(File f)
	{
		Configuration c = new Configuration(f);
		c.load();
		
		/*
		explosionPower = c.get(CATEGORY_GENERAL, "ExplosionPower", 2);
		explosionPower.comment = "How powerful an explosion will be. Creepers are 3, TNT is 4, electrified creepers are 6. This affects both the ability of the explosion to punch through blocks as well as the blast radius.";
		explosionProbability = c.get(CATEGORY_GENERAL, "ExplosionProbability", 75);
		explosionProbability.comment = "The likelyhood an adjacent netherore will turn into an armed ore when one is mined. Percent chance out of 1000 (lower is less likely).";
		enableExplosions = c.get(CATEGORY_GENERAL, "ExplosionEnable", true);
		enableExplosions.comment = "NetherOres have a chance to explode when mined if true.";
		*/ // Example //
		
		c.save();
	}
	
	protected void setConfigFolderBase(File folder)
	{
		_configFolder = new File(folder.getAbsolutePath() + "/" + getConfigBaseFolder() + "/" + XPeripheralMod.modId.toLowerCase() + "/");
	}
	
	protected File getClientConfig()
	{
		return new File(_configFolder.getAbsolutePath() + "/client.cfg");
	}
	
	protected File getCommonConfig()
	{
		return new File(_configFolder.getAbsolutePath() + "/common.cfg");
	}
	
	protected String getConfigBaseFolder()
	{
		return "DiRich";
	}
	
	protected void extractLang(String[] languages)
	{
		String langResourceBase = "/" + getConfigBaseFolder() + "/" + XPeripheralMod.modId.toLowerCase() + "/lang/";
		for(String lang : languages)
		{
			InputStream is = this.getClass().getResourceAsStream(langResourceBase + lang + ".lang");
			if(is == null)
			{
				continue;
			}
			try
			{
				OutputStream os = new FileOutputStream(_configFolder.getAbsolutePath() + "/" + lang + ".lang");
				byte[] buffer = new byte[1024];
				int read = 0;
				while((read = is.read(buffer)) != -1)
				{
					os.write(buffer, 0, read);
				}
				is.close();
				os.flush();
				os.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	protected void loadLang()
	{
		for(File langFile : _configFolder.listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				return name != null && name.endsWith(".lang");
			}
		}))
		{
			InputStreamReader is = null;
			try
			{
				Properties langPack = new Properties();
				is = new InputStreamReader(new FileInputStream(langFile), "UTF-8");
				langPack.load(is);
				String lang = langFile.getName().replace(".lang", "");
				LanguageRegistry.instance().addStringLocalization(langPack, lang);
			}
			catch(Throwable x)
			{
				x.printStackTrace();
			}
			finally
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
