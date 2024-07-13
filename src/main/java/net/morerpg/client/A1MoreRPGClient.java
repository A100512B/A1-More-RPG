package net.morerpg.client;

import net.fabricmc.api.ClientModInitializer;
import net.morerpg.registry.client.MoreFluidRenderHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A1MoreRPGClient implements ClientModInitializer {
    public static final String MOD_ID = "morerpg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Init A1's More RPG (Client): Begin");
        MoreFluidRenderHandlerRegistry.register();
        LOGGER.info("Init A1's More RPG (Client): Success");
    }
}
