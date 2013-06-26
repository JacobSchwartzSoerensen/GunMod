package me.jacobschwartz.gunMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BasicBlock extends Block {
	
	private String texture;
	
	public BasicBlock(int id, String texture, Material material) {
		super(id, material);
		
		this.texture = texture;
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister){
		
		this.blockIcon = iconRegister.registerIcon(texture);
		
	}

}
