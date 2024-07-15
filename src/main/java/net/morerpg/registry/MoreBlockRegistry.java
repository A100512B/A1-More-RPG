package net.morerpg.registry;

import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.morerpg.A1MoreRPG;
import net.morerpg.block.BlazingBloodCauldronBlock;

public class MoreBlockRegistry {
    public static final Block BLAZING_BLOOD =
            new FluidBlock(MoreFluidRegistry.BLAZING_BLOOD_STILL, AbstractBlock.Settings.copy(Blocks.LAVA)) {};
    public static final Block BLAZING_BLOOD_CAULDRON =
            new BlazingBloodCauldronBlock(AbstractBlock.Settings.copy(Blocks.CAULDRON));

    public static void register() {
        Registry.register(Registries.BLOCK, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood"), BLAZING_BLOOD);
        Registry.register(Registries.BLOCK, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood_cauldron"), BLAZING_BLOOD_CAULDRON);
        CauldronFluidContent.registerCauldron(BLAZING_BLOOD_CAULDRON, MoreFluidRegistry.BLAZING_BLOOD_STILL, 27000, Properties.LEVEL_3);
    }
}
