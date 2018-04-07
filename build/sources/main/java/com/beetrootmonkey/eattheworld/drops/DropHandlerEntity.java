package com.beetrootmonkey.eattheworld.drops;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.beetrootmonkey.eattheworld.config.Config;
import com.beetrootmonkey.eattheworld.init.Reference;
import com.beetrootmonkey.eattheworld.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropHandlerEntity {

	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent evt) {
		String prefix = "minecraft:";
		String name = evt.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			if (file.equals("entities/bat")) {
				if (Config.Drops.bat) {
					evt.getTable().addPool(getInjectPool("entities/bat"));
				}
			} else if (file.equals("entities/ocelot")) {
				if (Config.Drops.cat) {
					evt.getTable().addPool(getInjectPool("entities/ocelot"));
				}
			} else if (file.equals("entities/elder_guardian")) {
				if (Config.Drops.elderGuardian) {
					evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
					evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/elder_guardian", 1));
				}
			} else if (file.equals("entities/ghast")) {
				if (Config.Drops.ghast) {
					evt.getTable().addPool(getInjectPool("entities/ghast"));
				}
			} else if (file.equals("entities/guardian")) {
				if (Config.Drops.guardian) {
					evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
					evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/guardian", 1));
				}
			} else if (file.equals("entities/horse")) {
				if (Config.Drops.horse) {
					evt.getTable().addPool(getInjectPool("entities/horse_meat", 0));
				}
				if (Config.Drops.horseHair) {
					evt.getTable().addPool(getInjectPool("entities/horse_hair", 1));
				}
			} else if (file.equals("entities/donkey")) {
				if (Config.Drops.horse) {
					evt.getTable().addPool(getInjectPool("entities/donkey_meat", 0));
				}
				if (Config.Drops.horseHair) {
					evt.getTable().addPool(getInjectPool("entities/donkey_hair", 1));
				}
			} else if (file.equals("entities/pig")) {
				if (Config.Drops.fat) {
					evt.getTable().addPool(getInjectPool("entities/pig"));
				}
			} else if (file.equals("entities/shulker")) {
				if (Config.Drops.shulker) {
					evt.getTable().addPool(getInjectPool("entities/shulker"));
				}
			} else if (file.equals("entities/silverfish")) {
				if (Config.Drops.silverfish) {
					evt.getTable().addPool(getInjectPool("entities/silverfish"));
				}
			} else if (file.equals("entities/spider")) {
				if (Config.Drops.cookedSpiderEye) {
					evt.getTable().removePool("pool1");
					evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
				}
				if (Config.Drops.spiderLeg) {
					evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
				}
			} else if (file.equals("entities/cave_spider")) {
				if (Config.Drops.cookedSpiderEye) {
					evt.getTable().removePool("pool1");
					evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
				}
				if (Config.Drops.spiderLeg) {
					evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
				}
			} else if (file.equals("entities/squid")) {
				if (Config.Drops.squid == 2 || (Config.Drops.squid == 1 && !Config.PAM_IS_HOME)) {
					evt.getTable().addPool(getInjectPool("entities/squid"));
				}
			} else if (file.equals("entities/villager")) {
				if (Config.Drops.villager) {
					evt.getTable().addPool(getInjectPool("entities/villager"));
				}
			} else if (file.equals("entities/wither_skeleton")) {
				if (false) {
					evt.getTable().addPool(getInjectPool("entities/wither_skeleton"));
				}
			} else if (file.equals("entities/wolf")) {
				if (Config.Drops.wolf) {
					evt.getTable().addPool(getInjectPool("entities/wolf"));
				}
			}
			
		}
	}
	
	private LootPool getInjectPool(String entryName) {
		return getInjectPool(entryName, 0);
	}

	private LootPool getInjectPool(String entryName, int counter) {
		return new LootPool(new LootEntry[] { getInjectEntry(entryName, 1) }, new LootCondition[0],
				new RandomValueRange(1), new RandomValueRange(0, 1), "eattheworld_inject_pool_" + counter);
	}

	private LootEntryTable getInjectEntry(String name, int weight) {
		return new LootEntryTable(new ResourceLocation(Reference.MOD_ID, "inject/" + name), weight, 0,
				new LootCondition[0], "eattheworld_inject_entry");
	}

	// @SubscribeEvent
	// public void onEntityDrop(LivingDropsEvent event) {
	// int amount = 1;
	// // cow, extends EntityAnimal. you could use EntityTameable and so on..
	// if (event.getEntityLiving() instanceof EntityHorse &&
	// ((EntityHorse)event.getEntityLiving()).isAdultHorse()) {
	// amount = (int) (Math.random() * 3 + 1 + event.getLootingLevel());
	// addDrop(new ItemStack(event.getEntity().isBurning() ? ModItems.cooked_horse :
	// ModItems.raw_horse, amount),
	// event);
	//
	// } else if (event.getEntityLiving() instanceof EntitySpider &&
	// event.getEntity().isBurning()) {
	// replaceDrop(Items.SPIDER_EYE, new ItemStack(ModItems.cooked_spider_eye),
	// event);
	//
	// }
	// }

	private void addDrop(ItemStack item, LivingDropsEvent event) {
		if (event != null && item != null && item.stackSize > 0 && item.getItem() != null) {
			event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX,
					event.getEntity().posY, event.getEntity().posZ, item));
		}
	}

	private void replaceDrop(Item filter, ItemStack replacement, LivingDropsEvent event) {
		for (EntityItem eItem : event.getDrops()) {
			if (eItem.getEntityItem().getItem().equals(filter)) {
				int amount = eItem.getEntityItem().stackSize;
				eItem.setEntityItemStack(replacement);
				eItem.getEntityItem().stackSize = amount;
			}
		}
	}
}
