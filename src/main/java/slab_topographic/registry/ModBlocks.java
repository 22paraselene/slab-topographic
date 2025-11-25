package slab_topographic.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slab_topographic.slab_topographic;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                slab_topographic.MODID);

        // 草方块台阶
        public static final RegistryObject<Block> GRASS_SLAB = BLOCKS.register("grass_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.GRASS)
                        .strength(0.5F)
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.NORMAL)
                        .isValidSpawn((state, getter, pos, type) -> true)));

        // 覆雪草方块台阶
        public static final RegistryObject<Block> SNOWY_GRASS_SLAB = BLOCKS.register("snowy_grass_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.SNOW)
                        .strength(0.5F)
                        .sound(SoundType.SNOW)
                        .pushReaction(PushReaction.NORMAL)
                        .isValidSpawn((state, getter, pos, type) -> true)) {
                        @Override
                        public @Nullable BlockState getToolModifiedState(BlockState state, net.minecraft.world.item.context.UseOnContext context, ToolAction toolAction, boolean simulate) {
                                if (ToolActions.SHOVEL_FLATTEN.equals(toolAction)) {
                                        return ModBlocks.GRASS_SLAB.get().defaultBlockState().setValue(TYPE, state.getValue(TYPE));
                                }
                                return super.getToolModifiedState(state, context, toolAction, simulate);
                        }
                });

        // 沙子台阶
        public static final RegistryObject<Block> SAND_SLAB = BLOCKS.register("sand_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.SAND)
                        .strength(0.4F)
                        .sound(SoundType.SAND)
                        .pushReaction(PushReaction.NORMAL)));

        // 红沙台阶
        public static final RegistryObject<Block> RED_SAND_SLAB = BLOCKS.register("red_sand_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .strength(0.4F)
                        .sound(SoundType.SAND)
                        .pushReaction(PushReaction.NORMAL)));

        // 土径台阶
        public static final RegistryObject<Block> DIRT_PATH_SLAB = BLOCKS.register("dirt_path_slab",
                () -> new DirtPathSlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.DIRT)
                        .strength(0.5F)
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.NORMAL)));

        // 砂砾台阶
        public static final RegistryObject<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .strength(0.4F)
                        .sound(SoundType.GRAVEL)
                        .pushReaction(PushReaction.NORMAL)));

        // 灰化土台阶
        public static final RegistryObject<Block> PODZOL_SLAB = BLOCKS.register("podzol_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BROWN)
                        .strength(0.5F)
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.NORMAL)));

        // 菌丝土台阶
        public static final RegistryObject<Block> MYCELIUM_SLAB = BLOCKS.register("mycelium_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_PURPLE)
                        .strength(0.5F)
                        .sound(SoundType.GRASS)
                        .pushReaction(PushReaction.NORMAL)));

        // 粘土台阶
        public static final RegistryObject<Block> CLAY_SLAB = BLOCKS.register("clay_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.CLAY)
                        .strength(0.5F)
                        .sound(SoundType.SOUL_SAND)
                        .pushReaction(PushReaction.NORMAL)));

        // 泥土台阶
        public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.DIRT)
                        .strength(0.4F)
                        .sound(SoundType.GRAVEL)
                        .pushReaction(PushReaction.NORMAL)));

        // 自定义土径台阶类
        public static class DirtPathSlabBlock extends SlabBlock {
                protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
                protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 15.0D, 16.0D);
                protected static final VoxelShape DOUBLE_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

                public DirtPathSlabBlock(BlockBehaviour.Properties properties) {
                        super(properties);
                }

                @Override
                public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos,
                                                    net.minecraft.world.phys.shapes.@NotNull CollisionContext context) {
                        SlabType slabtype = state.getValue(TYPE);
                        return switch (slabtype) {
                                case DOUBLE -> DOUBLE_AABB;
                                case TOP -> TOP_AABB;
                                default -> BOTTOM_AABB;
                        };
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, net.minecraft.world.item.context.UseOnContext context, ToolAction toolAction, boolean simulate) {
                        if (ToolActions.SHOVEL_FLATTEN.equals(toolAction)) {
                                // 当用锹右击时，可以转换为其他类型的台阶
                                return ModBlocks.DIRT_SLAB.get().defaultBlockState().setValue(TYPE, state.getValue(TYPE));
                        }
                        return super.getToolModifiedState(state, context, toolAction, simulate);
                }
        }
}