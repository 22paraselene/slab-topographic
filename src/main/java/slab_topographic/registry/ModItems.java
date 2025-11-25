package slab_topographic.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slab_topographic.slab_topographic;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, slab_topographic.MODID);

    // 所有台阶物品使用相同的属性
    private static final Item.Properties SLAB_PROPERTIES = new Item.Properties();

    // 草方块台阶物品
    public static final RegistryObject<Item> GRASS_SLAB_ITEM = ITEMS.register("grass_slab",
            () -> new BlockItem(ModBlocks.GRASS_SLAB.get(), SLAB_PROPERTIES));

    // 覆雪草方块台阶物品
    public static final RegistryObject<Item> SNOWY_GRASS_SLAB_ITEM = ITEMS.register("snowy_grass_slab",
            () -> new BlockItem(ModBlocks.SNOWY_GRASS_SLAB.get(), SLAB_PROPERTIES));

    // 沙子台阶物品
    public static final RegistryObject<Item> SAND_SLAB_ITEM = ITEMS.register("sand_slab",
            () -> new BlockItem(ModBlocks.SAND_SLAB.get(), SLAB_PROPERTIES));

    // 红沙台阶物品
    public static final RegistryObject<Item> RED_SAND_SLAB_ITEM = ITEMS.register("red_sand_slab",
            () -> new BlockItem(ModBlocks.RED_SAND_SLAB.get(), SLAB_PROPERTIES));

    // 土径台阶物品
    public static final RegistryObject<Item> DIRT_PATH_SLAB_ITEM = ITEMS.register("dirt_path_slab",
            () -> new BlockItem(ModBlocks.DIRT_PATH_SLAB.get(), SLAB_PROPERTIES));

    // 砂砾台阶物品
    public static final RegistryObject<Item> GRAVEL_SLAB_ITEM = ITEMS.register("gravel_slab",
            () -> new BlockItem(ModBlocks.GRAVEL_SLAB.get(), SLAB_PROPERTIES));

    // 灰化土台阶物品
    public static final RegistryObject<Item> PODZOL_SLAB_ITEM = ITEMS.register("podzol_slab",
            () -> new BlockItem(ModBlocks.PODZOL_SLAB.get(), SLAB_PROPERTIES));

    // 菌丝土台阶物品
    public static final RegistryObject<Item> MYCELIUM_SLAB_ITEM = ITEMS.register("mycelium_slab",
            () -> new BlockItem(ModBlocks.MYCELIUM_SLAB.get(), SLAB_PROPERTIES));

    // 粘土台阶物品
    public static final RegistryObject<Item> CLAY_SLAB_ITEM = ITEMS.register("clay_slab",
            () -> new BlockItem(ModBlocks.CLAY_SLAB.get(), SLAB_PROPERTIES));

    // 泥土台阶物品
    public static final RegistryObject<Item> DIRT_SLAB_ITEM = ITEMS.register("dirt_slab",
            () -> new BlockItem(ModBlocks.DIRT_SLAB.get(), SLAB_PROPERTIES));
}