package me.jacobschwartz.gunMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class Gun extends Item {
	
	private String gunTexture;
	private String bulletTexture;
	private Item ammo;
	private double damage;
	private int knockBack;
	private boolean isMachineGun = false;
	
	public Gun(int id, String gunTexture, CreativeTabs creativeTab, boolean isMachineGun, Item ammo, String bulletTexture, double damage, int knockBack) {
		super(id);
		
		//Gun Settings
		setMaxStackSize(1);
		setCreativeTab(creativeTab);
		setUnlocalizedName("gun");
		this.gunTexture = gunTexture;
		this.ammo = ammo;
		this.isMachineGun = isMachineGun;
		
		//Bullet Settings
		this.bulletTexture = bulletTexture;
		this.damage = damage;
		this.knockBack = knockBack;
		
	}
	
	public void registerIcons(IconRegister iconRegister){
		
		itemIcon = iconRegister.registerIcon(gunTexture);
		this.bFull3D = true;
		
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World par2World, EntityPlayer player){
		
		ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
		if(player.getItemInUse() != itemStack){
			player.setItemInUse(itemStack, 7200);
		}
		
		
		
		return itemStack;
		
	}
	
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int itemInUseCount){
		
		int j = this.getMaxItemUseDuration(itemStack) - itemInUseCount;
		
		ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
		
		if(player.capabilities.isCreativeMode || player.inventory.hasItem(ammo.itemID)){
			
			int ammoSlot = getAmmoSlot(ammo, player);
			
			if(ammoSlot != -1 && !player.capabilities.isCreativeMode){
				
				int newAmmoDamage = player.inventory.getStackInSlot(ammoSlot).getItemDamage() + 1;
				int currentAmmoStackSize = player.inventory.getStackInSlot(ammoSlot).stackSize;
				
				if(newAmmoDamage < player.inventory.getStackInSlot(ammoSlot).getMaxDamage()){
					player.inventory.setInventorySlotContents(ammoSlot, new ItemStack(ammo, currentAmmoStackSize, newAmmoDamage));
				}else{
					
					int newAmmoStackSize = currentAmmoStackSize - 1;
					
					if(newAmmoStackSize != 0){
						player.inventory.setInventorySlotContents(ammoSlot, new ItemStack(ammo, newAmmoStackSize, 0));
					}else{
						player.inventory.setInventorySlotContents(ammoSlot, null);
					}
				}
				
			}
				
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
			if (!world.isRemote)
			{
				EntityBullet bullet = new EntityBullet(world, player, 3);
				world.spawnEntityInWorld(bullet);
				bullet.setTexture(bulletTexture);
				bullet.setDamage(this.damage);
				bullet.setKnockbackStrength(knockBack);
			}
			
		}
		
	}
	
	public int getAmmoSlot(Item ammo, EntityPlayer player){
		
		for(int slot = 0; slot < player.inventory.getSizeInventory(); slot++){
			
			if(player.inventory.getStackInSlot(slot) != null){
			
				if(player.inventory.getStackInSlot(slot).itemID == ammo.itemID){
					
					return slot;
					
				}
				
			}
			
		}
		return -1;
		
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

}
