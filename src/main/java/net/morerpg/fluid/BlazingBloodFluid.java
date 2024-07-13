package net.morerpg.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.morerpg.registry.MoreBlockRegistry;
import net.morerpg.registry.MoreItemRegistry;

public abstract class BlazingBloodFluid extends LavaFluid {
    public static class Flowing extends BlazingBloodFluid {

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.getLevel();
        }
    }

    public static class Still extends BlazingBloodFluid {

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return super.getLevelDecreasePerBlock(world) * 2;
    }

    @Override
    public int getTickRate(WorldView world) {
        return super.getTickRate(world) * 2;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return MoreBlockRegistry.BLAZING_BLOOD.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public Item getBucketItem() {
        return MoreItemRegistry.BLAZING_BLOOD_BUCKET;
    }

    public Item getNetheriteBucketItem() {
        return MoreItemRegistry.NETHERITE_BUCKET_WITH_BLAZING_BLOOD;
    }
}
