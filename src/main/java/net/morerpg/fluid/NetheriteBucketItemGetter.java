package net.morerpg.fluid;

import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.morerpg.registry.MoreFluidRegistry;
import net.morerpg.registry.MoreItemRegistry;

public class NetheriteBucketItemGetter {
    public static Item getNetheriteBucketItem(Fluid fluid) {
        if (fluid.matchesType(Fluids.WATER) || fluid.matchesType(Fluids.FLOWING_WATER)) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_WATER;
        } else if (fluid.matchesType(Fluids.LAVA) || fluid.matchesType(Fluids.FLOWING_LAVA)) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_LAVA;
        } else if (fluid.matchesType(MoreFluidRegistry.BLAZING_BLOOD_STILL) || fluid.matchesType(MoreFluidRegistry.BLAZING_BLOOD_FLOWING)) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_BLAZING_BLOOD;
        }
        return Items.AIR;
    }

    public static Item getNetheriteBucketItem(Bucketable bucketable) {
        RegistryEntry<Item> entryOfBucketableItem = RegistryEntry.of(bucketable.getBucketItem().getItem());
        if (entryOfBucketableItem.equals(RegistryEntry.of(Items.AXOLOTL_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_AXOLOTL;
        } else if (entryOfBucketableItem.equals(RegistryEntry.of(Items.COD_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_COD;
        } else if (entryOfBucketableItem.equals(RegistryEntry.of(Items.PUFFERFISH_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_PUFFERFISH;
        } else if (entryOfBucketableItem.equals(RegistryEntry.of(Items.SALMON_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_SALMON;
        } else if (entryOfBucketableItem.equals(RegistryEntry.of(Items.TADPOLE_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_TADPOLE;
        } else if (entryOfBucketableItem.equals(RegistryEntry.of(Items.TROPICAL_FISH_BUCKET))) {
            return MoreItemRegistry.NETHERITE_BUCKET_WITH_TROPICAL_FISH;
        }
        return Items.AIR;
    }
}
