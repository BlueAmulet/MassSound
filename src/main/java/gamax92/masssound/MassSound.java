package gamax92.masssound;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        	'N', Blocks.noteblock,
        	'M', li.cil.oc.api.Items.get("chip1").createItemStack(1),
        	'C', li.cil.oc.api.Items.get("card").createItemStack(1)
        );
    	
    	li.cil.oc.api.Driver.add(new DriverMassSoundCard());
    }
}
