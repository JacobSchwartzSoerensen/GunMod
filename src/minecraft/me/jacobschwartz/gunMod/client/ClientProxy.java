package me.jacobschwartz.gunMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import me.jacobschwartz.gunMod.CommonProxy;
import me.jacobschwartz.gunMod.EntityBullet;
import me.jacobschwartz.gunMod.ModelBullet;
import me.jacobschwartz.gunMod.RenderBullet;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders(){
		
		/*MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);*/
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(new ModelBullet()));
		
	}
	
}
