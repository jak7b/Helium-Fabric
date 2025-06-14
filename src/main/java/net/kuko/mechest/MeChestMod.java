package net.kuko.mechest;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kuko.mechest.Config.MyConfig;
import net.kuko.mechest.Init.BlockInit;
import net.kuko.mechest.Init.ItemInit;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MeChestMod implements ModInitializer {
	public static final String MOD_ID = "mechest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MyConfig CONFIG = MyConfig.createAndLoad();






	@Override
	public void onInitialize() {
		LOGGER.info("MeChest Mod Initialized!");

		FieldRegistrationHandler.register(ItemInit.class, MOD_ID, false);
		FieldRegistrationHandler.register(BlockInit.class, MOD_ID, false);

		addToTab(ItemGroups.FOOD_AND_DRINK, entries ->
				entries.add(ItemInit.BLACKBERRY)
		);

		addToTab(ItemGroups.TOOLS, entries -> {

			entries.add(ItemInit.ADVANCED);
			entries.add(ItemInit.JAVA_ITEM);
			entries.add(ItemInit.VISUAL_ITEM);

		});

		addToTab(ItemGroups.BUILDING_BLOCKS, entries ->
				entries.add(BlockInit.CLEAR_GLASS)
		);

	}


	private void addToTab(RegistryKey<ItemGroup> itemGroupKey, ItemGroupEvents.ModifyEntries entryModifier) {
		ItemGroupEvents.modifyEntriesEvent(itemGroupKey).register(entryModifier);
	}
}