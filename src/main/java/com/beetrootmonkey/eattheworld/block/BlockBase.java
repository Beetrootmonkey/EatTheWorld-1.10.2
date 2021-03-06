package com.beetrootmonkey.eattheworld.block;

import com.beetrootmonkey.eattheworld.init.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements ItemModelProvider {

	protected String name;

	public BlockBase(Material materialIn, String name) {
		super(materialIn);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(EatTheWorld.creativeTab);
	}

	@Override
	public void registerItemModel(Item itemBlock) {
		EatTheWorld.proxy.registerItemRenderer(itemBlock, 0, name);

	}

	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public BlockBase setResistance(float resistance) {
		super.setResistance(resistance);
		return this;
	}

	@Override
	public BlockBase setHardness(float hardness) {
		super.setHardness(hardness);
		return this;
	}

}
