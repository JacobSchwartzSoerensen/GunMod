package me.jacobschwartz.gunMod.client;

import org.lwjgl.opengl.GL11;

import me.jacobschwartz.gunMod.AmmoBoxContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GUIAmmoBox extends GuiContainer {
	
	private int lYSize;
	
	public GUIAmmoBox(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
	{
	         super(new AmmoBoxContainer(par1InventoryPlayer, par2World, par3, par4, par5));
	         this.lYSize = 250;
	}

	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	         this.fontRenderer.drawString(StatCollector.translateToLocal("container.crafting"), 28, 6, 4210752);
	         this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         this.mc.renderEngine.bindTexture("/mods/GunMod/textures/gui/AmmoBoxGUI.png");
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         this.drawTexturedModalRect(x, y, 0, 0, /*this.xSize*/176, /*this.lYSize*/ 166);
	}


}
