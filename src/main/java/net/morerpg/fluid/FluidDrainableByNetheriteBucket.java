package net.morerpg.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.morerpg.registry.MoreItemRegistry;
import org.jetbrains.annotations.Nullable;

public class FluidDrainableByNetheriteBucket {
    public static ItemStack tryDrainFluidByNetheriteBucket(FluidDrainable fluid, @Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        ItemStack itemStack = fluid.tryDrainFluid(player, world, pos, state);
        if (RegistryEntry.of(itemStack.getItem()).equals(RegistryEntry.of(Items.WATER_BUCKET))) {
            return new ItemStack(MoreItemRegistry.NETHERITE_BUCKET_WITH_WATER, itemStack.getCount());
        } else if (RegistryEntry.of(itemStack.getItem()).equals(RegistryEntry.of(Items.LAVA_BUCKET))) {
            return new ItemStack(MoreItemRegistry.NETHERITE_BUCKET_WITH_LAVA, itemStack.getCount());
        } else if (RegistryEntry.of(itemStack.getItem()).equals(RegistryEntry.of(MoreItemRegistry.BLAZING_BLOOD_BUCKET))) {
            return new ItemStack(MoreItemRegistry.NETHERITE_BUCKET_WITH_BLAZING_BLOOD, itemStack.getCount());
        }
        return ItemStack.EMPTY;
    }
}
