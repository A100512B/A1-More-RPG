package net.morerpg.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.morerpg.registry.MoreItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {
    @Inject(method = "isPlayerStaring", at = @At("HEAD"), cancellable = true)
    private void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        PlayerInventory inventory = player.getInventory();
        if (inventory.contains(new ItemStack(MoreItemRegistry.CHORUS_AMULET))) cir.setReturnValue(false);
    }
}
