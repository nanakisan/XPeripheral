package dirich.ly.bit.xperipheral;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class UpdateManager {


	public static void registerUpdater(UpdateManager manager) {

		FMLCommonHandler.instance().bus().register(manager);
	}

	private int lastPoll = 400;

	@SubscribeEvent
	public void tickStart(PlayerTickEvent evt) {

		if (evt.phase != Phase.START) {
			return;
		}
		if (lastPoll > 0) {
			--lastPoll;
			return;
		}
		lastPoll = 400;

		
	}
}