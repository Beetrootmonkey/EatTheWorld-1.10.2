package com.beetrootmonkey.eattheworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.beetrootmonkey.eattheworld.block.ModBlocks;
import com.beetrootmonkey.eattheworld.client.ModTab;
import com.beetrootmonkey.eattheworld.config.ConfigLoader;
import com.beetrootmonkey.eattheworld.crafting.ModRecipes;
import com.beetrootmonkey.eattheworld.drops.DropHandlerEntity;
import com.beetrootmonkey.eattheworld.item.ModItems;
import com.beetrootmonkey.eattheworld.item.fuel.FuelHandler;
import com.beetrootmonkey.eattheworld.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSIONS, guiFactory = Reference.GUI_FACTORY)
public class EatTheWorld {

	public static final ModTab creativeTab = new ModTab();
	
	@SidedProxy(serverSide = "com.beetrootmonkey.eattheworld.proxy.ServerProxy", clientSide = "com.beetrootmonkey.eattheworld.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance(Reference.MOD_ID)
	public static EatTheWorld instance;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
