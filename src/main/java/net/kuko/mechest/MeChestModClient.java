package net.kuko.mechest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class MeChestModClient implements ClientModInitializer {

	private static final Color BASE_COLOR = new Color(255, 255, 255);

	@Override
	public void onInitializeClient() {
	//	changeColor(Items.NETHERITE_INGOT);
	}

	private void changeColor(Item item) {
		// Cache base color components once
		final int BASE_RED = BASE_COLOR.getRed();
		final int BASE_GREEN = BASE_COLOR.getGreen();
		final int BASE_BLUE = BASE_COLOR.getBlue();

		// Register color provider with real-time-based animation
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
			if (tintIndex != 0) return 0xFFFFFF;

			// Use time in milliseconds for smooth animation
			long millis = System.currentTimeMillis();
			int timeOffset = (int) (millis / 10 % 256); // update every ~10ms for 256-step cycle

			// Smooth cycling by offsetting base channels
			int red = (BASE_RED + timeOffset) & 0xFF;
			//int green = (BASE_GREEN + (timeOffset + 85)) & 0xFF;
			int blue = (BASE_BLUE + (timeOffset + 170)) & 0xFF;

			return (red << 16) | (BASE_GREEN << 8) | blue;
		}, item);
	}
}
