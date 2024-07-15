package net.morerpg.mixin;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.morerpg.A1MoreRPG;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow protected boolean firstUpdate;
    @Shadow protected Object2DoubleMap<TagKey<Fluid>> fluidHeight;
    @Shadow public abstract boolean damage(DamageSource source, float amount);
    @Shadow public abstract DamageSources getDamageSources();

    @Inject(method = "baseTick", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/Entity;isInLava()Z", ordinal = 0), cancellable = true)
    public void baseTick(CallbackInfo ci) {
        if (!this.firstUpdate && this.fluidHeight.getDouble(TagKey.of(RegistryKeys.FLUID, Identifier.of(A1MoreRPG.MOD_ID, "blazing_blood"))) > 0.0) {
            this.damage(this.getDamageSources().onFire(), 2.0F);
            ci.cancel();
        }
    }
}
