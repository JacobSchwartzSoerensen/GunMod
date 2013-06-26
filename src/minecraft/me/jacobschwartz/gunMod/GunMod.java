package me.jacobschwartz.gunMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="GunMod", name="Gun Mod", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GunMod {
	
	//Adding Creative tabs
	
	//Adding Blocks
	public final static Block ammoBox = new BlockAmmoBox(4000).setHardness(0.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("ammobox").setCreativeTab(CreativeTabs.tabCombat);
	public final static Block weaponsBox = new BlockWeaponsBox(4001).setHardness(0.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("weaponsbox").setCreativeTab(CreativeTabs.tabCombat);
	
	//Crafting Parts
	public final static Item shot = new BasicItem(4002, "GunMod:shot").setUnlocalizedName("shot").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ironPlating = new BasicItem(4003, "GunMod:IronPlating").setUnlocalizedName("ironplating").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item absPlastic = new BasicItem(4004, "GunMod:absPlastic").setUnlocalizedName("absplastic").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	
	//Adding Ammo
	public final static Item ammoP90 = new Ammo(4005, "GunMod:5.7mm P90 Mag", 5).setUnlocalizedName("P90_mag");
	public final static Item ammoG36 = new Ammo(4006, "GunMod:5.56mm G36 Mag", 5).setUnlocalizedName("G36_mag");
	public final static Item ammoM16STANAG = new Ammo(4007, "GunMod:5.56mm M16 STANAG. Mag", 5).setUnlocalizedName("M16_mag");
	public final static Item ammoM249 = new Ammo(4008, "GunMod:5.56mm M249 Mag", 5).setUnlocalizedName("M249_mag");
	public final static Item ammoAKM = new Ammo(4009, "GunMod:7.62mm AKM Mag", 5).setUnlocalizedName("AKM_mag");
	public final static Item ammoDragunov = new Ammo(4010, "GunMod:7.62mm Dragunov Mag", 5).setUnlocalizedName("Dragunov_mag");
	public final static Item ammoG3 = new Ammo(4011, "GunMod:7.62mm G3 Mag", 5).setUnlocalizedName("G3_mag");
	public final static Item ammoM21 = new Ammo(4012, "GunMod:7.62mm M21 Mag", 5).setUnlocalizedName("M21_mag");
	public final static Item ammoM39EMR = new Ammo(4013, "GunMod:7.62mm M39 EMR Mag", 5).setUnlocalizedName("M39_mag");
	public final static Item ammoM40A3 = new Ammo(4014, "GunMod:7.62mm M40A3 Mag", 5).setUnlocalizedName("M40A3_mag");
	public final static Item ammoM60 = new Ammo(4015, "GunMod:7.62mm M60 Mag", 5).setUnlocalizedName("M60_mag");
	public final static Item ammoRPDDrum = new Ammo(4016, "GunMod:7.62mm RPD Drum Mag", 5).setUnlocalizedName("RPD_mag");
	public final static Item ammo357 = new Ammo(4017, "GunMod:9mm 357 Mag", 5).setUnlocalizedName("357_mag");
	public final static Item ammoG17 = new Ammo(4018, "GunMod:9mm G17 Mag", 5).setUnlocalizedName("G17_mag");
	public final static Item ammoMakarov = new Ammo(4019, "GunMod:9mm Makarov Mag", 5).setUnlocalizedName("Makarov_mag");
	public final static Item ammoMP5 = new Ammo(4020, "GunMod:9mm MP5 Mag", 5).setUnlocalizedName("MP5_mag");
	public final static Item ammoDesertEagle = new Ammo(4021, "GunMod:50. Cal. Desert Eagle Mag", 5).setUnlocalizedName("Desert_mag");
	
	//Dafuq is this shizzle:
	//12G Buckshot shells
	
	//Adding guns
	public final static Item gun357Magnum = new Gun(4022, "GunMod:357 Magnum", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1);
	
	//Stufffffs
	private MinelegionGuiHandler minelegionGuiHandler = new MinelegionGuiHandler();
	
	@Instance("GunMod")
	public static GunMod instance;
	
	@SidedProxy(clientSide="me.jacobschwartz.gunMod.client.ClientProxy", serverSide="me.jacobschwartz.gunMod.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		
		
		
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		
		proxy.registerRenders();
		
		//Register/naming Blocks
		GameRegistry.registerBlock(weaponsBox, "weaponsbox");
		LanguageRegistry.addName(weaponsBox, "Weapons Box");
		
		GameRegistry.registerBlock(ammoBox, "ammobox");
		LanguageRegistry.addName(ammoBox, "Ammo Box");
		
		//Adding Crafting parts names
		LanguageRegistry.addName(shot, "Shot");
		LanguageRegistry.addName(ironPlating, "Iron Plating");
		LanguageRegistry.addName(absPlastic, "ABS Plastic");
		
		//Adding Ammo names
		LanguageRegistry.addName(ammoP90, "5.7mm P90 Mag.");
		LanguageRegistry.addName(ammoG36, "5.56mm G36 Mag.");
		LanguageRegistry.addName(ammoM16STANAG, "5.56mm M16 STANAG. Mag.");
		LanguageRegistry.addName(ammoM249, "5.56mm M249 Mag.");
		LanguageRegistry.addName(ammoAKM, "7.62mm AKM Mag.");
		LanguageRegistry.addName(ammoDragunov, "7.62mm Dragunov Mag.");
		LanguageRegistry.addName(ammoG3, "7.62mm G3 Mag.");
		LanguageRegistry.addName(ammoM21, "7.62mm M21 Mag.");
		LanguageRegistry.addName(ammoM39EMR, "7.62mm M39 EMR Mag.");
		LanguageRegistry.addName(ammoM40A3, "7.62mm M40A3 Mag.");
		LanguageRegistry.addName(ammoM60, "7.62mm M60 Mag.");
		LanguageRegistry.addName(ammoRPDDrum, "7.62mm RPD Drum Mag.");
		LanguageRegistry.addName(ammo357, "9mm 357 Mag.");
		LanguageRegistry.addName(ammoG17, "9mm G17 Mag.");
		LanguageRegistry.addName(ammoMakarov, "9mm Makarov Mag.");
		LanguageRegistry.addName(ammoMP5, "9mm MP5 Mag.");
		LanguageRegistry.addName(ammoDesertEagle, "50. Cal. Desert Eagle Mag.");
		
		//Adding guns names
		LanguageRegistry.addName(gun357Magnum, "357 Magnum");
		
		
		//Adding Blocks Recipes
		GameRegistry.addRecipe(new ItemStack(weaponsBox, 1, 0), "xxx", "yyy", "yyy", 'x', new ItemStack(ironPlating), 'y', new ItemStack(Block.workbench));
		GameRegistry.addRecipe(new ItemStack(ammoBox, 1, 0), "xxx", "yyy", "xxx", 'x', new ItemStack(ironPlating), 'y', new ItemStack(Block.workbench));
		
		//Adding Gun Recipes
		GameRegistry.addRecipe(new ItemStack(gun357Magnum), "   ", "xxy", "y  ", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Block.cobblestone));
		
		//Adding Ammo recipes
		GameRegistry.addRecipe(new ItemStack(ammo357), " x ", "x x", " x ", 'x', new ItemStack(shot));
		
		//Adding Parts Recipes
		GameRegistry.addRecipe(new ItemStack(ironPlating, 16), "   ", "xxx", "   ", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addShapelessRecipe(new ItemStack(shot, 16), new ItemStack(Item.gunpowder, 1));
		GameRegistry.addSmelting(Item.reed.itemID, new ItemStack(absPlastic, 6), 0.0F);
		
		
		//Register entities
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 1, this, 100, 1, false);
		LanguageRegistry.instance().addStringLocalization("entity.Bullet.name", "Bullet");
		
		NetworkRegistry.instance().registerGuiHandler(this, minelegionGuiHandler);
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
		
		
	}
	
	
}
