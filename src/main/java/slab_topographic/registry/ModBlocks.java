package slab_topographic.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import slab_topographic.slab_topographic;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, slab_topographic.MODID);

    // 草台阶
    public static final RegistryObject<Block> GRASS_SLAB = BLOCKS.register("grass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    // 覆雪草台阶
    public static final RegistryObject<Block> SNOWY_GRASS_SLAB = BLOCKS.register("snowy_grass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    // 沙子台阶
    public static final RegistryObject<Block> SAND_SLAB = BLOCKS.register("sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    // 红沙台阶
    public static final RegistryObject<Block> RED_SAND_SLAB = BLOCKS.register("red_sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    // 土径台阶
    public static final RegistryObject<Block> DIRT_PATH_SLAB = BLOCKS.register("dirt_path_slab",
            () -> new DirtPathSlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    // 砂砾台阶
    public static final RegistryObject<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.6F)
                    .sound(SoundType.GRAVEL)));

    // 灰化土台阶
    public static final RegistryObject<Block> PODZOL_SLAB = BLOCKS.register("podzol_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    // 菌丝土台阶
    public static final RegistryObject<Block> MYCELIUM_SLAB = BLOCKS.register("mycelium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    // 粘土台阶
    public static final RegistryObject<Block> CLAY_SLAB = BLOCKS.register("clay_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.CLAY)
                    .strength(0.6F)
                    .sound(SoundType.SOUL_SAND)));

    // 泥土台阶
    public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.5F)
                    .sound(SoundType.GRAVEL)));

    // 自定义土径台阶类
    public static class DirtPathSlabBlock extends SlabBlock {
        protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
        protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 15.0D, 16.0D);
        protected static final VoxelShape DOUBLE_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

        public DirtPathSlabBlock(BlockBehaviour.Properties properties) {
            super(properties);
        }

        @Override
        public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, net.minecraft.world.phys.shapes.@NotNull CollisionContext context) {
            SlabType slabtype = state.getValue(TYPE);
            return switch (slabtype) {
                case DOUBLE -> DOUBLE_AABB;
                case TOP -> TOP_AABB;
                default -> BOTTOM_AABB;
            };
        }
    }
}