/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.block.mana;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import vazkii.botania.client.core.handler.MiscellaneousModels;

public class ConjurationCatalystBlock extends AlchemyCatalystBlock {

	public ConjurationCatalystBlock(Properties builder) {
		super(builder);
	}

	@Override
	public ResourceLocation getIcon(Level world, BlockPos pos) {
		return MiscellaneousModels.INSTANCE.conjurationCatalystOverlay.texture();
	}
}
