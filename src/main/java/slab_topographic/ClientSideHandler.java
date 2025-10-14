package slab_topographic;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slab_topographic.registry.ModBlocks;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSideHandler {
    @SubscribeEvent
    public static void clientSetup(net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent event) {
        net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.GRASS_SLAB.get(),
                net.minecraft.client.renderer.RenderType.cutoutMipped()
        );
    }
}
