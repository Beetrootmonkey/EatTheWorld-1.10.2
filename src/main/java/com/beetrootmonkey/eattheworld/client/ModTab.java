package com.beetrootmonkey.eattheworld.client;

import com.beetrootmonkey.eattheworld.EatTheWorld;
import com.beetrootmonkey.eattheworld.Reference;
import com.beetrootmonkey.eattheworld.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTab extends CreativeTabs {

	public ModTab() {
		super(Reference.MOD_ID);
		// setBackgroundImageName("tutorialmod.png");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.cooked_spider_eye; // shown icon on creative tab
	}

	@Override
	public boolean hasSearchBar() {
		return false; // return false if you don't want search bar
	}

}
