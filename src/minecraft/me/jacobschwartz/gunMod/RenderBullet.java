package me.jacobschwartz.gunMod;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;

public class RenderBullet extends Render {
	
	private ModelBase modelBullet;
	
	public RenderBullet(ModelBase modelBase){
		
		modelBullet = modelBase;
		
	}

	public void renderBullet(EntityBullet bullet, double x, double y, double z, float par8, float par9)
    {
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(bullet.prevRotationYaw + (bullet.rotationYaw - bullet.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(bullet.rotationPitch + (bullet.rotationPitch - bullet.prevRotationPitch) * par9, 1.0F, 0.0F, 0.0F);
		
		this.loadTexture("/mods/GunMod/textures/items/"+bullet.getTexture()+".png");
		
		modelBullet.render(bullet, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.02F);
        
		//Resets rotation and translation
		GL11.glPopMatrix();
		
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
	@Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBullet((EntityBullet)par1Entity, par2, par4, par6, par8, par9);
    }

}
