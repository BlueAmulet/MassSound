package gamax92.masssound;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MassSound.MODID, name = MassSound.NAME, version = MassSound.VERSION, dependencies = "required-after:OpenComputers@[1.3.0,)")
public class MassSound
{
    public static final String MODID = "masssound";
    public static final String NAME = "MassSound";
    public static final String VERSION = "1.0";
    
    @Instance
    public static MassSound instance;
    
    public static MassSoundCard masssoundCard;
	private int masssoundCardID;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		masssoundCardID = config.getItem("massSoundCardID", 6527).getInt();
		config.save();
		
    	masssoundCard = new MassSoundCard(masssoundCardID);
    	GameRegistry.registerItem(masssoundCard, "massSound");
    	LanguageRegistry.addName(masssoundCard, "JStar MassSound");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.addRecipe(new ItemStack(masssoundCard),
        	"NM ",
        	" C ",
        	'N', Block.music,
        	'M', li.cil.oc.api.Items.get("chip1").createItemStack(1),
        	'C', li.cil.oc.api.Items.get("card").createItemStack(1)
        );
    	
    	li.cil.oc.api.Driver.add(new DriverMassSoundCard());
    }
}
