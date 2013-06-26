package me.jacobschwartz.gunMod;

import me.jacobschwartz.gunMod.GunMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class AmmoBoxContainer extends Container{
	/** The crafting matrix inventory (5x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 3);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private int numRows;
	private int numCol;
	private int numCraftingSlots;
	
	public AmmoBoxContainer(InventoryPlayer par1InventoryPlayer, World par2World, int posX, int posY, int posZ)
	{
	         this.worldObj = par2World;
	         this.posX = posX;
	         this.posY = posY;
	         this.posZ = posZ;
	        
	         //Adding crafting result slot
	         this.addSlotToContainer(new MinelegionSlotManager(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 144, 36));
	         int numRowsCount;
	         int numColCount;
	         
	         numRows = 3;
	         numCol = 5;
	         
	         numCraftingSlots = numRows * numCol;
	         
	         //Adding crafting slots
	         for (numRowsCount = 0; numRowsCount < numRows; ++numRowsCount)
	         {
	                 for (numColCount = 0; numColCount < numCol; ++numColCount)
	                 {
	                         this.addSlotToContainer(new Slot(this.craftMatrix, numColCount + numRowsCount * numCol, 26 + numColCount * 18, 17 + numRowsCount * 18));
	                 }
	         }
	         
	         //Adding player inventory
	         for (numRowsCount = 0; numRowsCount < 3; ++numRowsCount)
	         {
	                 for (numColCount = 0; numColCount < 9; ++numColCount)
	                 {
	                         this.addSlotToContainer(new Slot(par1InventoryPlayer, numColCount + numRowsCount * 9 + 9, 8 + numColCount * 18, 84 + numRowsCount * 18));
	                 }
	         }
	         
	         //Adding player hotbar
	         for (numRowsCount = 0; numRowsCount < 9; ++numRowsCount)
	         {
	                 this.addSlotToContainer(new Slot(par1InventoryPlayer, numRowsCount, 8 + numRowsCount * 18, 142));
	         }
	
	         this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	/**
	         * Callback for when the crafting matrix is changed.
	         */
	public void onCraftMatrixChanged(IInventory par1IInventory)
	{
	         this.craftResult.setInventorySlotContents(0, AmmoBoxCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
	
	/**
	         * Callback for when the crafting gui is closed.
	         */
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
	{
	         super.onCraftGuiClosed(par1EntityPlayer);
	
	         if (!this.worldObj.isRemote)
	         {
	                 for (int var2 = 0; var2 < numRows * numCol; ++var2)
	                 {
	                         ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);
	
	                         if (var3 != null)
	                         {
	                                 par1EntityPlayer.dropPlayerItem(var3);
	                         }
	                 }
	         }
	}
	
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
	         return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != GunMod.ammoBox.blockID ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
	}
	
	/**
	         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	         */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
         ItemStack var3 = null;
         Slot var4 = (Slot)this.inventorySlots.get(par2);

         if (var4 != null && var4.getHasStack())
         {
                 ItemStack var5 = var4.getStack();
                 var3 = var5.copy();

                 if (par2 == 0)
                 {
                         if (!this.mergeItemStack(var5, numCraftingSlots + 1/*10*/, numCraftingSlots + 37/*46*/, true))
                         {
                                 return null;
                         }

                         var4.onSlotChange(var5, var3);
                 }
                 else if (par2 >= numCraftingSlots + 1 && par2 < numCraftingSlots + 28/*37*/)
                 {
                         if (!this.mergeItemStack(var5, numCraftingSlots + 28/*37*/, numCraftingSlots + 37/*46*/, false))
                         {
                                 return null;
                         }
                 }
                 else if (par2 >= numCraftingSlots + 28/*37*/ && par2 < numCraftingSlots + 37/*46*/)
                 {
                         if (!this.mergeItemStack(var5, numCraftingSlots + 1/*10*/, numCraftingSlots + 28/*37*/, false))
                         {
                                 return null;
                         }
                 }
                 else if (!this.mergeItemStack(var5, numCraftingSlots + 1/*10*/, numCraftingSlots + 37/*46*/, false))
                 {
                         return null;
                 }

                 if (var5.stackSize == 0)
                 {
                         var4.putStack((ItemStack)null);
                 }
                 else
                 {
                         var4.onSlotChanged();
                 }

                 if (var5.stackSize == var3.stackSize)
                 {
                         return null;
                 }

                 var4.onPickupFromSlot(par1EntityPlayer, var5);
         }

         return var3;
	}
}