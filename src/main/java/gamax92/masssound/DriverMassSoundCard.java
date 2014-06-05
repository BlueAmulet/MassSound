package gamax92.masssound;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import li.cil.oc.api.Network;
import li.cil.oc.api.driver.Container;
import li.cil.oc.api.driver.Slot;
import li.cil.oc.api.network.Arguments;
import li.cil.oc.api.network.Callback;
import li.cil.oc.api.network.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.DriverItem;

public class DriverMassSoundCard extends DriverItem
{
    protected DriverMassSoundCard() {
        super(new ItemStack(MassSound.masssoundCard));
    }
	
	@Override
	public ManagedEnvironment createEnvironment(ItemStack stack, Container container)
	{
		if (container instanceof TileEntity)
			return new Environment((TileEntity) container);
		return null;
	}

	@Override
	public Slot slot(ItemStack stack)
	{
		return Slot.Card;
	}
	
	public class Environment extends li.cil.oc.api.prefab.ManagedEnvironment {
		protected final TileEntity container;

		public Environment(TileEntity container) {
			this.container = container;
			node = Network.newNode(this, Visibility.Neighbors).withComponent("masssound").create();
		}
		
		@Callback
		public Object[] playSound(Context context, Arguments args)
		{
			for (int i=0; i < args.count(); i++) {
				if (!args.isString(i))
					return new Object[]{false, "non string argument"};
			}
			for (int i=0; i < args.count(); i++)
				container.worldObj.playSoundEffect(container.xCoord + 0.5D, container.yCoord + 0.5D, container.zCoord + 0.5D, args.checkString(i), 1, 1);
			return new Object[]{true};
		}
    }
}
