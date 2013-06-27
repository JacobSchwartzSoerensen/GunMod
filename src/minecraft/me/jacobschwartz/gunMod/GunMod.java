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
	public final static Item ammoBarrett = new Ammo(4022, "GunMod:Barrett 50. Cal. Mag", 5).setUnlocalizedName("Barrett_mag");
	public final static Item ammoM1911 = new Ammo(4022, "GunMod:M1911 .45 ACP Mag", 5).setUnlocalizedName("M1911_mag");
	public final static Item ammoRocketGrenade = new Ammo(4023, "GunMod:Rocket Grenade", 5).setUnlocalizedName("Rocket_Grenade_mag");
	
	//Dafuq is this shizzle:
	//12G Buckshot shells
	
	//Adding guns
	public final static Item gun357Magnum = new Gun(4024, "GunMod:357 Magnum", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1).setUnlocalizedName("gun 357 Magnum");
	public final static Item gunAK47 = new Gun(4025, "GunMod:AK47", CreativeTabs.tabCombat, true, ammoAKM, "Bullet", (double)1, 1).setUnlocalizedName("gun AK 47");
	public final static Item gunAK74 = new Gun(4026, "GunMod:AK74", CreativeTabs.tabCombat, true, ammoAKM, "Bullet", (double)1, 1).setUnlocalizedName("gun AK 74");
	public final static Item gunBarrett = new Gun(4027, "GunMod:Barrett", CreativeTabs.tabCombat, true, ammoBarrett, "Bullet", (double)1, 1).setUnlocalizedName("gun Barrett");
	public final static Item gunDesertEagle = new Gun(4028, "GunMod:Desert Eagle", CreativeTabs.tabCombat, true, ammoDesertEagle, "Bullet", (double)1, 1).setUnlocalizedName("gun Desert Eagle");
	public final static Item gunDragunov = new Gun(4029, "GunMod:Dragunov", CreativeTabs.tabCombat, true, ammoDragunov, "Bullet", (double)1, 1).setUnlocalizedName("gun Dragunov");
	public final static Item gunG3 = new Gun(4030, "GunMod:G3", CreativeTabs.tabCombat, true, ammoG3, "Bullet", (double)1, 1).setUnlocalizedName("gun G3");
	public final static Item gunG17 = new Gun(4031, "GunMod:G17", CreativeTabs.tabCombat, true, ammoG17, "Bullet", (double)1, 1).setUnlocalizedName("gun G17");
	public final static Item gunG36 = new Gun(4032, "GunMod:G36", CreativeTabs.tabCombat, true, ammoG36, "Bullet", (double)1, 1).setUnlocalizedName("gun G36");
	public final static Item gunM16A4 = new Gun(4033, "GunMod:M16A4", CreativeTabs.tabCombat, true, ammoM16STANAG, "Bullet", (double)1, 1).setUnlocalizedName("gun M16A4");
	public final static Item gunM21 = new Gun(4034, "GunMod:M21", CreativeTabs.tabCombat, true, ammoM21, "Bullet", (double)1, 1).setUnlocalizedName("gun M21");
	public final static Item gunM39EMR = new Gun(4035, "GunMod:M39 EMR", CreativeTabs.tabCombat, true, ammoM39EMR, "Bullet", (double)1, 1).setUnlocalizedName("gun M39 EMR");
	public final static Item gunM40A3 = new Gun(4036, "GunMod:M40A3", CreativeTabs.tabCombat, true, ammoM40A3, "Bullet", (double)1, 1).setUnlocalizedName("gun M40A3");
	public final static Item gunM60E4 = new Gun(4037, "GunMod:M60E4", CreativeTabs.tabCombat, true, ammoM60, "Bullet", (double)1, 1).setUnlocalizedName("gun M60E4");
	public final static Item gunM249 = new Gun(4038, "GunMod:M249", CreativeTabs.tabCombat, true, ammoM249, "Bullet", (double)1, 1).setUnlocalizedName("gun M249");
	public final static Item gunM1014 = new Gun(4039, "GunMod:M1014", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1).setUnlocalizedName("gun M1014");//Need ammo
	public final static Item gunM1911 = new Gun(4040, "GunMod:M1911", CreativeTabs.tabCombat, true, ammoM1911, "Bullet", (double)1, 1).setUnlocalizedName("gun M1911");
	public final static Item gunMakarov = new Gun(4041, "GunMod:Makarov", CreativeTabs.tabCombat, true, ammoMakarov, "Bullet", (double)1, 1).setUnlocalizedName("gun Makarov");
	public final static Item gunMP5 = new Gun(4042, "GunMod:MP5", CreativeTabs.tabCombat, true, ammoMP5, "Bullet", (double)1, 1).setUnlocalizedName("gun MP5");
	public final static Item gunP90 = new Gun(4043, "GunMod:P90", CreativeTabs.tabCombat, true, ammoP90, "Bullet", (double)1, 1).setUnlocalizedName("gun P90");
	public final static Item gunRPD = new Gun(4044, "GunMod:RPD", CreativeTabs.tabCombat, true, ammoRPDDrum, "Bullet", (double)1, 1).setUnlocalizedName("gun RPD");
	public final static Item gunRPG = new Gun(4045, "GunMod:RPG", CreativeTabs.tabCombat, true, ammoRocketGrenade, "Bullet", (double)1, 1).setUnlocalizedName("gun RPG");
	public final static Item gunSMAW = new Gun(4046, "GunMod:SMAW", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1).setUnlocalizedName("gun SMAW");//Need ammo
	public final static Item gunSpas12 = new Gun(4047, "GunMod:Spas-12", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1).setUnlocalizedName("gun Spas-12");//Need ammo
	
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
		LanguageRegistry.addName(ammoBarrett, "Barrett 50. Cal. Mag.");
		LanguageRegistry.addName(ammoM1911, "M1911 .45 ACP Mag.");
		LanguageRegistry.addName(ammoRocketGrenade, "Rocket Grenade");
		
		//Adding guns names
		LanguageRegistry.addName(gun357Magnum, "357 Magnum");
		LanguageRegistry.addName(gunAK47, "AK47");
		LanguageRegistry.addName(gunAK74, "AK74");
		LanguageRegistry.addName(gunBarrett, "Barrett");
		LanguageRegistry.addName(gunDesertEagle, "Desert Eagle");
		LanguageRegistry.addName(gunDragunov, "Dragunov");
		LanguageRegistry.addName(gunG3, "G3");
		LanguageRegistry.addName(gunG17, "G17");
		LanguageRegistry.addName(gunG36, "G36");
		LanguageRegistry.addName(gunM16A4, "M16A4");
		LanguageRegistry.addName(gunM21, "M21");
		LanguageRegistry.addName(gunM39EMR, "M39 EMR");
		LanguageRegistry.addName(gunM40A3, "M40A3");
		LanguageRegistry.addName(gunM60E4, "M60E4");
		LanguageRegistry.addName(gunM249, "M249");
		LanguageRegistry.addName(gunM1014, "M1014");
		LanguageRegistry.addName(gunM1911, "M1911");
		LanguageRegistry.addName(gunMakarov, "Makarov");
		LanguageRegistry.addName(gunMP5, "MP5");
		LanguageRegistry.addName(gunP90, "P90");
		LanguageRegistry.addName(gunRPD, "RPD");
		LanguageRegistry.addName(gunRPG, "RPG");
		LanguageRegistry.addName(gunSMAW, "SMAW");
		LanguageRegistry.addName(gunSpas12, "Spas-12");
		
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
