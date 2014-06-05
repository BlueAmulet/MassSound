package gamax92.masssound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class MassSoundCard extends Item
{
	public MassSoundCard(int ItemID)
	{
		super(ItemID);
		setUnlocalizedName("massSound");
		setCreativeTab(li.cil.oc.api.CreativeTab.instance);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MassSound.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
