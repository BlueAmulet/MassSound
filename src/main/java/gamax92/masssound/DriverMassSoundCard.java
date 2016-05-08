package gamax92.masssound;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import li.cil.oc.api.Network;
import li.cil.oc.api.driver.EnvironmentHost;
import li.cil.oc.api.driver.item.Slot;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.DriverItem;
import li.cil.oc.common.item.TabletWrapper;

public class DriverMassSoundCard extends DriverItem
{
    protected DriverMassSoundCard() {
        super(new ItemStack(MassSound.masssoundCard));
    }
	
	@Override
	public ManagedEnvironment createEnvironment(ItemStack stack, EnvironmentHost container)
	{
		if (container.world() != null && container.world().isRemote)
			return null;
		return new Environment(container);
	}

	@Override
	public String slot(ItemStack stack)
	{
		return Slot.Card;
	}
	
	public class Environment extends li.cil.oc.api.prefab.ManagedEnvironment {
		protected EnvironmentHost container = null;

		public Environment(EnvironmentHost container) {
			this.container = container;
			this.setNode(Network.newNode(this, Visibility.Neighbors).withComponent("masssound").create());
		}
		
		@Callback
		public Object[] playSound(Context context, Arguments args)
		{
			if (args.count() > 8)
				return new Object[]{false, "too many sounds"};
			for (int i=0; i < args.count(); i++) {
				if (!args.isString(i))
					return new Object[]{false, "non string argument"};
			}
			for (int i=0; i < args.count(); i++)
			{
				float volume = 1;
				float pitch = 1;
				String soundStr = args.checkString(i);
				if (soundStr.contains(";")) {
					String[] soundStrSplit = soundStr.split(";");
					if (soundStrSplit.length > 3)
					{
						return new Object[]{false, "too many sound parameters"};
					}
					else
					{
						try { pitch = (float) Double.parseDouble(soundStrSplit[0]); }
						catch (NumberFormatException e) { return new Object[]{false, "bad sound parameter"}; }
						if (soundStrSplit.length == 3)
						{
							try { volume = (float) Double.parseDouble(soundStrSplit[1]); }
							catch (NumberFormatException e) { return new Object[]{false, "bad sound parameter"}; }
						}
						soundStr = soundStrSplit[soundStrSplit.length - 1];
					}
				}
				container.world().playSoundEffect(container.xPosition() + 0.5D, container.yPosition() + 0.5D, container.zPosition() + 0.5D, soundStr, volume, pitch);
			}
			return new Object[]{true};
		}
    }
}
