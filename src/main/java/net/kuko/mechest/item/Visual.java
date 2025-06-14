package net.kuko.mechest.item;

import net.kuko.mechest.Screen.JavaMethod;
import net.kuko.mechest.Screen.VisualMethod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Visual extends Item {
    public Visual(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            VisualMethod.open();
            // Play custom sound at player location
            user.playSound(SoundEvents.BLOCK_BIG_DRIPLEAF_BREAK, 1.0F, 1.0F);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
