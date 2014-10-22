package miscperipherals.upgrade;

import miscperipherals.api.IUpgradeIcons;
import miscperipherals.core.MiscPeripherals;
import miscperipherals.peripheral.PeripheralNote;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.turtle.TurtleSide;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import dan200.computercraft.api.turtle.TurtleVerb;

public class UpgradeNote implements ITurtleUpgrade, IUpgradeIcons {
	private IIcon icon;
	
	@Override
	public int getUpgradeID() {
		return 224;
	}

	@Override
	public String getAdjective() {
		return "Note";
	}

	@Override
	public TurtleUpgradeType getType() {
		return TurtleUpgradeType.Peripheral;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(MiscPeripherals.instance.blockAlpha, 1, 1);
	}

	@Override
	public boolean isSecret() {
		return false;
	}

	@Override
	public Icon getIcon(ITurtleAccess turtle, TurtleSide side) {
		return icon;
	}

	@Override
	public IHostedPeripheral createPeripheral(ITurtleAccess turtle,	TurtleSide side) {
		return new PeripheralNote(turtle);
	}

	@Override
	public boolean useTool(ITurtleAccess turtle, TurtleSide side, TurtleVerb verb, int direction) {
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		icon = reg.registerIcon("MiscPeripherals:note");
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUnlocalisedAdjective() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ITurtleAccess turtle, TurtleSide side) {
		// TODO Auto-generated method stub
		
	}
}
