package com.beetrootmonkey.eattheworld.proxy;

import com.beetrootmonkey.eattheworld.Reference;
import com.beetrootmonkey.eattheworld.block.ModBlocks;
import com.beetrootmonkey.eattheworld.config.Config;
import com.beetrootmonkey.eattheworld.config.ConfigLoader;
import com.beetrootmonkey.eattheworld.crafting.ModRecipes;
import com.beetrootmonkey.eattheworld.drops.DropHandlerBlock;
import com.beetrootmonkey.eattheworld.drops.DropHandlerEntity;
import com.beetrootmonkey.eattheworld.item.ModItems;
import com.beetrootmonkey.eattheworld.item.fuel.FuelHandler;
import com.beetrootmonkey.eattheworld.worldgen.OreGen;
import com.beetrootmonkey.eattheworld.worldgen.WorldGenHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ConfigLoader.load(event);
		ModItems.init();
		ModBlocks.init();
		MinecraftForge.EVENT_BUS.register(new DropHandlerEntity());
		MinecraftForge.EVENT_BUS.register(new DropHandlerBlock());
		MinecraftForge.EVENT_BUS.register(new WorldGenHandler());
		MinecraftForge.TERRAIN_GEN_BUS.register(new WorldGenHandler());
		GameRegistry.registerFuelHandler(new FuelHandler());
	}

	public void init(FMLInitializationEvent event) {
		ModItems.registerOres();
		ModRecipes.addRecipes();
		LootTableList.register(new ResourceLocation(Reference.MOD_ID, "inject/entities/horse"));
		LootTableList.register(new ResourceLocation(Reference.MOD_ID, "inject/entities/spider"));
		GameRegistry.registerWorldGenerator(new OreGen(),  0);
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

	public void registerItemRenderer(Item item, int meta, String id) {

	}
}