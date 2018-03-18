package com.beetrootmonkey.eattheworld.item;

import com.beetrootmonkey.eattheworld.EatTheWorld;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(EatTheWorld.creativeTab);
	}

	@Override
	public void registerItemModel(Item item) {
		EatTheWorld.proxy.registerItemRenderer(this, 0, name);
	}

}
