package com.beetrootmonkey.eattheworld.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.Loader;

public class Config {
	public static Configuration config = null;
	

	public static final boolean PAM_IS_HOME = false;
	public static final int DEFAULT_WHEAT_TO_FLOUR_RATIO = 1;
	public static final int DEFAULT_SEEDS_FROM_WHEAT_AMOUNT = 3;
	public static final int DEFAULT_SEEDS_TO_FLOUR_RATIO = 3;
	public static final int DEFAULT_FAT_BURN_TIME = 400;
	public static final int DEFAULT_BREAD_CONFIG_VALUE = 4;
	public static final int DEFAULT_COOKIE_CONFIG_VALUE = 4;
	public static final int DEFAULT_TORCHES_FROM_FAT = 2;
	public static final int DEFAULT_SQUID_CONFIG_VALUE = 1;



	public static String CATEGORY_DROPS = "mobdrops";
	public static String CATEGORY_RECIPES = "recipes";

	public static List<IConfigElement> getElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.addAll(new ConfigElement(config.getCategory(CATEGORY_DROPS)).getChildElements());
		list.addAll(new ConfigElement(config.getCategory(CATEGORY_RECIPES)).getChildElements());

		return list;
	}
	
	public static void checkLoadedMods() {
		Loader.isModLoaded("harvestcraft");
	}
	
	public static class Recipes {
		
		public static boolean cocoaPowder = true;
		public static boolean cookedBat = true;
		public static boolean cookedCat = true;
		public static boolean cookedDragon = true;
		public static boolean cookedGuardian = true;
		public static boolean cookedHorse = true;
		public static boolean cookedShulker = true;
		public static boolean cookedSilverfish = true;
		public static boolean cookedSpiderEye = true;
		public static boolean cookedSpiderLeg = true;
		public static boolean cookedSquid = true;
		public static boolean cookedVillager = true;
		public static boolean cookedWolf = true;
		// How much wheat is needed for 1 flour
		public static int wheatToFlour = DEFAULT_WHEAT_TO_FLOUR_RATIO;
		// How much seeds from 1 wheat
		public static int wheatToSeeds = DEFAULT_SEEDS_FROM_WHEAT_AMOUNT;
		// How much seeds are needed for 1 flour
		public static int seedsToFlour = DEFAULT_SEEDS_TO_FLOUR_RATIO;
		public static boolean dough = true;
		// Burntime, 0 = disable
		public static int fatAsFuel = DEFAULT_FAT_BURN_TIME;
		public static int fatForTorches = DEFAULT_TORCHES_FROM_FAT;
		public static boolean fuelPellet = true;
		public static boolean gelatin = true;
		public static boolean horseHairToString = true;
		public static boolean jelly = true;
		public static int bread = DEFAULT_BREAD_CONFIG_VALUE;
		public static int cookie = DEFAULT_COOKIE_CONFIG_VALUE;
	}
	
	public static class Drops {
		public static boolean bat = true;
		public static boolean cat = true;
		public static boolean dragon = true;
		public static boolean elderGuardian = true;
		public static boolean ghast = true;
		public static boolean guardian = true;
		public static boolean horse = true;
		public static boolean shulker = true;
		public static boolean silverfish = true;
		public static boolean cookedSpiderEye = true;
		public static boolean spiderLeg = true;
		public static int squid = DEFAULT_SQUID_CONFIG_VALUE;
		public static boolean villager = true;
		public static boolean wolf = true;
		public static boolean fat = true;
		public static boolean horseHair = true;
	}
}