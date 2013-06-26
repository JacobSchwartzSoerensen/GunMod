package me.jacobschwartz.gunMod;

import me.jacobschwartz.gunMod.client.GUIAmmoBox;
import me.jacobschwartz.gunMod.client.GUIWeaponsBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class MinelegionGuiHandler implements IGuiHandler
{

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
{

TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

switch(id)
{

//case 0: return new ContainerExtruder(player.inventory, (TileEntityExtruder) tile_entity);
case 1: return id == 1 && world.getBlockId(x, y, z) == GunMod.ammoBox.blockID ? new AmmoBoxContainer(player.inventory, world, x, y, z) : null;
case 2: return id == 2 && world.getBlockId(x, y, z) == GunMod.weaponsBox.blockID ? new WeaponsBoxContainer(player.inventory, world, x, y, z) : null;
//case 2: return new ContainerSpiritTable(player.inventory, (world), x, y, z);
//case 3: return new ContainerTreeTrunk(player.inventory, (TileEntityTreeTrunk) tile_entity);
//case 4: return id == 4 && world.getBlockId(x, y, z) == MTJT.forge.blockID ? new ContainerForgeBench(player.inventory, world, x, y, z) : null;
//case 5: return new ContainerIceMachine(player.inventory, (TileEntityIceMachine) tile_entity);
//case 6: return new ContainerGemMachine(player.inventory, (TileEntityGemMachine) tile_entity);
//case 7: return id == 7 && world.getBlockId(x, y, z) == MTJT.builder.blockID ? new ContainerBlueprintTable(player.inventory, world, x, y, z) : null;

}
return null;
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
{

TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

switch(id)
{

//case 0: return new GuiExtruder(player.inventory, (TileEntityExtruder) tile_entity);
case 1: return id == 1 && world.getBlockId(x, y, z) == GunMod.ammoBox.blockID ? new GUIAmmoBox(player.inventory, world, x, y, z) : null;
case 2: return id == 2 && world.getBlockId(x, y, z) == GunMod.weaponsBox.blockID ? new GUIWeaponsBox(player.inventory, world, x, y, z) : null;
//case 2: return new GuiSpiritTable(player.inventory, (world), x, y, z);
//case 3: return new GuiTreeTrunk(player.inventory, (TileEntityTreeTrunk) tile_entity);
//case 4: return id == 4 && world.getBlockId(x, y, z) == MTJT.forge.blockID ? new GuiForgeCrafting(player.inventory, world, x, y, z) : null;
//case 5: return new GuiIceMachine(player.inventory, (TileEntityIceMachine) tile_entity);
//case 6: return new GuiGemMachine(player.inventory, (TileEntityGemMachine) tile_entity);
//case 7: return id == 7 && world.getBlockId(x, y, z) == MTJT.builder.blockID ? new BlueprintTableGui(player.inventory, world, x, y, z) : null;

}

return null;

}

}