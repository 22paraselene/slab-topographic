package slab_topographic.client;

import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slab_topographic.registry.ModBlocks;
import slab_topographic.registry.ModItems;
import slab_topographic.slab_topographic;

@Mod.EventBusSubscriber(modid = slab_topographic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockColorHandler {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((state, level, pos, tintIndex) -> {
            if (level != null && pos != null) {
                return net.minecraft.client.renderer.BiomeColors.getAverageGrassColor(level, pos);
            }
            return GrassColor.get(0.5D, 1.0D);
        }, ModBlocks.GRASS_SLAB.get());
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> {
            return GrassColor.get(0.5D, 1.0D);
        }, ModItems.GRASS_SLAB_ITEM.get());
    }
}