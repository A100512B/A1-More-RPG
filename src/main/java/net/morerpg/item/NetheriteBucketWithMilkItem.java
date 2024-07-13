package net.morerpg.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.morerpg.registry.MoreItemRegistry;

public class NetheriteBucketWithMilkItem extends MilkBucketItem {
    public NetheriteBucketWithMilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient) {
            user.clearStatusEffects();
        }
        if (user instanceof PlayerEntity playerEntity) {
            return ItemUsage.exchangeStack(stack, playerEntity, new ItemStack(MoreItemRegistry.NETHERITE_BUCKET), false);
        }
        stack.decrementUnlessCreative(1, user);
        return stack;
    }
}
