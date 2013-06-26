package me.jacobschwartz.gunMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ammo extends Item{
	
	private String texture;
	private int quantity;
	
	public Ammo(int id, String texture, int quantity) {
		super(id);
		this.texture = texture;
		this.setMaxDamage(quantity);
		setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	public void registerIcons(IconRegister iconRegister){
		
		itemIcon = iconRegister.registerIcon(texture);
		
	}
	
}
