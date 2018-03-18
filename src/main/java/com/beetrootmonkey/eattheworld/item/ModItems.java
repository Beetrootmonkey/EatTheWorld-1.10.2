package com.beetrootmonkey.eattheworld.item;

import com.beetrootmonkey.eattheworld.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.armor.ItemModArmor;
import com.beetrootmonkey.eattheworld.item.edible.ItemBuff;
import com.beetrootmonkey.eattheworld.item.edible.ItemModFood;
import com.beetrootmonkey.eattheworld.item.fuel.ItemFuel;
import com.beetrootmonkey.eattheworld.item.materials.ModArmorMaterials;
import com.beetrootmonkey.eattheworld.item.materials.ModToolMaterials;
import com.beetrootmonkey.eattheworld.item.tools.ItemModAxe;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
	public static ItemFuel pelletFuel;
	public static ItemModFood raw_horse;
	public static ItemModFood cooked_horse;
	public static ItemBuff raw_villager;
	public static ItemModFood cooked_villager;
	public static ItemBase gelatin;
	public static ItemModFood cooked_spider_eye;

	public static void init() {
		pelletFuel = register(new ItemFuel("pelletFuel", 200));
		raw_horse = register(new ItemModFood("raw_horse", 3, 1.8f));
		cooked_horse = register(new ItemModFood("cooked_horse", 8, 12.8f));
		raw_villager = register(new ItemBuff("raw_villager", 2, 0.4f,
				new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:hunger"), 600, 0),
				0.8f));
		cooked_villager = register(new ItemModFood("cooked_villager", 6, 9.6f));
		gelatin = register(new ItemBase("gelatin"));
		cooked_spider_eye = register(new ItemModFood("cooked_spider_eye", 4, 5f));
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) {
			((ItemModelProvider) item).registerItemModel(item);
		}

		return item;
	}
	
	public static void registerOres() {
		OreDictionary.registerOre("slimeball", gelatin);
	}
}