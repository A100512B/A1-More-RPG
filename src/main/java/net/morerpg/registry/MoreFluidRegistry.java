package net.morerpg.registry;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.morerpg.A1MoreRPG;
import net.morerpg.fluid.BlazingBloodFluid;

public class MoreFluidRegistry {
    public static final FlowableFluid BLAZING_BLOOD_STILL = new BlazingBloodFluid.Still();
    public static final FlowableFluid BLAZING_BLOOD_FLOWING = new BlazingBloodFluid.Flowing();

    public static void register() {
        Registry.register(Registries.FLUID, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood_still"), BLAZING_BLOOD_STILL);
        Registry.register(Registries.FLUID, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood_flowing"), BLAZING_BLOOD_FLOWING);
    }
}
