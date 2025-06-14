package net.kuko.mechest.Client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.kuko.mechest.Screen.JavaMethod;
import net.kuko.mechest.Screen.VisualMethod;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class KeyBindHandler {
    // Define key bindings as public static final for easy access
    public static final KeyBinding OPEN_VISUAL_KEY = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                    "key.mechest.open_screen_visual",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_V,
                    "category.mechest"
            )
    );

    public static final KeyBinding OPEN_JAVA_KEY = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                    "key.mechest.open_screen_java",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_J,
                    "category.mechest"
            )
    );

    // Optional: Keep a list if you need to iterate over all bindings
    public static final List<KeyBinding> ALL_KEY_BINDINGS = List.of(OPEN_VISUAL_KEY, OPEN_JAVA_KEY);

    public static void registrateKeyBinds() {
        // Register key handlers using method references
        registerKeyHandler(OPEN_VISUAL_KEY, VisualMethod::open);
        registerKeyHandler(OPEN_JAVA_KEY, JavaMethod::open);
    }

    /**
     * Registers a key handler for a specific screen
     *
     * @param keyBinding The key binding to listen for
     * @param openAction The action to perform when the key is pressed
     */
    private static void registerKeyHandler(KeyBinding keyBinding, Runnable openAction) {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.wasPressed()) {
                openAction.run();
            }
        });
    }
}