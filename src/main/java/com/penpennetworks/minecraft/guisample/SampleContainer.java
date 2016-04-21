package com.penpennetworks.minecraft.guisample;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class SampleContainer extends Container {

	//座標でGUIを開くか判定するためのもの。
	int xCoord, yCoord, zCoord;

	public SampleContainer( int x, int y, int z ){
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
	}

	public SampleContainer( InventoryPlayer player ){

		// 持ち物スロットを作成(Inventoryの中身)
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				// スロットの追加
				addSlotToContainer(
					new Slot(
						player,			// どのInventory?
						x  + y * 9 + 9,	// スロット番号
						8  + x * 18,	// X座標(描画位置)
						84 + y * 18		// Y座標(描画位置)
					)
				);
			}
		}

		// ホットスロットを作成(1～9までのやつ)
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(
				new Slot(
					player,		// どのInventory?
					x,			// スロット番号
					8 + x * 18,	// X座標(描画位置)
					142			// Y座標(描画位置)
				)
			);
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {

		// もし、ブロックとの位置関係でGUI制御したいなら、こちらを使う
		//return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64D;

		// 必ず開く
		return true;
	}

}
