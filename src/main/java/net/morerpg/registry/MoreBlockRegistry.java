package net.morerpg.registry;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.morerpg.A1MoreRPG;

public class MoreBlockRegistry {
    public static final Block BLAZING_BLOOD =
            new FluidBlock(MoreFluidRegistry.BLAZING_BLOOD_STILL, AbstractBlock.Settings.copy(Blocks.LAVA)) {};
    public static final Block BLAZING_BLOOD_CAULDRON =
            new LeveledCauldronBlock(Biome.Precipitation.NONE, MoreCauldronBehaviorRegistry.BLAZING_BLOOD_BEHAVIOR, AbstractBlock.Settings.copyShallow(Blocks.CAULDRON));

    public static void register() {
        Registry.register(Registries.BLOCK, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood"), BLAZING_BLOOD);
        Registry.register(Registries.BLOCK, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood_cauldron"), BLAZING_BLOOD_CAULDRON);
    }
}
