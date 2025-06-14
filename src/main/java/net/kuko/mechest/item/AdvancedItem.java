package net.kuko.mechest.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.UseAction;

public class AdvancedItem extends Item {
    public AdvancedItem(Settings settings) {
        super(settings);
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        MinecraftClient minecraft = MinecraftClient.getInstance();
        ClientPlayerEntity client = minecraft.player;
        if (minecraft != null) {
            if (client != null && client.isSneaking()) {
                // Player is sneaking (shifting)
                // Do something special here, like return a different UseAction

                String msg = String.format(
                        "Player: %s, is Sneaking And Right Clicked %s, at %s",
                        client.getName().getString(),
                        stack.getName().getString(),
                        client.getPos().toString()
                );
                client.sendMessage(Text.literal(msg), false);

                return UseAction.BOW; // example
            }
        }
        return super.getUseAction(stack);
    }


    @Override
    public boolean hasGlint(ItemStack stack) {
        // Show glint only if enchanted AND player is sneaking
        assert MinecraftClient.getInstance().player != null;
        if (MinecraftClient.getInstance().player.isSneaking()) {
            return true;
        }
        return false;
    }

}
