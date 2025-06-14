package net.kuko.mechest.Init;

import io.wispforest.owo.registration.annotations.AssignedName;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.kuko.mechest.item.AdvancedItem;
import net.kuko.mechest.item.Java;
import net.kuko.mechest.item.Visual;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemInit implements ItemRegistryContainer {

    @AssignedName("java")
    public static final Item JAVA_ITEM = new Java(new Item.Settings());

    @AssignedName("visual")
    public static final Item VISUAL_ITEM = new Visual(new Item.Settings());



    public static final Item BLACKBERRY = new Item(new Item.Settings());
    // registered as 'mod_id:blackberry'

    @AssignedName("debug_item")
    public static final Item ADVANCED = new AdvancedItem(new Item.Settings());

    //public static final Item BANANA = new Item(new Item.Settings());
    @SuppressWarnings("unused")
    public static final String notAnItem = "this will be ignored";
} // 	public static final Item DEBUG_STICK = register("debug_stick",
// new DebugStickItem(new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));
