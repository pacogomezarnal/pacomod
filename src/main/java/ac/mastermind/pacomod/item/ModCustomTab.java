package ac.mastermind.pacomod.item;

import ac.mastermind.pacomod.PacoMod;
import ac.mastermind.pacomod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.BuiltInPackSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PacoMod.MODID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModCustomTab {
    public static CreativeModeTab MODCUSTOMTAB;
    public static CreativeModeTab MODCUSTOMTAB2;
    @SubscribeEvent
    public static void registerCreativeModTabs(CreativeModeTabEvent.Register event) {
        PacoMod.LOGGER.info("[MODCUSTOMTAB] Llego");
        MODCUSTOMTAB=event.registerCreativeModeTab(new ResourceLocation(PacoMod.MODID, "tab_mod"),
                builder ->
                        // Set name of tab to display
                        builder.title(Component.translatable("item_group." + PacoMod.MODID + ".tab_mod"))
                                // Set icon of creative tab
                                .icon(() -> new ItemStack(ModItems.TAB_ICON_ITEM.get()))
        );
        MODCUSTOMTAB2=event.registerCreativeModeTab(new ResourceLocation(PacoMod.MODID, "tab_mod2"),
                builder ->
                        // Set name of tab to display
                        builder.title(Component.translatable("item_group." + PacoMod.MODID + ".tab_mod2"))
                                // Set icon of creative tab
                                .icon(() -> new ItemStack(ModItems.TAB_ICON_ITEM.get()))
                                .displayItems((params, output,accept) -> {
                                    output.accept(ModItems.EXAMPLE_ITEM.get());
                                    output.accept(ModBlocks.EXAMPLE_BLOCK.get());
                                })
        );
    }
}
