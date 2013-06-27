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
	//ID 4000 - 4099 reserved
	public final static Block ammoBox = new BlockAmmoBox(4000).setHardness(0.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("ammobox").setCreativeTab(CreativeTabs.tabCombat);
	public final static Block weaponsBox = new BlockWeaponsBox(4001).setHardness(0.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("weaponsbox").setCreativeTab(CreativeTabs.tabCombat);
	
	//Crafting Parts
	//ID 4100 - 4199 reserved
	public final static Item ItemShot = new BasicItem(4100, "GunMod:shot").setUnlocalizedName("item_shot").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemIronPlating = new BasicItem(4101, "GunMod:IronPlating").setUnlocalizedName("item_iron_plating").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemAbsPlastic = new BasicItem(4102, "GunMod:absPlastic").setUnlocalizedName("item_absplastic").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemBallisticScope = new BasicItem(4103, "GunMod:NA").setUnlocalizedName("item_ballistic_scope").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemBipod = new BasicItem(4104, "GunMod:NA").setUnlocalizedName("item_bipod").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemCarryHandle = new BasicItem(4105, "GunMod:NA").setUnlocalizedName("item_carry_handle").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRocketExhaust = new BasicItem(4106, "GunMod:NA").setUnlocalizedName("item_rocket_exhaust").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemIronSights = new BasicItem(4107, "GunMod:NA").setUnlocalizedName("item_iron_sights").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemLMGGripTrigger = new BasicItem(4108, "GunMod:NA").setUnlocalizedName("item_lmg_grip_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemLMGStock = new BasicItem(4109, "GunMod:NA").setUnlocalizedName("item_lmg_stock").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemPistolBarrel = new BasicItem(4110, "GunMod:NA").setUnlocalizedName("item_pistol_barrel").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemPistolBolt = new BasicItem(4111, "GunMod:NA").setUnlocalizedName("item_pistol_bolt").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemPistolGripTrigger = new BasicItem(4112, "GunMod:NA").setUnlocalizedName("item_pistol_grip_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRedDotSight = new BasicItem(4113, "GunMod:NA").setUnlocalizedName("item_red_dot_sight").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRevolverChamber = new BasicItem(4114, "GunMod:NA").setUnlocalizedName("item_revolver_chamber").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRifleBarrel = new BasicItem(4115, "GunMod:NA").setUnlocalizedName("item_rifle_barrel").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRifleBolt = new BasicItem(4116, "GunMod:NA").setUnlocalizedName("item_rifle_bolt").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRifleGripTrigger = new BasicItem(4117, "GunMod:NA").setUnlocalizedName("item_rifle_grip_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRifleStock = new BasicItem(4118, "GunMod:NA").setUnlocalizedName("item_rifle_stock").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRocketTrigger = new BasicItem(4119, "GunMod:NA").setUnlocalizedName("item_rocket_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemRPGRocketTube = new BasicItem(4120, "GunMod:NA").setUnlocalizedName("item_rpg_rocket_tube").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemShoulderMount = new BasicItem(4121, "GunMod:NA").setUnlocalizedName("item_shoulder_mount").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSMAWRocketTube = new BasicItem(4122, "GunMod:NA").setUnlocalizedName("item_smaw_rocket_tube").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSMGGripTrigger = new BasicItem(4123, "GunMod:NA").setUnlocalizedName("item_smg_grip_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSMGStock = new BasicItem(4124, "GunMod:NA").setUnlocalizedName("item_smg_stock").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSniperRifleBarrel = new BasicItem(4125, "GunMod:NA").setUnlocalizedName("item_sniper_rifle_barrel").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSniperRifleGripTrigger = new BasicItem(4126, "GunMod:NA").setUnlocalizedName("item_sniper_rifle_grip_trigger").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemSniperRifleStock = new BasicItem(4127, "GunMod:NA").setUnlocalizedName("item_sniper_rifle_stock").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemTacticalSight = new BasicItem(4128, "GunMod:NA").setUnlocalizedName("item_tactical_sight").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemThermalBinoculars = new BasicItem(4129, "GunMod:NA").setUnlocalizedName("item_thermal_binoculars").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemWeaverRail = new BasicItem(4130, "GunMod:NA").setUnlocalizedName("item_weaver_rail").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	public final static Item ItemWoodenStock = new BasicItem(4131, "GunMod:NA").setUnlocalizedName("item_wooden_stock").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabCombat);
	
	//Adding Ammo
	//ID 4200 - 4299 reserved
	public final static Item ammoP90 = new Ammo(4200, "GunMod:5.7mm P90 Mag", 5).setUnlocalizedName("P90_mag");
	public final static Item ammoG36 = new Ammo(4201, "GunMod:5.56mm G36 Mag", 5).setUnlocalizedName("G36_mag");
	public final static Item ammoM16STANAG = new Ammo(4202, "GunMod:5.56mm M16 STANAG. Mag", 5).setUnlocalizedName("M16_mag");
	public final static Item ammoM249 = new Ammo(4203, "GunMod:5.56mm M249 Mag", 5).setUnlocalizedName("M249_mag");
	public final static Item ammoAKM = new Ammo(4204, "GunMod:7.62mm AKM Mag", 5).setUnlocalizedName("AKM_mag");
	public final static Item ammoDragunov = new Ammo(4205, "GunMod:7.62mm Dragunov Mag", 5).setUnlocalizedName("Dragunov_mag");
	public final static Item ammoG3 = new Ammo(4206, "GunMod:7.62mm G3 Mag", 5).setUnlocalizedName("G3_mag");
	public final static Item ammoM21 = new Ammo(4207, "GunMod:7.62mm M21 Mag", 5).setUnlocalizedName("M21_mag");
	public final static Item ammoM39EMR = new Ammo(4208, "GunMod:7.62mm M39 EMR Mag", 5).setUnlocalizedName("M39_mag");
	public final static Item ammoM40A3 = new Ammo(4209, "GunMod:7.62mm M40A3 Mag", 5).setUnlocalizedName("M40A3_mag");
	public final static Item ammoM60 = new Ammo(4210, "GunMod:7.62mm M60 Mag", 5).setUnlocalizedName("M60_mag");
	public final static Item ammoRPDDrum = new Ammo(4211, "GunMod:7.62mm RPD Drum Mag", 5).setUnlocalizedName("RPD_mag");
	public final static Item ammo357 = new Ammo(4212, "GunMod:9mm 357 Mag", 5).setUnlocalizedName("357_mag");
	public final static Item ammoG17 = new Ammo(4213, "GunMod:9mm G17 Mag", 5).setUnlocalizedName("G17_mag");
	public final static Item ammoMakarov = new Ammo(4214, "GunMod:9mm Makarov Mag", 5).setUnlocalizedName("Makarov_mag");
	public final static Item ammoMP5 = new Ammo(4215, "GunMod:9mm MP5 Mag", 5).setUnlocalizedName("MP5_mag");
	public final static Item ammoDesertEagle = new Ammo(4216, "GunMod:50. Cal. Desert Eagle Mag", 5).setUnlocalizedName("Desert_mag");
	public final static Item ammoBarrett = new Ammo(4217, "GunMod:Barrett 50. Cal. Mag", 5).setUnlocalizedName("Barrett_mag");
	public final static Item ammoM1911 = new Ammo(4218, "GunMod:M1911 .45 ACP Mag", 5).setUnlocalizedName("M1911_mag");
	public final static Item ammoRocketGrenade = new Ammo(4219, "GunMod:Rocket Grenade", 5).setUnlocalizedName("Rocket_Grenade_mag");
	public final static Item ammoBuckshot = new Ammo(4220, "GunMod:12G BUCKSHOT Shells", 5).setUnlocalizedName("Buckshot_Shells_mag");
	
	//Adding guns
	//ID 4300 - 4399 reserved
	public final static Item gun357Magnum = new Gun(4300, "GunMod:357 Magnum", CreativeTabs.tabCombat, true, ammo357, "Bullet", (double)1, 1).setUnlocalizedName("gun 357 Magnum");
	public final static Item gunAK47 = new Gun(4301, "GunMod:AK47", CreativeTabs.tabCombat, true, ammoAKM, "Bullet", (double)1, 1).setUnlocalizedName("gun AK 47");
	public final static Item gunAK74 = new Gun(4302, "GunMod:AK74", CreativeTabs.tabCombat, true, ammoAKM, "Bullet", (double)1, 1).setUnlocalizedName("gun AK 74");
	public final static Item gunBarrett = new Gun(4303, "GunMod:Barrett", CreativeTabs.tabCombat, true, ammoBarrett, "Bullet", (double)1, 1).setUnlocalizedName("gun Barrett");
	public final static Item gunDesertEagle = new Gun(4304, "GunMod:Desert Eagle", CreativeTabs.tabCombat, true, ammoDesertEagle, "Bullet", (double)1, 1).setUnlocalizedName("gun Desert Eagle");
	public final static Item gunDragunov = new Gun(4305, "GunMod:Dragunov", CreativeTabs.tabCombat, true, ammoDragunov, "Bullet", (double)1, 1).setUnlocalizedName("gun Dragunov");
	public final static Item gunG3 = new Gun(4306, "GunMod:G3", CreativeTabs.tabCombat, true, ammoG3, "Bullet", (double)1, 1).setUnlocalizedName("gun G3");
	public final static Item gunG17 = new Gun(4307, "GunMod:G17", CreativeTabs.tabCombat, true, ammoG17, "Bullet", (double)1, 1).setUnlocalizedName("gun G17");
	public final static Item gunG36 = new Gun(4308, "GunMod:G36", CreativeTabs.tabCombat, true, ammoG36, "Bullet", (double)1, 1).setUnlocalizedName("gun G36");
	public final static Item gunM16A4 = new Gun(4309, "GunMod:M16A4", CreativeTabs.tabCombat, true, ammoM16STANAG, "Bullet", (double)1, 1).setUnlocalizedName("gun M16A4");
	public final static Item gunM21 = new Gun(4310, "GunMod:M21", CreativeTabs.tabCombat, true, ammoM21, "Bullet", (double)1, 1).setUnlocalizedName("gun M21");
	public final static Item gunM39EMR = new Gun(4311, "GunMod:M39 EMR", CreativeTabs.tabCombat, true, ammoM39EMR, "Bullet", (double)1, 1).setUnlocalizedName("gun M39 EMR");
	public final static Item gunM40A3 = new Gun(4312, "GunMod:M40A3", CreativeTabs.tabCombat, true, ammoM40A3, "Bullet", (double)1, 1).setUnlocalizedName("gun M40A3");
	public final static Item gunM60E4 = new Gun(4313, "GunMod:M60E4", CreativeTabs.tabCombat, true, ammoM60, "Bullet", (double)1, 1).setUnlocalizedName("gun M60E4");
	public final static Item gunM249 = new Gun(4314, "GunMod:M249", CreativeTabs.tabCombat, true, ammoM249, "Bullet", (double)1, 1).setUnlocalizedName("gun M249");
	public final static Item gunM1014 = new Gun(4315, "GunMod:M1014", CreativeTabs.tabCombat, true, ammoBuckshot, "Bullet", (double)1, 1).setUnlocalizedName("gun M1014");
	public final static Item gunM1911 = new Gun(4316, "GunMod:M1911", CreativeTabs.tabCombat, true, ammoM1911, "Bullet", (double)1, 1).setUnlocalizedName("gun M1911");
	public final static Item gunMakarov = new Gun(4317, "GunMod:Makarov", CreativeTabs.tabCombat, true, ammoMakarov, "Bullet", (double)1, 1).setUnlocalizedName("gun Makarov");
	public final static Item gunMP5 = new Gun(4318, "GunMod:MP5", CreativeTabs.tabCombat, true, ammoMP5, "Bullet", (double)1, 1).setUnlocalizedName("gun MP5");
	public final static Item gunP90 = new Gun(4319, "GunMod:P90", CreativeTabs.tabCombat, true, ammoP90, "Bullet", (double)1, 1).setUnlocalizedName("gun P90");
	public final static Item gunRPD = new Gun(4320, "GunMod:RPD", CreativeTabs.tabCombat, true, ammoRPDDrum, "Bullet", (double)1, 1).setUnlocalizedName("gun RPD");
	public final static Item gunRPG = new Gun(4321, "GunMod:RPG", CreativeTabs.tabCombat, true, ammoRocketGrenade, "Bullet", (double)1, 1).setUnlocalizedName("gun RPG");
	public final static Item gunSMAW = new Gun(4322, "GunMod:SMAW", CreativeTabs.tabCombat, true, ammoRocketGrenade, "Bullet", (double)1, 1).setUnlocalizedName("gun SMAW");
	public final static Item gunSpas12 = new Gun(4323, "GunMod:Spas-12", CreativeTabs.tabCombat, true, ammoBuckshot, "Bullet", (double)1, 1).setUnlocalizedName("gun Spas-12");
	
	//Stufffffs
	private MinelegionGuiHandler minelegionGuiHandler = new MinelegionGuiHandler();
	
	@Instance("GunMod")
	public static GunMod instance;
	
	@SidedProxy(clientSide="me.jacobschwartz.gunMod.client.ClientProxy", serverSide="me.jacobschwartz.gunMod.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		
		 int entityID = EntityRegistry.findGlobalUniqueEntityId();
         //EntityRegistry.registerGlobalEntityID(EntityBullet.class, "EntityBullet", entityID);
		
		//Register entities
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", entityID, GunMod.instance, 128, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Bullet.name", "Bullet");
		
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
		LanguageRegistry.addName(ItemShot, "Shot");
		LanguageRegistry.addName(ItemIronPlating, "Iron Plating");
		LanguageRegistry.addName(ItemAbsPlastic, "ABS Plastic");
		LanguageRegistry.addName(ItemBallisticScope, "Ballistic Scope");
		LanguageRegistry.addName(ItemBipod, "Bipod");
		LanguageRegistry.addName(ItemCarryHandle, "Carry Handle");
		LanguageRegistry.addName(ItemRocketExhaust, "Rocket Exhaust");
		LanguageRegistry.addName(ItemIronSights, "Iron Sights");
		LanguageRegistry.addName(ItemLMGGripTrigger, "LMG Grip & Trigger");
		LanguageRegistry.addName(ItemLMGStock, "LMG Stock");
		LanguageRegistry.addName(ItemPistolBarrel, "Pistol Barrel");
		LanguageRegistry.addName(ItemPistolBolt, "Pistol Bolt");
		LanguageRegistry.addName(ItemPistolGripTrigger, "Pistol Grip & Trigger");
		LanguageRegistry.addName(ItemRedDotSight, "Red Dot Sight");
		LanguageRegistry.addName(ItemRevolverChamber, "Revolver Chamber");
		LanguageRegistry.addName(ItemRifleBarrel, "Rifle Barrel");
		LanguageRegistry.addName(ItemRifleBolt, "Rifle Bolt");
		LanguageRegistry.addName(ItemRifleGripTrigger, "Rifle Grip & Trigger");
		LanguageRegistry.addName(ItemRifleStock, "Rifle Stock");
		LanguageRegistry.addName(ItemRocketTrigger, "Rocket Trigger");
		LanguageRegistry.addName(ItemRPGRocketTube, "RPG Rocket Tube");
		LanguageRegistry.addName(ItemShoulderMount, "Shoulder Mount");
		LanguageRegistry.addName(ItemSMAWRocketTube, "SMAW Rocket Tube");
		LanguageRegistry.addName(ItemSMGGripTrigger, "SMG Grip & Trigger");
		LanguageRegistry.addName(ItemSMGStock, "SMG STOCK");
		LanguageRegistry.addName(ItemSniperRifleBarrel, "Sniper Rifle Barrel");
		LanguageRegistry.addName(ItemSniperRifleGripTrigger, "Sniper Rifle Grip & Trigger");
		LanguageRegistry.addName(ItemSniperRifleStock, "Sniper Rifle Stock");
		LanguageRegistry.addName(ItemTacticalSight, "Tactical Sight");
		LanguageRegistry.addName(ItemThermalBinoculars, "Thermal Binoculars");
		LanguageRegistry.addName(ItemWeaverRail, "Weaver Rail");
		LanguageRegistry.addName(ItemWoodenStock, "Wooden Stock");
		
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
		LanguageRegistry.addName(ammoBuckshot, "12G BUCKSHOT Shells");
		
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
		GameRegistry.addRecipe(new ItemStack(weaponsBox, 1, 0), "xxx", "yyy", "yyy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Block.workbench));
		GameRegistry.addRecipe(new ItemStack(ammoBox, 1, 0), "xxx", "yyy", "xxx", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Block.workbench));
		
		//Adding Crafting parts Crafting recipes
		GameRegistry.addRecipe(new ItemStack(ItemIronPlating, 16), "   ", "xxx", "   ", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemShot, 16), new ItemStack(Item.gunpowder, 1));
		GameRegistry.addSmelting(Item.reed.itemID, new ItemStack(ItemAbsPlastic, 6), 0.0F);
		GameRegistry.addRecipe(new ItemStack(ItemBallisticScope, 12, 0), "xxy", "yzy", "xxy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Block.glass), 'z', new ItemStack(Item.lightStoneDust));
		GameRegistry.addRecipe(new ItemStack(ItemBipod, 1, 0), " x ", "yxy", "y y", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemCarryHandle, 1, 0), "   ", "xxx", "y y", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemRocketExhaust, 1, 0), " xy", "xy ", " xy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemIronSights, 1, 0), "   ", "y y", "xxx", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemLMGGripTrigger, 1, 0), "xxx", "xyy", "zyc", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Item.leather), 'c', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemLMGStock, 1, 0), "   ", "xxy", "yyy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemPistolBarrel, 1, 0), "   ", " yy", "   ", 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemPistolBolt, 1, 0), "  x", " yy", "   ", 'x', new ItemStack(Item.stick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemPistolGripTrigger, 1, 0), "   ", " xx", "zyc", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Item.leather), 'c', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemRedDotSight, 1, 0), "xxx", "yzy", "xxx", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Block.glass), 'z', new ItemStack(Item.redstone));
		GameRegistry.addRecipe(new ItemStack(ItemRevolverChamber, 1, 0), "xxx", "  x", "xxx", 'x', new ItemStack(ItemIronPlating));
		GameRegistry.addRecipe(new ItemStack(ItemRifleBarrel, 1, 0), "   ", "yyy", "xx ", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemRifleBolt, 1, 0), "  x", "yyy", "   ", 'x', new ItemStack(Item.stick), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemRifleGripTrigger, 1, 0), "   ", "xxy", " zc", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Item.leather), 'c', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemRifleStock, 1, 0), "   ", "yyx", " xx", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemRocketTrigger, 1, 0), "   ", "yyy", "  x", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemRPGRocketTube, 1, 0), "xxx", "   ", "xxx", 'x', new ItemStack(ItemIronPlating));
		GameRegistry.addRecipe(new ItemStack(ItemShoulderMount, 1, 0), "   ", "xxx", " yy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.leather));
		GameRegistry.addRecipe(new ItemStack(ItemSMAWRocketTube, 1, 0), "yxx", "   ", "yxx", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemSMGGripTrigger, 1, 0), " xx", " yy", " zc", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Item.leather), 'c', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemSMGStock, 1, 0), "   ", "xxy", " zy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Block.planks));
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifleBarrel, 1, 0), "   ", "yyy", " xx", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifleGripTrigger, 1, 0), "xxx", "yyy", " zc", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Item.leather), 'c', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifleStock, 1, 0), "   ", "yyx", " yx", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemTacticalSight, 1, 0), " yy", " xx", " yy", 'x', new ItemStack(Item.redstone), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemThermalBinoculars, 1, 0), "yxy", "zcv", "yxy", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(Block.glass), 'c', new ItemStack(Item.lightStoneDust), 'v', new ItemStack(Item.redstone));
		GameRegistry.addRecipe(new ItemStack(ItemWeaverRail, 1, 0), "   ", "y y", "xxx", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ItemWoodenStock, 1, 0), "   ", "xxy", "zzz", 'x', new ItemStack(ItemIronPlating), 'y', new ItemStack(Item.stick), 'z', new ItemStack(Block.planks));
		
		//Adding Gun Recipes
		GameRegistry.addRecipe(new ItemStack(gun357Magnum), "   ", "xxy", "y  ", 'x', new ItemStack(Block.planks), 'y', new ItemStack(Block.cobblestone));
		
		//Adding Ammo recipes
		GameRegistry.addRecipe(new ItemStack(ammo357), " x ", "x x", " x ", 'x', new ItemStack(ItemShot));
		
		NetworkRegistry.instance().registerGuiHandler(this, minelegionGuiHandler);
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
		
		
	}
	
	
}
