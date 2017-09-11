package com.kreezcraft.sheepsreloaded.entities.renderers;

import com.kreezcraft.sheepsreloaded.entities.EntityOreSheep;
import com.kreezcraft.sheepsreloaded.entities.layers.LayerOreSheep;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Dan on 2/28/2016.
 */
public class RenderOreSheep extends RenderLiving<EntityOreSheep> {

    //private static final ResourceLocation shearedSheepTextures = new ResourceLocation("sheeeps:textures/entity/iron_ore_sheep_sheared.png");

    public RenderOreSheep(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
        this.addLayer(new LayerOreSheep(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityOreSheep entity) {
        return entity.getShearedTexture();
    }

    /* May not use */
    protected ResourceLocation getFurTexture(EntityOreSheep entity){
        return entity.getFurTexture();
    }
}
