package com.beetrootmonkey.eattheworld.item.edible;

import java.util.ArrayList;
import java.util.List;

import com.beetrootmonkey.eattheworld.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.ItemBase;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood implements ItemModelProvider {

	protected String name;

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
	}

	public ItemModFood(String name, int amount, float saturation) {
		super(amount, saturation / amount / 2, false);
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
