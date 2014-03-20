/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Mar 19, 2014, 10:16:53 PM (GMT)]
 */
package vazkii.botania.common.block.subtile.functional;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import vazkii.botania.api.subtile.SubTileFunctional;

public class SubTileAgricarnation extends SubTileFunctional {

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(supertile.worldObj.getTotalWorldTime() % 3 == 0) {
			int range = 5;
			int x = supertile.xCoord + supertile.worldObj.rand.nextInt(range * 2 + 1) - range;
			int z = supertile.zCoord + supertile.worldObj.rand.nextInt(range * 2 + 1) - range;

			for(int i = 4; i > -2; i--) {
				int y = supertile.yCoord + i;

				if(supertile.worldObj.isAirBlock(x, y, z))
					continue;

				if(isPlant(x, y, z) && mana > 5) {
					int id = supertile.worldObj.getBlockId(x, y, z);
					mana -= 5;
					supertile.worldObj.scheduleBlockUpdate(x, y, z, id, 1);
				}
			}
		}
	}

	boolean isPlant(int x, int y, int z) {
		int id = supertile.worldObj.getBlockId(x, y, z);
		if(id == Block.grass.blockID || id == Block.leaves.blockID || id == Block.tallGrass.blockID)
			return false;

		Material mat = supertile.worldObj.getBlockMaterial(x, y, z);
		return mat != null && (mat == Material.plants || mat == Material.cactus || mat == Material.grass || mat == Material.leaves || mat == Material.vine || mat == Material.wood || mat == Material.pumpkin);
	}

	@Override
	public int getColor() {
		return 0x8EF828;
	}

	@Override
	public int getMaxMana() {
		return 200;
	}

}
