package com.kreezcraft.sheepsreloaded.gui;

import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.inventory.ContainerSeparator;
import com.kreezcraft.sheepsreloaded.tileentities.TileEntitySeparator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dan on 3/3/2016.
 */
public class GuiSeparator extends SheepsGuiBase {
    private final TileEntitySeparator te;
    private final ResourceLocation guiTexture;

    final int COOK_BAR_XPOS = 80;
    final int COOK_BAR_YPOS = 34;
    final int COOK_BAR_ICON_U = 176;   // texture position of white arrow icon
    final int COOK_BAR_ICON_V = 14;
    final int COOK_BAR_WIDTH = 24;
    final int COOK_BAR_HEIGHT = 17;

    final int FLAME_XPOS = -9;
    final int FLAME_YPOS = 37;
    final int FLAME_ICON_U = 176;   // texture position of flame icon
    final int FLAME_ICON_V = 0;
    final int FLAME_WIDTH = 14;
    final int FLAME_HEIGHT = 14;
    final int FLAME_X_SPACING = 18;

    public GuiSeparator(InventoryPlayer playerInventory, String guiTextureName, TileEntitySeparator te) {
        super(new ContainerSeparator(playerInventory, te), "separator", te);
        guiTexture = new ResourceLocation(Reference.MODID + ":textures/gui/" + guiTextureName + ".png");
        this.te = te;
    }

    @Override
    public void initGui(){
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        super.drawGuiContainerBackgroundLayer(partialTicks, x, y);

        // get cook progress as a double between 0 and 1
        double cookProgress = te.fractionOfCookTimeComplete();

        // draw the cook progress bar
        drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_ICON_U, COOK_BAR_ICON_V,
                (int)(cookProgress * COOK_BAR_WIDTH), COOK_BAR_HEIGHT);

        // draw the fuel remaining bar for each fuel slot flame
        double burnRemaining = te.fractionOfFuelRemaining();
        int yOffset = (int)((1.0 - burnRemaining) * FLAME_HEIGHT);
        drawTexturedModalRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING, guiTop + FLAME_YPOS + yOffset,
                FLAME_ICON_U, FLAME_ICON_V + yOffset, FLAME_WIDTH, FLAME_HEIGHT - yOffset);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        final int LABEL_XPOS = 5;
        final int LABEL_YPOS = 5;
        //fontRendererObj.drawString(te.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

        List<String> hoveringText = new ArrayList<String>();

        // If the mouse is over the progress bar add the progress bar hovering text
        if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX, mouseY)){
            hoveringText.add("Progress:");
            int cookPercentage =(int)(te.fractionOfCookTimeComplete() * 100);
            hoveringText.add(cookPercentage + "%");
        }

        // If the mouse is over one of the burn time indicator add the burn time indicator hovering text
        if (isInRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Fuel Time:");
            hoveringText.add(te.secondsOfFuelRemaining() + "s");
        }

        // If hoveringText is not empty draw the hovering text
        if (!hoveringText.isEmpty()){
            drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
        }
//		// You must re bind the texture and reset the colour if you still need to use it after drawing a string
//		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
//		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY){
        return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
    }
}
