package net.kuko.mechest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.kuko.mechest.Client.KeyBindHandler;
import net.kuko.mechest.Init.BlockInit;
import net.kuko.mechest.Init.ItemInit;
import net.kuko.mechest.Screen.JavaMethod; // Import the Java screen
import net.kuko.mechest.Screen.VisualMethod;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MeChestModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		blackBerry(0x3C1724);

		BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.CLEAR_GLASS, RenderLayer.getTranslucent());

		KeyBindHandler.registrateKeyBinds();
	}

	public void blackBerry(int color) {
		ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
						tintIndex == 0 ? color : -1,
				ItemInit.BLACKBERRY
		);
	}
}