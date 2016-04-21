package com.penpennetworks.minecraft.guisample;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION )
public class GUISampleCore {

	@Mod.Instance(Reference.MOD_ID)
	public static GUISampleCore INSTANCE;

	public static Block guiBlock;
	public static Item  guiItem;

	// Mod内での識別用ID
	// 同じMod内でかぶらなければいくつでも良い。
	// 複数のGUIを作成するModの場合は気をつける
	public final static int GUI_ID = 0;

	// Proxy
	@SidedProxy( clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS )
	public static CommonProxy proxy;

	// Event Handlers
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){

		// ブロック登録の準備
		guiBlock = new BlockGUISample();
		ResourceLocation registryName = new ResourceLocation(Reference.MOD_ID,"guiblock");
		ItemBlock guiItemBlock = new ItemBlock(guiBlock);

		// ブロック登録
		GameRegistry.register(guiBlock, registryName);
		GameRegistry.register(guiItemBlock, registryName);

		// クライアントサイド Only
		if( e.getSide() == Side.CLIENT ){

			// ブロックのモデル情報を登録
			ModelLoader.setCustomModelResourceLocation(
				guiItemBlock,
				0,
				new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID,"guiblock"), "inventory")
			);

		}

		// リソースロケーションを設定する
		proxy.registerRenders(); // 実は何もしてない

	}

	@EventHandler
	public void init(FMLInitializationEvent e){
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
	}

}
