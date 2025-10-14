package slab_topographic;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import slab_topographic.registry.ModBlocks;
import slab_topographic.registry.ModItems;

@Mod(slab_topographic.MODID)
public class slab_topographic {

    public static final String MODID = "slab_topographic";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public slab_topographic() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.GRASS_SLAB_ITEM);
            event.accept(ModItems.SNOWY_GRASS_SLAB_ITEM);
            event.accept(ModItems.SAND_SLAB_ITEM);
            event.accept(ModItems.RED_SAND_SLAB_ITEM);
            event.accept(ModItems.DIRT_PATH_SLAB_ITEM);
            event.accept(ModItems.GRAVEL_SLAB_ITEM);
            event.accept(ModItems.PODZOL_SLAB_ITEM);
            event.accept(ModItems.MYCELIUM_SLAB_ITEM);
            event.accept(ModItems.CLAY_SLAB_ITEM);
            event.accept(ModItems.DIRT_SLAB_ITEM);
        }
    }
}