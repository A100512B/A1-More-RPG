package net.morerpg.registry;

import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.Rarity;
import net.morerpg.A1MoreRPG;
import net.morerpg.item.BlazingBloodBucketItem;
import net.morerpg.item.NetheriteBucketItem;
import net.morerpg.item.NetheriteBucketWithMilkItem;
import net.morerpg.item.NetheriteBucketWithPowderSnowItem;

import java.util.Arrays;

public class MoreItemRegistry {
    // Normal Items
    public static final Item CHORUS_AMULET
            = new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final Item BLAZING_BLOOD_BUCKET
            = new BlazingBloodBucketItem(MoreFluidRegistry.BLAZING_BLOOD_STILL, new Item.Settings().maxCount(1));
    public static final Item NETHERITE_BUCKET
            = new NetheriteBucketItem(Fluids.EMPTY, new Item.Settings().maxCount(16).fireproof());
    public static final Item NETHERITE_BUCKET_WITH_WATER
            = new NetheriteBucketItem(Fluids.WATER, new Item.Settings().maxCount(1).fireproof());
    public static final Item NETHERITE_BUCKET_WITH_LAVA
            = new NetheriteBucketItem(Fluids.LAVA, new Item.Settings().maxCount(1).fireproof());
    public static final Item NETHERITE_BUCKET_WITH_BLAZING_BLOOD
            = new NetheriteBucketItem(MoreFluidRegistry.BLAZING_BLOOD_STILL, new Item.Settings().maxCount(1).fireproof());
    public static final Item NETHERITE_BUCKET_WITH_AXOLOTL
            = new EntityBucketItem(EntityType.AXOLOTL, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_AXOLOTL, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item NETHERITE_BUCKET_WITH_COD
            = new EntityBucketItem(EntityType.COD, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item NETHERITE_BUCKET_WITH_MILK
            = new NetheriteBucketWithMilkItem(new Item.Settings().maxCount(1));
    public static final Item NETHERITE_BUCKET_WITH_POWDER_SNOW
            = new NetheriteBucketWithPowderSnowItem(Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1));
    public static final Item NETHERITE_BUCKET_WITH_PUFFERFISH
            = new EntityBucketItem(EntityType.PUFFERFISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item NETHERITE_BUCKET_WITH_SALMON
            = new EntityBucketItem(EntityType.SALMON, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item NETHERITE_BUCKET_WITH_TADPOLE
            = new EntityBucketItem(EntityType.TADPOLE, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_TADPOLE, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item NETHERITE_BUCKET_WITH_TROPICAL_FISH
            = new EntityBucketItem(EntityType.TROPICAL_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT));
    public static final Item BLAZING_GOLD_INGOT
            = new Item(new Item.Settings().fireproof());

    // for add to item group more easily
    @SuppressWarnings("unchecked")
    public static final Pair<String, Item>[] MORE_ITEMS_WITH_NAME = new Pair[] {
            new Pair<>("chorus_amulet", CHORUS_AMULET),
            new Pair<>("blazing_blood_bucket", BLAZING_BLOOD_BUCKET),
            new Pair<>("netherite_bucket", NETHERITE_BUCKET),
            new Pair<>("netherite_bucket_with_water", NETHERITE_BUCKET_WITH_WATER),
            new Pair<>("netherite_bucket_with_lava", NETHERITE_BUCKET_WITH_LAVA),
            new Pair<>("netherite_bucket_with_blazing_blood", NETHERITE_BUCKET_WITH_BLAZING_BLOOD),
            new Pair<>("netherite_bucket_with_axolotl", NETHERITE_BUCKET_WITH_AXOLOTL),
            new Pair<>("netherite_bucket_with_cod", NETHERITE_BUCKET_WITH_COD),
            new Pair<>("netherite_bucket_with_milk", NETHERITE_BUCKET_WITH_MILK),
            new Pair<>("netherite_bucket_with_powder_snow", NETHERITE_BUCKET_WITH_POWDER_SNOW),
            new Pair<>("netherite_bucket_with_pufferfish", NETHERITE_BUCKET_WITH_PUFFERFISH),
            new Pair<>("netherite_bucket_with_salmon", NETHERITE_BUCKET_WITH_SALMON),
            new Pair<>("netherite_bucket_with_tadpole", NETHERITE_BUCKET_WITH_TADPOLE),
            new Pair<>("netherite_bucket_with_tropical_fish", NETHERITE_BUCKET_WITH_TROPICAL_FISH),
            new Pair<>("blazing_blood_ingot", BLAZING_GOLD_INGOT)
    };

    @SuppressWarnings("unchecked")
    public static final Pair<String, Item>[] MORE_BLOCK_ITEMS_WITH_NAME = new Pair[] {
    };

    public static void register() {
        Arrays.stream(MORE_ITEMS_WITH_NAME).forEach(pair -> Registry.register(Registries.ITEM, Identifier.of(A1MoreRPG.MOD_ID, pair.getLeft()), pair.getRight()));
        Arrays.stream(MORE_BLOCK_ITEMS_WITH_NAME).forEach(pair -> Registry.register(Registries.ITEM, Identifier.of(A1MoreRPG.MOD_ID, pair.getLeft()), pair.getRight()));
    }
}
