package com.beetrootmonkey.eattheworld.item.fuel;

import com.beetrootmonkey.eattheworld.init.EatTheWorld;
import com.beetrootmonkey.eattheworld.item.ItemBase;
import com.beetrootmonkey.eattheworld.item.ItemModelProvider;

import net.minecraft.item.Item;

public class ItemFuel extends ItemBase implements IFuel 
{
	int burnTime;
	
	@Override
	public int getBurnTime()
	{
		return burnTime;
	}
	
	public ItemFuel(String name, int burnTime)
	{
		super(name);
		this.burnTime = burnTime;
	}
}
