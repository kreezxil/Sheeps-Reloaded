package com.kreezcraft.sheepsreloaded.gui;

import com.kreezcraft.sheepsreloaded.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Dan on 3/3/2016.
 */
public class SheeepsGuiBase extends GuiContainer {

    private final ResourceLocation guiTexture;
    private final IInventory inventory;

    public SheeepsGuiBase(Container container, String guiTextureName, IInventory inventory){
        super(container);

        guiTexture = new ResourceLocation(Reference.MODID + ":textures/gui/" + guiTextureName + ".png");
        this.inventory = inventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        //mc.getTextureManager().bindTexture(guiTexture);
        //drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // Bind the image texture
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        String s = inventory.hasCustomName() ? inventory.getName() : I18n.format(inventory.getName());
        fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
}
