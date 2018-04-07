package com.beetrootmonkey.eattheworld.config;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.beetrootmonkey.eattheworld.init.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

@Mod.EventBusSubscriber
public class ConfigLoader {

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MOD_ID)) {
			reloadConfig();
		}
	}

	private static void reloadConfig() {
		// boolean someConfigFlag = config.get(Configuration.CATEGORY_GENERAL,
		// "SomeConfigFlag", false).getBoolean(false);
		// Notice there is nothing that gets the value of this property so the
		// expression results in a Property object.
		// Property someProperty = config.get(Configuration.CATEGORY_GENERAL,
		// "SomeConfigString", "nothing");

		// Here we add a comment to our new property.
		// someProperty.comment = "This value can be read as a string!";

		// String someConfigString = someProperty.getString();

		//////////////////////// DROPS ////////////////////////
		Config.config.setCategoryComment(Config.CATEGORY_DROPS,
				"Wether the specified mob should have additional, custom drops");
		
		Config.Drops.bat = loadBoolean(Config.CATEGORY_DROPS, "bat", true,
				"Set this to false if you disable bat dropping meat");
		Config.Drops.cat = loadBoolean(Config.CATEGORY_DROPS, "cat", true,
				"Set this to false if you disable cats/ocelots dropping meat");
		Config.Drops.dragon = loadBoolean(Config.CATEGORY_DROPS, "dragon", true,
				"Set this to false if you disable the ender dragon dropping meat");
		Config.Drops.ghast = loadBoolean(Config.CATEGORY_DROPS, "ghast", true,
				"Set this to false if you disable ghasts dropping meat");
		Config.Drops.guardian = loadBoolean(Config.CATEGORY_DROPS, "guardian", true,
				"Set this to false if you disable guardians dropping meat");
		Config.Drops.elderGuardian = loadBoolean(Config.CATEGORY_DROPS, "elderGuardian", true,
				"Set this to false if you disable elder guardians dropping meat");
		Config.Drops.horse = loadBoolean(Config.CATEGORY_DROPS, "horse", true,
				"Set this to false if you disable horses/donkeys dropping meat");
		Config.Drops.shulker = loadBoolean(Config.CATEGORY_DROPS, "shulker", true,
				"Set this to false if you disable shulkers dropping meat");
		Config.Drops.silverfish = loadBoolean(Config.CATEGORY_DROPS, "silverfish", true,
				"Set this to false if you disable silverfish dropping meat");
		Config.Drops.cookedSpiderEye = loadBoolean(Config.CATEGORY_DROPS, "cookedSpiderEye", true,
				"Set this to false if you disable spiders dropping cooked spider eyes when they get killed while on fire");
		Config.Drops.spiderLeg = loadBoolean(Config.CATEGORY_DROPS, "spiderLeg", true,
				"Set this to false if you disable spiders dropping their legs");
		Config.Drops.squid = loadInt(Config.CATEGORY_DROPS, "squid", Config.DEFAULT_SQUID_CONFIG_VALUE,
				"0 = disable squid dropping meat,\n"
				+ "1 = enable squid dropping their meat but disable if harvestcraft is present,\n"
				+ "2 = force enable");
		Config.Drops.villager = loadBoolean(Config.CATEGORY_DROPS, "villager", true,
				"Set this to false if you disable villagers dropping meat");
		Config.Drops.wolf = loadBoolean(Config.CATEGORY_DROPS, "wolf", true,
				"Set this to false if you disable wolfs dropping meat");
		Config.Drops.fat = loadBoolean(Config.CATEGORY_DROPS, "fat", true,
				"Set this to false if you disable pigs dropping fat");
		Config.Drops.horseHair = loadBoolean(Config.CATEGORY_DROPS, "horseHair", true,
				"Set this to false if you disable horses/donkeys dropping hair");

		//////////////////////// RECIPES ////////////////////////
		Config.config.setCategoryComment(Config.CATEGORY_RECIPES, "Wether the specified recipes should be enabled");

		Config.Recipes.cocoaPowder = loadBoolean(Config.CATEGORY_RECIPES, "cocoaPowder", true,
				"Set this to false if you want to cookies to use cocoa beans instead of powder in its recipe");
		Config.Recipes.cookedBat = loadBoolean(Config.CATEGORY_RECIPES, "cookedBat", true,
				"Set this to false if you don't want to be able to cook raw bat meat");
		Config.Recipes.cookedCat = loadBoolean(Config.CATEGORY_RECIPES, "cookedCat", true,
				"Set this to false if you don't want to be able to cook raw cat meat");
		Config.Recipes.cookedDragon = loadBoolean(Config.CATEGORY_RECIPES, "cookedDragon", true,
				"Set this to false if you don't want to be able to cook raw ender dragon meat");
		Config.Recipes.cookedGuardian = loadBoolean(Config.CATEGORY_RECIPES, "cookedGuardian", true,
				"Set this to false if you don't want to be able to cook raw guardian meat");
		Config.Recipes.cookedHorse = loadBoolean(Config.CATEGORY_RECIPES, "cookedHorse", true,
				"Set this to false if you don't want to be able to cook raw horse meat");
		Config.Recipes.cookedShulker = loadBoolean(Config.CATEGORY_RECIPES, "cookedShulker", true,
				"Set this to false if you don't want to be able to cook raw shulker meat");
		Config.Recipes.cookedSilverfish = loadBoolean(Config.CATEGORY_RECIPES, "cookedSilverfish", true,
				"Set this to false if you don't want to be able to cook raw silverfish meat");
		Config.Recipes.cookedSpiderEye = loadBoolean(Config.CATEGORY_RECIPES, "cookedSpiderEye", true,
				"Set this to false if you don't want to be able to cook raw spider eyes");
		Config.Recipes.cookedSpiderLeg = loadBoolean(Config.CATEGORY_RECIPES, "cookedSpiderLeg", true,
				"Set this to false if you don't want to be able to cook raw spider legs");
		Config.Recipes.cookedSquid = loadBoolean(Config.CATEGORY_RECIPES, "cookedSquid", true,
				"Set this to false if you don't want to be able to cook raw squid meat");
		Config.Recipes.cookedVillager = loadBoolean(Config.CATEGORY_RECIPES, "cookedVillager", true,
				"Set this to false if you don't want to be able to cook raw villager meat");
		Config.Recipes.cookedWolf = loadBoolean(Config.CATEGORY_RECIPES, "cookedWolf", true,
				"Set this to false if you don't want to be able to cook raw wolf meat");
		Config.Recipes.wheatToFlour = loadInt(Config.CATEGORY_RECIPES, "wheatToFlour",
				Config.DEFAULT_WHEAT_TO_FLOUR_RATIO,
				"How much wheat is need to craft 1 flour (default = 1, set to 0 to disable)");
		Config.Recipes.wheatToSeeds = loadInt(Config.CATEGORY_RECIPES, "wheatToSeeds",
				Config.DEFAULT_SEEDS_FROM_WHEAT_AMOUNT,
				"How many seeds you get from 1 wheat by directly crafting it like log -> planks (default = 3, set to 0 to disable)");
		Config.Recipes.seedsToFlour = loadInt(Config.CATEGORY_RECIPES, "seedsToFlour",
				Config.DEFAULT_SEEDS_TO_FLOUR_RATIO,
				"How many seeds are needed for 1 flour (default = 3, set to 0 to disable)");
		Config.Recipes.dough = loadBoolean(Config.CATEGORY_RECIPES, "dough", true,
				"Set this to false if you don't want to be able to craft dough");
		Config.Recipes.fatAsFuel = loadInt(Config.CATEGORY_RECIPES, "cookedWolf", Config.DEFAULT_FAT_BURN_TIME,
				"Burntime of fat (default = 400 = enough to smelt/cook 2 items, set to 0 to disable)");
		Config.Recipes.fatForTorches = loadInt(Config.CATEGORY_RECIPES, "fatForTorches",
				Config.DEFAULT_TORCHES_FROM_FAT,
				"How many torches you get from crafting 1 fat with 1 stick (default = 2, set to 0 to disable)");
		Config.Recipes.fuelPellet = loadBoolean(Config.CATEGORY_RECIPES, "fuelPellet", true,
				"Set this to false if you don't want to be able to craft fuel pellets");
		Config.Recipes.gelatin = loadBoolean(Config.CATEGORY_RECIPES, "gelatin", true,
				"Set this to false if you don't want to be able to craft gelatin");
		Config.Recipes.horseHairToString = loadBoolean(Config.CATEGORY_RECIPES, "cookedWolf", true,
				"Set this to false if you don't want to be able to craft string from horse hair");
		Config.Recipes.jelly = loadBoolean(Config.CATEGORY_RECIPES, "jelly", true,
				"Set this to false if you don't want to be able to craft jelly from sugar and slimeball/gelatin");
		Config.Recipes.bread = loadInt(Config.CATEGORY_RECIPES, "breadConfig", Config.DEFAULT_BREAD_CONFIG_VALUE,
				"4 = craft raw bread and enable the furnace recipe,\n"
						+ "3 = craft raw bread that needs to be smelted in a furnace (but disable furnace recipes),\n"
						+ "2 = craft bread instead of raw bread,\n"
						+ "1 = disable being able to craft bread alltogether,\n"
						+ "0 = disable this feature so you can again craft bread with 3 wheat (vanilla)");
		Config.Recipes.cookie = loadInt(Config.CATEGORY_RECIPES, "cookieConfig", Config.DEFAULT_COOKIE_CONFIG_VALUE,
				"4 = craft raw cookies and enable the furnace recipe,\n"
						+ "3 = craft raw cookies that needs to be smelted in a furnace (but disable furnace recipes),\n"
						+ "2 = craft cookies instead of raw cookies,\n"
						+ "1 = disable being able to craft cookies alltogether,\n"
						+ "0 = disable this feature so you can again craft cookies with 2 wheat and 1 cocoa (vanilla)");

		if (Config.config.hasChanged()) {
			Config.config.save();
		}
	}

	public static void load(FMLPreInitializationEvent event) {
		Config.config = new Configuration(event.getSuggestedConfigurationFile());
		Config.config.load();
		reloadConfig();
	}

	private static int loadInt(String category, String name, int defaultValue, String comment) {
		Property p = Config.config.get(category, name, defaultValue);
		if (comment != null) {
			p.setComment(comment);
		}
		return p.getInt();
	}

	private static int loadInt(String category, String name, int defaultValue) {
		return loadInt(category, name, defaultValue, null);
	}

	private static boolean loadBoolean(String category, String name, boolean defaultValue, String comment) {
		Property p = Config.config.get(category, name, defaultValue);
		if (comment != null) {
			p.setComment(comment);
		}
		return p.getBoolean();
	}

	private static boolean loadBoolean(String category, String name, boolean defaultValue) {
		return loadBoolean(category, name, defaultValue, null);
	}

}
