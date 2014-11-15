package resonant.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Applied to objects that can be control by the player using the keyboard
 *
 * @author DarkGuardsman
 */
public interface IKeyReceiver
{
	/**
	 * Called when the player presses a key
	 *
	 * @param player    - client player
	 * @param character - character code
	 * @param keycode   - keyboard code
	 */
	public boolean keyTyped(EntityPlayer player, int keycode);
}
