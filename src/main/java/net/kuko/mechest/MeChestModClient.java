package net.kuko.mechest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class MeChestModClient implements ClientModInitializer {

	/**
	 * Runs the mod initializer on the client environment.
	 */
	@Override
	public void onInitializeClient() {
		// Register color provider for your item
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
			// Return color based on tint index
			if (tintIndex == 0) {
				return 0xFF0000; // Red tint for layer 0
			}
			return 0xFFFFFF; // Default white
		}, Items.NETHERITE_INGOT);
	}
}