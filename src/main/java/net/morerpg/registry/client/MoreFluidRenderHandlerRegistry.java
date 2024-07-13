package net.morerpg.registry.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.morerpg.registry.MoreFluidRegistry;

import static net.morerpg.registry.MoreFluidRegistry.BLAZING_BLOOD_FLOWING;
import static net.morerpg.registry.MoreFluidRegistry.BLAZING_BLOOD_STILL;

public class MoreFluidRenderHandlerRegistry {
    public static final int BLAZING_BLOOD_TINT = 0xFF5828;

    public static final FluidRenderHandler BLAZING_BLOOD_RENDER_HANDLER
            = new SimpleFluidRenderHandler(SimpleFluidRenderHandler.LAVA_STILL, SimpleFluidRenderHandler.LAVA_FLOWING, BLAZING_BLOOD_TINT);

    public static void register() {
        FluidRenderHandlerRegistry.INSTANCE.register(BLAZING_BLOOD_STILL, MoreFluidRegistry.BLAZING_BLOOD_FLOWING, BLAZING_BLOOD_RENDER_HANDLER);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), BLAZING_BLOOD_STILL, BLAZING_BLOOD_FLOWING);
    }
}
