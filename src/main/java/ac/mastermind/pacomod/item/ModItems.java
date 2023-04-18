package ac.mastermind.pacomod.item;

import ac.mastermind.pacomod.PacoMod;
import ac.mastermind.pacomod.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public final static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PacoMod.MODID);

    public final static RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("ejemplo_item", () -> new Item(new Item.Properties()));
    // Ya no se necesita con la nueva función
    // public final static RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("ejemplo_block", ()-> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(),new Item.Properties()));
}
