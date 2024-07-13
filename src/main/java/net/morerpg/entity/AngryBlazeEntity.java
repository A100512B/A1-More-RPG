package net.morerpg.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.world.World;

public class AngryBlazeEntity extends BlazeEntity {
    public AngryBlazeEntity(EntityType<? extends BlazeEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        if (isInLava()) {

        }
    }
}
