package net.morerpg.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;

public class NetheriteBucketWithPowderSnowItem extends PowderSnowBucketItem {
    public NetheriteBucketWithPowderSnowItem(Block block, SoundEvent placeSound, Settings settings) {
        super(block, placeSound, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult actionResult = super.useOnBlock(context);
        PlayerEntity playerEntity = context.getPlayer();
        if (actionResult.isAccepted() && playerEntity != null) {
            playerEntity.setStackInHand(context.getHand(), NetheriteBucketItem.getEmptiedStack(context.getStack(), playerEntity));
        }
        return actionResult;
    }
}
