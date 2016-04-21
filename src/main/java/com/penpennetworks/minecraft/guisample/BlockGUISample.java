package com.penpennetworks.minecraft.guisample;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGUISample extends Block {

	public BlockGUISample() {
		super(Material.rock);					// 素材を石っぽいやつにする
		setCreativeTab(CreativeTabs.tabBlock);	// ブロックのグループ
		setUnlocalizedName("guiblock");			// ブロック名
		setHardness(1);							// 硬さ
	}

	@Override
	public boolean onBlockActivated(
		World world,			// ブロックが起動されたWorld
		BlockPos blockpos,		// 起動されたブロックの場所
		IBlockState blockstate,	// 起動されたブロックの状態
		EntityPlayer player,	// 起動したプレイヤー
		EnumHand hand,			// 起動した手？
		ItemStack handitem,		// 持っているアイテム
		EnumFacing facing,		// 起動した向き
		float hitX,				// たたいた場所 X
		float hitY,				// たたいた場所 Y
		float hitZ				// たたいた場所 Z
	) {
		// GUIを開くよ
		player.openGui(
			GUISampleCore.INSTANCE,	// GUIのインスタンス
			GUISampleCore.GUI_ID,	// GUI_ID
			world,					// 開く世界ｗ
			blockpos.getX(),		// ブロックの位置 X
			blockpos.getY(),		// ブロックの位置 Y
			blockpos.getZ()			// ブロックの位置 Z
		);
		return true;
	}
}
