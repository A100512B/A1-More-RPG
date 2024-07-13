package net.morerpg.item;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.morerpg.registry.MoreBlockRegistry;
import net.morerpg.util.Probability;

public class BlazingBloodBucketItem extends BucketItem {

    public BlazingBloodBucketItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (Probability.of(200)) {
            stack.setCount(0);
            world.setBlockState(entity.getBlockPos(), MoreBlockRegistry.BLAZING_BLOOD.getDefaultState());
            entity.playSound(SoundEvent.of(Identifier.of("item.bucket.empty_lava")), 1.0F, 1.0F);
            entity.playSound(SoundEvent.of(Identifier.of("entity.item.break")), 1.0F, 1.0F);
        }
    }
}
