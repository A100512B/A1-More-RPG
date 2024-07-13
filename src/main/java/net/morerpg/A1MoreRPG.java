package net.morerpg;

import net.fabricmc.api.ModInitializer;
import net.morerpg.registry.MoreBlockRegistry;
import net.morerpg.registry.MoreFluidRegistry;
import net.morerpg.registry.MoreItemGroupRegistry;
import net.morerpg.registry.MoreItemRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A1MoreRPG implements ModInitializer {
    public static final String MOD_ID = "morerpg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Init A1's More RPG: Begin");
        MoreFluidRegistry.register();
        MoreItemRegistry.register();
        MoreItemGroupRegistry.register();
        MoreBlockRegistry.register();
        LOGGER.info("Init A1's More RPG: Success");
    }
}
