package com.zulucap.sheeeps.entities.layers;

import com.zulucap.sheeeps.entities.EntityOreSheep;
import com.zulucap.sheeeps.entities.models.ModelOreSheepFur;
import com.zulucap.sheeeps.entities.renderers.RenderOreSheep;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntitySheep;

/**
 * Created by Dan on 2/28/2016.
 */
public class LayerOreSheep implements LayerRenderer<EntityOreSheep> {
    //private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID+":textures/entity/iron_ore_sheep_fur.png");
    private final RenderOreSheep sheepRenderer;
    private final ModelOreSheepFur sheepModel = new ModelOreSheepFur();

    public LayerOreSheep(RenderOreSheep sheepRendererIn)
    {
        this.sheepRenderer = sheepRendererIn;
    }

    @Override
    public void doRenderLayer(EntityOreSheep entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible())
        {
            this.sheepRenderer.bindTexture(entitylivingbaseIn.getFurTexture());

            float[] afloat = EntitySheep.func_175513_a(entitylivingbaseIn.getFleeceColor());
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);

            this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
            this.sheepModel.setLivingAnimations(entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks);
            this.sheepModel.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
