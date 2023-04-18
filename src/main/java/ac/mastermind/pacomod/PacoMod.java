package ac.mastermind.pacomod;
import ac.mastermind.pacomod.block.ModBlocks;
import ac.mastermind.pacomod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PacoMod.MODID)
public class PacoMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "pacomod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public PacoMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Registramos los BLOCKS (Deben estar registrados antes para que funcione el get)
        ModBlocks.BLOCKS.register(modEventBus);
        //Registramos los ITEMS
        ModItems.ITEMS.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        //Registramos nuestro item en uno de los TABS existentes
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.EXAMPLE_ITEM);
        }else if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.EXAMPLE_BLOCK);
            event.accept(ModBlocks.EXAMPLE_BLOCK2);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
