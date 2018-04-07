package com.beetrootmonkey.eattheworld.item;

import com.beetrootmonkey.eattheworld.config.Config;
import com.beetrootmonkey.eattheworld.init.EatTheWorld;
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
	public static Item cocoa_powder;
	public static Item cooked_bat;
	public static Item cooked_cat;
	public static Item cooked_dragon;
	public static Item cooked_endermite;
	public static Item cooked_guardian;
	public static Item cooked_horse;
	public static Item cooked_shulker;
	public static Item cooked_silverfish;
	public static Item cooked_spider_eye;
	public static Item cooked_spider_leg;
	public static Item cooked_squid;
	public static Item cooked_villager;
	public static Item cooked_wolf;
	public static Item dough;
	public static Item fat;
	public static Item flour;
	public static Item fuel_pellet;
	public static Item gelatin;
	public static Item horse_hair;
	public static Item jelly_cube;
	public static Item raw_bat;
	public static Item raw_bread;
	public static Item raw_cat;
	public static Item raw_cookie;
	public static Item raw_dragon;
	public static Item raw_endermite;
	public static Item raw_ghast;
	public static Item raw_guardian;
	public static Item raw_horse;
	public static Item raw_shulker;
	public static Item raw_silverfish;
	public static Item raw_spider_leg;
	public static Item raw_squid;
	public static Item raw_villager;
	public static Item raw_wolf;
	public static Item withered_bone;

	public static void init() {
		cocoa_powder = register(new ItemBase("cocoa_powder"));
		cooked_bat = register(new ItemModFood("cooked_bat", 4, 5f, true));
		cooked_cat = register(new ItemModFood("cooked_cat", 5, 6f, true));
		cooked_dragon = register(new ItemModFood("cooked_dragon", 1, 1f, true));
//		cooked_endermite = register(new ItemModFood("cooked_endermite", 1, 1f));
		cooked_guardian = register(new ItemModFood("cooked_guardian", 5, 6f, true));
		cooked_horse = register(new ItemModFood("cooked_horse", 8, 12.8f, true));
		cooked_shulker = register(new ItemModFood("cooked_shulker", 4, 8f, true));
		cooked_silverfish = register(new ItemModFood("cooked_silverfish", 4, 5f, true));
		cooked_spider_eye = register(new ItemModFood("cooked_spider_eye", 4, 5f, true));
		cooked_spider_leg = register(new ItemModFood("cooked_spider_leg", 1, 1f, true));
		cooked_squid = register(new ItemModFood("cooked_squid", 5, 8f, true));
		cooked_villager = register(new ItemModFood("cooked_villager", 6, 9.6f, true));
		cooked_wolf = register(new ItemModFood("cooked_wolf", 5, 6f, true));
		dough = register(new ItemBase("dough"));
		fat = register(new ItemFuel("fat", Config.Recipes.fatAsFuel));
		flour = register(new ItemBase("flour"));
		fuel_pellet = register(new ItemFuel("fuel_pellet", 200));
		gelatin = register(new ItemBase("gelatin"));
		horse_hair = register(new ItemBase("horse_hair"));
		jelly_cube = register(new ItemBase("jelly_cube"));
		raw_bat = register(new ItemModFood("raw_bat", 1, 0.3f, true));
		raw_bread = register(new ItemBase("raw_bread"));
		raw_cat = register(new ItemModFood("raw_cat", 2, 0.3f, true));
		raw_cookie = register(new ItemModFood("raw_cookie", 1, 0.3f));
		raw_dragon = register(new ItemModFood("raw_dragon", 1, 1f, true));
//		raw_endermite = register(new ItemModFood("raw_endermite", 1, 1f));
		raw_ghast = register(new ItemModFood("raw_ghast", 4, 6f, true));
		raw_guardian = register(new ItemModFood("raw_guardian", 2, 0.4f, true));
		raw_horse = register(new ItemModFood("raw_horse", 3, 1.8f, true));
		raw_shulker = register(new ItemModFood("raw_shulker", 1, 0.1f, true));
		raw_silverfish = register(new ItemModFood("raw_silverfish", 1, 0.1f, true));
		raw_spider_leg = register(new ItemModFood("raw_spider_leg", 1, 0.2f, true));
		raw_squid = register(new ItemModFood("raw_squid", 2, 0.4f, true));
		raw_villager = register(new ItemModFood("raw_villager", 2, 0.4f, true));
		raw_wolf = register(new ItemModFood("raw_wolf", 2, 0.4f, true));
		withered_bone = register(new ItemBase("withered_bone"));
		
		
		
		
		
		
		
		
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) {
			((ItemModelProvider) item).registerItemModel(item);
		}

		return item;
	}
	
	public static void registerOres() {
		OreDictionary.registerOre("listAllmeatraw", raw_cat);
		OreDictionary.registerOre("listAllmeatraw", raw_dragon);
		OreDictionary.registerOre("listAllmeatraw", raw_ghast);
		OreDictionary.registerOre("listAllmeatraw", raw_horse);
		OreDictionary.registerOre("listAllmeatraw", raw_villager);
		OreDictionary.registerOre("listAllmeatraw", raw_wolf);

		OreDictionary.registerOre("listAllfishraw", raw_guardian);
		OreDictionary.registerOre("listAllfishraw", raw_squid);
		
		OreDictionary.registerOre("listAllmeatcooked", cooked_cat);
		OreDictionary.registerOre("listAllmeatcooked", cooked_dragon);
		OreDictionary.registerOre("listAllmeatcooked", cooked_horse);
		OreDictionary.registerOre("listAllmeatcooked", cooked_villager);
		OreDictionary.registerOre("listAllmeatcooked", cooked_wolf);

		OreDictionary.registerOre("listAllfishcooked", cooked_guardian);
		OreDictionary.registerOre("listAllfishcooked", cooked_squid);
		
		OreDictionary.registerOre("itemFat", fat);
		OreDictionary.registerOre("foodCocoapowder", cocoa_powder);
		OreDictionary.registerOre("foodDough", dough);
		OreDictionary.registerOre("foodFlour", flour);
		OreDictionary.registerOre("slimeball", gelatin);
	}
}