package me.jacobschwartz.gunMod;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class BasicCrafting extends BasicBlock implements IInventory{

	private ItemStack inv[];
	private String name;
	
	public BasicCrafting(int id, String texture, Material material, int sizeInventory, String name) {
		super(id, texture, material);
		
		this.inv = new ItemStack[sizeInventory];
		this.name = name;
		
	}

	@Override
	public int getSizeInventory() {
		
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		
		ItemStack stack = getStackInSlot(slot);
		if(stack != null){
			
			if(stack.stackSize <= amt){
				
				setInventorySlotContents(slot, null);
				
			}else{
				
				stack = stack.splitStack(amt);
				if(stack.stackSize == 0){
					
					setInventorySlotContents(slot, null);
					
				}
				
			}
			
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		
		ItemStack stack = getStackInSlot(slot);
		if(stack != null){
			
			setInventorySlotContents(slot, null);
			
		}
		
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		inv[slot] = itemstack;
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			
			itemstack.stackSize = getInventoryStackLimit();
			
		}
		
	}

	@Override
	public String getInvName() {
		
		return name;
	}

	@Override
	public boolean isInvNameLocalized() {
		
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}

	@Override
	public void onInventoryChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		
		return true;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

}
