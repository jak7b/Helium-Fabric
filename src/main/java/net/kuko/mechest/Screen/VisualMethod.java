package net.kuko.mechest.Screen;

import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import net.kuko.mechest.MeChestMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class VisualMethod extends BaseUIModelScreen<FlowLayout> {
    public static String name = "VisualMethod";

    public VisualMethod() {
        super(FlowLayout.class, DataSource.asset(
                Identifier.of(MeChestMod.MOD_ID, "visual_model")
        ));
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    protected void build(FlowLayout rootComponent) {


        Objects.requireNonNull(
                rootComponent.childById(ButtonComponent.class, "the-button")
        )
                .onPress(button -> {
            System.out.println("Button clicked!");
            // Add your button logic here
        });
    }

    public static void open() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.execute(() -> client.setScreen(new VisualMethod()));
        }
    }
}

