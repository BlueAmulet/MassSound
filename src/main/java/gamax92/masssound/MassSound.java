package gamax92.masssound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MassSound.MODID, name = MassSound.NAME, version = MassSound.VERSION, dependencies = "required-after:OpenComputers@[1.5.0,)")
public class MassSound
{
    public static final String MODID = "masssound";
    public static final String NAME = "MassSound";
    public static final String VERSION = "1.1.1";
    
    @Instance
    public static MassSound instance;
    
    public static MassSoundCard masssoundCard;
	private int masssoundCardID;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	masssoundCard = new MassSoundCard();
    	GameRegistry.registerItem(masssoundCard, "massSound");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.addRecipe(new ItemStack(masssoundCard),
        	"NM ",
        	" C ",
        	'N', Blocks.NOTEBLOCK,
        	'M', li.cil.oc.api.Items.get("chip1").createItemStack(1),
        	'C', li.cil.oc.api.Items.get("card").createItemStack(1)
        );
    	if (event.getSide() == Side.CLIENT) {
    		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(masssoundCard, 0, new ModelResourceLocation("masssound:massSound", "inventory"));
    	}
    	li.cil.oc.api.Driver.add(new DriverMassSoundCard());
    }
}
