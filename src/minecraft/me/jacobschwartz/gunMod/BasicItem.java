package me.jacobschwartz.gunMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BasicItem extends Item {
	
	private String texture;
	
	public BasicItem(int id, String texture) {
		super(id);
		
		this.texture = texture;
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister){
		
		this.itemIcon = iconRegister.registerIcon(texture);
		
	}
	
}
