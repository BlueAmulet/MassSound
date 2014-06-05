package gamax92.masssound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class MassSoundCard extends Item
{
	public MassSoundCard()
	{
		super();
		setUnlocalizedName("massSound");
		setCreativeTab(li.cil.oc.api.CreativeTab.instance);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MassSound.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
