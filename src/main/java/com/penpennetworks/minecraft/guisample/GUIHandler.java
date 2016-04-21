package com.penpennetworks.minecraft.guisample;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if( id == GUISampleCore.GUI_ID) {
			return new SampleGuiContainer(player.inventory);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if( id == GUISampleCore.GUI_ID ){
            return new SampleContainer(player.inventory);
        }
        return null;
	}

}
