package com.beetrootmonkey.eattheworld.item.tools;

import com.beetrootmonkey.eattheworld.init.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.ItemBase;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe implements ItemModelProvider {

	protected String name;

	public ItemModAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
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
