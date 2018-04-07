package com.beetrootmonkey.eattheworld.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;

import com.beetrootmonkey.eattheworld.block.ModBlocks;
import com.beetrootmonkey.eattheworld.config.Config;
import com.beetrootmonkey.eattheworld.init.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.ModItems;

@EventBusSubscriber
public class ModRecipes {

	public static void addRecipes() {

		if (Config.Recipes.cocoaPowder && !Config.PAM_IS_HOME) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, 3), ModItems.cocoa_powder);
		}

		if (Config.Recipes.cookedBat) {
			GameRegistry.addSmelting(ModItems.raw_bat, new ItemStack(ModItems.cooked_bat), 0.35f);
		}

		if (Config.Recipes.cookedCat) {
			GameRegistry.addSmelting(ModItems.raw_cat, new ItemStack(ModItems.cooked_cat), 0.35f);
		}

		if (Config.Recipes.cookedDragon) {
			GameRegistry.addSmelting(ModItems.raw_dragon, new ItemStack(ModItems.cooked_dragon), 0.35f);
		}

		if (Config.Recipes.cookedGuardian) {
			GameRegistry.addSmelting(ModItems.raw_guardian, new ItemStack(ModItems.cooked_guardian), 0.35f);
		}

		if (Config.Recipes.cookedHorse) {
			GameRegistry.addSmelting(ModItems.raw_horse, new ItemStack(ModItems.cooked_horse), 0.35f);
		}

		if (Config.Recipes.cookedShulker) {
			GameRegistry.addSmelting(ModItems.raw_shulker, new ItemStack(ModItems.cooked_shulker), 0.35f);
		}

		if (Config.Recipes.cookedSilverfish) {
			GameRegistry.addSmelting(ModItems.raw_silverfish, new ItemStack(ModItems.cooked_silverfish), 0.35f);
		}

		if (Config.Recipes.cookedSpiderEye) {
			GameRegistry.addSmelting(Items.SPIDER_EYE, new ItemStack(ModItems.cooked_spider_eye), 0.35f);
		}

		if (Config.Recipes.cookedSpiderLeg) {
			GameRegistry.addSmelting(ModItems.raw_spider_leg, new ItemStack(ModItems.cooked_spider_leg), 0.35f);
		}

		if (Config.Recipes.cookedSquid) {
			GameRegistry.addSmelting(ModItems.raw_squid, new ItemStack(ModItems.cooked_squid), 0.35f);
		}

		if (Config.Recipes.cookedVillager) {
			GameRegistry.addSmelting(ModItems.raw_villager, new ItemStack(ModItems.cooked_villager), 0.35f);
		}

		if (Config.Recipes.cookedWolf) {
			GameRegistry.addSmelting(ModItems.raw_wolf, new ItemStack(ModItems.cooked_wolf), 0.35f);
		}

		if (Config.Recipes.dough && !Config.PAM_IS_HOME) {
			GameRegistry
					.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dough), Items.WATER_BUCKET, "foodFlour"));
		}

		if (Config.Recipes.fuelPellet) {
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fuel_pellet, 8), new ItemStack(Items.COAL));
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fuel_pellet, 8), new ItemStack(Items.COAL, 1, 1));
			if (OreDictionary.doesOreNameExist("fuelCoke")) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.fuel_pellet, 16), "fuelCoke"));
			}
		}

		if (Config.Recipes.gelatin) {
			GameRegistry.addSmelting(Items.BONE, new ItemStack(ModItems.gelatin), 0.35f);
		}

		if (Config.Recipes.horseHairToString) {
			GameRegistry.addShapedRecipe(new ItemStack(Items.STRING, 2), "HHH", 'H', ModItems.horse_hair);
		}

		if (Config.Recipes.jelly) {
			if(Config.PAM_IS_HOME) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.jelly_cube, "slimeball", "listAllsugar"));
			} else {
				GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.jelly_cube, "slimeball", Items.SUGAR));
				if(OreDictionary.doesOreNameExist("dropHoney")) {
					GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.jelly_cube, "slimeball", "dropHoney"));
				}
			}
		}

		if(!Config.PAM_IS_HOME) {
			switch (Config.Recipes.bread) {
			case 4:
				removeRecipe(Items.BREAD, Items.WHEAT);
				GameRegistry.addSmelting(ModItems.raw_bread, new ItemStack(Items.BREAD), 0.35f);
			case 3:
				GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.raw_bread, "foodDough"));
				break;
			case 2:
				removeRecipe(Items.BREAD, Items.WHEAT);
				GameRegistry.addRecipe(new ShapelessOreRecipe(Items.BREAD, "foodDough"));
				break;
			case 1:
				removeRecipe(Items.BREAD, Items.WHEAT);
				break;
			}
		} else {
			removeRecipe(Items.BREAD, Items.WHEAT);
		}
		

		if (Config.Recipes.fatForTorches > 0) {
			if(OreDictionary.doesOreNameExist("stickWood")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.TORCH), Config.Recipes.fatForTorches),
						"F", "S", 'F', "itemFat", 'S', "stickWood"));
			} else {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.TORCH), Config.Recipes.fatForTorches),
						"F", "S", 'F', "itemFat",'S', Items.STICK));
			}
			
		}

		switch (Config.Recipes.cookie) {
		case 4:
			removeRecipe(Items.COOKIE);
			GameRegistry.addSmelting(ModItems.raw_cookie, new ItemStack(Items.COOKIE), 0.35f);
		case 3:
			if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.raw_cookie, 16), "foodChocolatebar", "foodDough", "foodDough"));
			} else {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.raw_cookie, 16), "foodCocoapowder", "foodDough", "foodDough"));
			}
			break;
		case 2:
			removeRecipe(Items.COOKIE);
			if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.COOKIE, 16), "foodChocolatebar", "foodDough", "foodDough"));
			} else {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.COOKIE, 16), "foodCocoapowder", "foodDough", "foodDough"));
			}
			break;
		case 1:
			removeRecipe(Items.COOKIE);
			break;
		}

		if (Config.Recipes.seedsToFlour > 0) {
			Object[] arr = new Object[Config.Recipes.seedsToFlour];
			for(int i = 0; i < Config.Recipes.seedsToFlour; i++) {
				arr[i] = Config.PAM_IS_HOME ? "listAllSeed" : Items.WHEAT_SEEDS;
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.flour, arr));
		}

		if (Config.Recipes.wheatToFlour > 0 && !Config.PAM_IS_HOME) {
			Object[] arr = new Object[Config.Recipes.wheatToFlour];
			for(int i = 0; i < Config.Recipes.wheatToFlour; i++) {
				arr[i] = OreDictionary.doesOreNameExist("cropWheat") ? "cropWheat" : Items.WHEAT;
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.flour, arr));
		}

		if (Config.Recipes.wheatToSeeds > 0 && !Config.PAM_IS_HOME) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.WHEAT_SEEDS, Config.Recipes.wheatToSeeds), Items.WHEAT);
		}

//		removeRecipe(Items.BREAD, Items.WHEAT);
		// removeRecipe(ShapedRecipes.class, Blocks.TORCH, Items.COAL);
		// removeRecipe(ShapedRecipes.class, Blocks.TORCH, "stickWood");

	}

	public static void removeRecipe(Object output, Object... input) {
		if (!isItem(output)) {
			return;
		}
		List<ItemStack> inputFilter = new ArrayList<ItemStack>();
		List<IRecipe> recipesToRemove = new ArrayList<IRecipe>();

		for (IRecipe recipe : CraftingManager.getInstance().getRecipeList()) {
			if (inputFilter.isEmpty()) {
				if (equals(output, recipe.getRecipeOutput())) {
					recipesToRemove.add(recipe);
				}

			} else {
				boolean validRecipe = equals(output, recipe.getRecipeOutput());
				if (validRecipe) {
					for (Object objIn : input) {
						if (!isIngredient(recipe, objIn)) {
							validRecipe = false;
							break;
						}
					}
					if (validRecipe) {
						recipesToRemove.add(recipe);
					}
				}
			}
		}

		CraftingManager.getInstance().getRecipeList().removeAll(recipesToRemove);
		if (output instanceof String) {
			EatTheWorld.logger
					.info("Removed " + recipesToRemove.size() + " recipes with output " + (String) output + "!");
		} else {
			EatTheWorld.logger.info("Removed " + recipesToRemove.size() + " recipes with output "
					+ convertToStack(output).getUnlocalizedName() + "!");
		}

	}

	public static boolean isObjectInList(Object[] list, Object item) {
		return isItemStackInList(Arrays.asList(list), item);
	}

	public static boolean isObjectInList(List<Object> list, Object item) {
		for (Object stack : list) {
			if (isItem(stack)) {
				if (equals(stack, item)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isItemStackInList(List<ItemStack> list, Object item) {
		for (Object stack : list) {
			if (isItem(stack)) {
				if (equals(stack, item)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isIngredient(IRecipe recipe, Object item) {
		if (recipe instanceof ShapedRecipes) {
			if (!isObjectInList(((ShapedRecipes) recipe).recipeItems, item)) {
				return false;
			}
			return true;
		} else if (recipe instanceof ShapelessRecipes) {
			if (!isItemStackInList(((ShapelessRecipes) recipe).recipeItems, item)) {
				return false;
			}
			return true;
		} else if (recipe instanceof ShapedOreRecipe) {
			if (!isObjectInList(((ShapedOreRecipe) recipe).getInput(), item)) {
				return false;
			}
			return true;
		} else if (recipe instanceof ShapelessOreRecipe) {
			if (!isObjectInList(((ShapelessOreRecipe) recipe).getInput(), item)) {
				return false;
			}
			return true;
		}

		return false;
	}

	public static ItemStack convertToStack(Object object) {
		if (object instanceof Block) {
			return new ItemStack(Item.getItemFromBlock((Block) object), 0);
		} else if (object instanceof Item) {
			return new ItemStack((Item) object, 0);
		} else if (object instanceof ItemStack) {
			return (ItemStack) object;
		}
		return null;
	}

	public static boolean isItem(Object object) {
		return object instanceof String || object instanceof Item || object instanceof ItemStack
				|| object instanceof Block;
	}

	public static boolean equals(ItemStack stack1, ItemStack stack2) {
		return stack1 != null && stack2 != null && stack1.getItem() == stack2.getItem()
				&& (stack1.stackSize == 0 || stack2.stackSize == 0 || stack1.stackSize == stack2.stackSize)
				&& stack1.getMetadata() == stack2.getMetadata();
	}

	public static boolean equals(Object object1, Object object2) {
		if (!isItem(object1) || !isItem(object2)) {
			return false;
		}

		if (object1 instanceof String) {
			if (object2 instanceof String) {
				return equals((String) object1, (String) object2);
			} else {
				return equals((String) object1, convertToStack(object2));
			}
		} else {
			if (object2 instanceof String) {
				return equals(convertToStack(object1), (String) object2);
			} else {
				return equals(convertToStack(object1), convertToStack(object2));
			}
		}
	}

	public static boolean equals(ItemStack stack, String ore) {
		for (ItemStack entry : OreDictionary.getOres((String) ore)) {
			entry.stackSize = 0;
			if (equals(entry, stack)) {
				return true;
			}
		}
		return false;
	}

	public static boolean equals(String ore, ItemStack stack) {
		return equals(stack, ore);
	}

	public static boolean equals(String ore1, String ore2) {
		return ore1.equals(ore2);
	}
}