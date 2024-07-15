package net.morerpg.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.morerpg.fluid.NetheriteBucketItemGetter;
import net.morerpg.registry.MoreItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Bucketable.class)
public interface BucketableMixin {
    @Inject(method = "tryBucket", at = @At(value = "HEAD"), cancellable = true)
    private static <T extends LivingEntity & Bucketable> void tryBucket(PlayerEntity player, Hand hand, T entity, CallbackInfoReturnable<Optional<ActionResult>> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        boolean isAlive = entity.isAlive();
        if (itemStack.getItem() == Items.WATER_BUCKET && isAlive) {
            entity.playSound(entity.getBucketFillSound(), 1.0F, 1.0F);
            ItemStack itemStack2 = entity.getBucketItem();
            entity.copyDataToStack(itemStack2);
            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, itemStack2, false);
            player.setStackInHand(hand, itemStack3);
            World world = entity.getWorld();
            if (!world.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack2);
            }

            entity.discard();
            cir.setReturnValue(Optional.of(ActionResult.success(world.isClient)));
        } else if (itemStack.getItem() == MoreItemRegistry.NETHERITE_BUCKET_WITH_WATER && isAlive) {
            entity.playSound(entity.getBucketFillSound(), 1.0F, 1.0F);
            ItemStack itemStack2 = NetheriteBucketItemGetter.getNetheriteBucketItem(entity).getDefaultStack();
            entity.copyDataToStack(itemStack2);
            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, itemStack2, false);
            player.setStackInHand(hand, itemStack3);
            World world = entity.getWorld();
            if (!world.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack2);
            }

            entity.discard();
            cir.setReturnValue(Optional.of(ActionResult.success(world.isClient)));
        } else {
            cir.setReturnValue(Optional.empty());
        }
    }
}
