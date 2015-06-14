package gamax92.masssound;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MassSoundCard extends Item
{
	public MassSoundCard()
	{
		super();
		setUnlocalizedName("massSound");
		setCreativeTab(li.cil.oc.api.CreativeTab.instance);
	}
}
