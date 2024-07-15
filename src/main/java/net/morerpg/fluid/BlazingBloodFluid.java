package net.morerpg.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.morerpg.registry.MoreBlockRegistry;
import net.morerpg.registry.MoreFluidRegistry;
import net.morerpg.registry.MoreItemRegistry;

public abstract class BlazingBloodFluid extends FlowableFluid {
    public static class Flowing extends BlazingBloodFluid {
        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            builder.add(LEVEL);
            builder.add(FALLING);
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

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            builder.add(FALLING);
        }
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(1501, pos, 0);
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return world.getDimension().ultrawarm() ? 2 : 4;
    }

    @Override
    public int getTickRate(WorldView world) {
        return world.getDimension().ultrawarm() ? 20 : 60;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return MoreBlockRegistry.BLAZING_BLOOD.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public Item getBucketItem() {
        return MoreItemRegistry.BLAZING_BLOOD_BUCKET;
    }

    @Override
    public Fluid getFlowing() {
        return MoreFluidRegistry.BLAZING_BLOOD_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return MoreFluidRegistry.BLAZING_BLOOD_STILL;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        this.playExtinguishEvent(world, pos);
    }

    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 2;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return state.getHeight(world, pos) >= 0.44444445F && fluid.isIn(FluidTags.LAVA);
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }
}
