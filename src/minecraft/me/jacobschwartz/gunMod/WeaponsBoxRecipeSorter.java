package me.jacobschwartz.gunMod;

import java.util.Comparator;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

class WeaponsBoxRecipeSorter implements Comparator
{
	final WeaponsBoxCraftingManager WeaponsBoxCraftingManager;
	
	public WeaponsBoxRecipeSorter(WeaponsBoxCraftingManager WeaponsBoxCraftingManager)
	{
	         this.WeaponsBoxCraftingManager = WeaponsBoxCraftingManager;
	}
	
	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
	         return par1IRecipe instanceof WeaponsBoxShapelessRecipes && par2IRecipe instanceof WeaponsBoxShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object par1Obj, Object par2Obj)
	{
	         return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
	}
}