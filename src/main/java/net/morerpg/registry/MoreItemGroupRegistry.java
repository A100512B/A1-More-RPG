package net.morerpg.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.morerpg.A1MoreRPG;

import java.util.Arrays;

public class MoreItemGroupRegistry {
    public static final ItemGroup MORERPG_ITEM_GROUP
            = FabricItemGroup.builder().icon(() -> new ItemStack(MoreItemRegistry.CHORUS_AMULET))
            .displayName(Text.translatable("itemGroup.morerpg.item"))
            .entries((context, entries) -> {
                Arrays.stream(MoreItemRegistry.MORE_ITEMS_WITH_NAME).forEach(pair -> entries.add(pair.getRight()));
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(A1MoreRPG.MOD_ID, "item_group"), MORERPG_ITEM_GROUP);
    }
}
