package me.jacobschwartz.gunMod;

import java.util.Random;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import me.jacobschwartz.gunMod.GunMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWeaponsBox extends Block
{

	@SideOnly(Side.CLIENT)
	private Icon field_94385_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94384_b;
	
	public BlockWeaponsBox(int par1)
	{
	         super(par1, Material.wood);
	         //blockIndexInTexture = 59;
	         this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@SideOnly(Side.CLIENT)
	
	/**
	         * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	         */
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
	         return par1 == 1 ? this.field_94385_a : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
	}
	
	@SideOnly(Side.CLIENT)
	
	/**
	         * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	         * is the only chance you get to register icons.
	         */
	public void registerIcons(IconRegister par1IconRegister){
		
		this.blockIcon = par1IconRegister.registerIcon("MTJT:smithsBenchSide2");
	    this.field_94385_a = par1IconRegister.registerIcon("MTJT:smithsBenchTop");
	    this.field_94384_b = par1IconRegister.registerIcon("MTJT:smithsBenchSide1");
	    
	}
	
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9){
	    if (!player.isSneaking()){
	    	
			player.openGui(GunMod.instance, 2, var1, var2, var3, var4);
			return true;
			
		}else{
			return false;
		}
	
	}

}