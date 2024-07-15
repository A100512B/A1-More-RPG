package net.morerpg.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.morerpg.registry.MoreCauldronBehaviorRegistry;

public class BlazingBloodCauldronBlock extends AbstractCauldronBlock {
    public static final MapCodec<BlazingBloodCauldronBlock> CODEC = createCodec(BlazingBloodCauldronBlock::new);
    public static final IntProperty LEVEL = Properties.LEVEL_3;

    public BlazingBloodCauldronBlock(AbstractBlock.Settings settings) {
        super(settings, MoreCauldronBehaviorRegistry.BLAZING_BLOOD_BEHAVIOR);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> getCodec() {
        return CODEC;
    }

    @Override
    public boolean isFull(BlockState state) {
        return true;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (this.isEntityTouchingFluid(state, pos, entity)) {
            entity.setOnFireFromLava();
        }
    }
}
