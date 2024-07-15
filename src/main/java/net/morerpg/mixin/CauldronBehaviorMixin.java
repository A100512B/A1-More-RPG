package net.morerpg.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.morerpg.registry.MoreBlockRegistry;
import net.morerpg.registry.MoreItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

import static net.minecraft.block.cauldron.CauldronBehavior.FILL_WITH_LAVA;
import static net.minecraft.block.cauldron.CauldronBehavior.FILL_WITH_WATER;
import static net.morerpg.registry.MoreCauldronBehaviorRegistry.BLAZING_BLOOD_BEHAVIOR;
import static net.morerpg.registry.MoreCauldronBehaviorRegistry.FILL_WITH_BLAZING_BLOOD;
import static net.morerpg.registry.MoreCauldronBehaviorRegistry.CALCINE_NETHERITE_INGOT;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviorMixin {

    @Shadow static CauldronBehavior.CauldronBehaviorMap createMap(String name) {
        return null;
    }

    @Shadow static ItemActionResult fillCauldron(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
        return null;
    }

    @Unique private static ItemActionResult fillCauldronWithNetheriteBucket(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(MoreItemRegistry.NETHERITE_BUCKET)));
            player.incrementStat(Stats.FILL_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            world.setBlockState(pos, state);
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
        }

        return ItemActionResult.success(world.isClient);
    }

    @Inject(method = "registerBucketBehavior", at = @At("TAIL"))
    private static void registerBucketBehavior(Map<Item, CauldronBehavior> behavior, CallbackInfo ci) {
        behavior.put(MoreItemRegistry.NETHERITE_BUCKET_WITH_WATER, FILL_WITH_WATER);
        behavior.put(MoreItemRegistry.NETHERITE_BUCKET_WITH_LAVA, FILL_WITH_LAVA);
        behavior.put(MoreItemRegistry.BLAZING_BLOOD_BUCKET, FILL_WITH_BLAZING_BLOOD);
        behavior.put(MoreItemRegistry.NETHERITE_BUCKET_WITH_BLAZING_BLOOD, FILL_WITH_BLAZING_BLOOD);
    }

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerBehavior(CallbackInfo ci) {
        Map<Item, CauldronBehavior> map5 = BLAZING_BLOOD_BEHAVIOR.map();
        map5.put(Items.NETHERITE_INGOT, CALCINE_NETHERITE_INGOT);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void staticCauldronBehavior(CallbackInfo ci) {
        BLAZING_BLOOD_BEHAVIOR = createMap("blazing_blood");
        FILL_WITH_BLAZING_BLOOD = (state, world, pos, player, hand, stack) -> fillCauldronWithNetheriteBucket(world, pos, player, hand, stack, MoreBlockRegistry.BLAZING_BLOOD_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
        CALCINE_NETHERITE_INGOT = (state, world, pos, player, hand, stack) -> {
            if (!world.isClient) {
                ItemStack itemStack = new ItemStack(MoreItemRegistry.BLAZING_GOLD_INGOT);
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, itemStack, false));
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }
            return ItemActionResult.success(world.isClient);
        };
    }
}
