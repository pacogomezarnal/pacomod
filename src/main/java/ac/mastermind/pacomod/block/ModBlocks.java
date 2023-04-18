package ac.mastermind.pacomod.block;

import ac.mastermind.pacomod.PacoMod;
import ac.mastermind.pacomod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public final static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PacoMod.MODID);

    //Sustituimos por la funcion recién creada
    //public final static RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("ejemplo_block", ()->new Block(BlockBehaviour.Properties.of(Material.AMETHYST).friction(0.5f)));
    public final static RegistryObject<Block> EXAMPLE_BLOCK =registerBlock("ejemplo_block",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            new Item.Properties());
    public final static RegistryObject<Block> EXAMPLE_BLOCK2 =registerBlock("ejemplo_block2",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()),
            new Item.Properties());
    public static <T extends Block> RegistryObject<T> registerBlock(String name,Supplier<T> supplier, Item.Properties properties){
        RegistryObject <T> rBlock = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name,()->new BlockItem(rBlock.get(),properties));
        return rBlock;
    }
}
