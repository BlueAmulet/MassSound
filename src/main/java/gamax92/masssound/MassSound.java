package gamax92.masssound;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
    public void init(FMLInitializationEvent event)
    {
    	masssoundCard = new MassSoundCard();
    	GameRegistry.registerItem(masssoundCard, "massSound");

    	li.cil.oc.api.Driver.add(new DriverMassSoundCard());
    }
}
