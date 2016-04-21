package com.penpennetworks.minecraft.guisample;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class SampleGuiContainer extends GuiContainer {

	// テクスチャのパス
	//private static final ResourceLocation TEXTURE = new ResourceLocation( Reference.MOD_ID, "textures/gui/gui_texture.png" );
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");

	public SampleGuiContainer( int x, int y, int z ){
		super( new SampleContainer( x, y, z ) );
	}

	public SampleGuiContainer( InventoryPlayer player ){
		super( new SampleContainer( player ) );
	}

	public void initGui() {
		super.initGui();
		System.out.println("Initialized!!!");
	}

	/*GUIの文字等の描画処理*/
	@Override
	protected void drawGuiContainerForegroundLayer( int mouseX, int mouseZ ){
		super.drawGuiContainerForegroundLayer( mouseX, mouseZ );
		this.fontRendererObj.drawString(
				"MojyaMojyaMio", 97, 8, //I18n.format("container.crafting", new Object[0])
				4210752);
		//this.mc.renderEngine.bindTexture(TEXTURE);
		//this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
	}

	/*GUIの背景の描画処理*/
	@Override
	protected void drawGuiContainerBackgroundLayer( float partialTick, int mouseX, int mouseZ ){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	// GUIが開いている時にゲームの処理を止めるかどうか。
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
