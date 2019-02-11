/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Jan 29, 2015, 7:17:41 PM (GMT)]
 */
package vazkii.botania.common.block.decor.biomestone;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.api.state.BotaniaStateProps;
import vazkii.botania.api.state.enums.BiomeBrickVariant;
import vazkii.botania.client.core.handler.ModelHandler;
import vazkii.botania.common.lib.LibBlockNames;

import javax.annotation.Nonnull;

public class BlockBiomeStoneB extends BlockBiomeStone {

	public BlockBiomeStoneB() {
		super(LibBlockNames.BIOME_STONE_B);
		setDefaultState(blockState.getBaseState().with(BotaniaStateProps.BIOMEBRICK_VARIANT, BiomeBrickVariant.FOREST));
	}

	@Nonnull
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BotaniaStateProps.BIOMEBRICK_VARIANT);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.get(BotaniaStateProps.BIOMEBRICK_VARIANT).ordinal();
	}

	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta >= BiomeBrickVariant.values().length) {
			meta = 0;
		}
		return getDefaultState().with(BotaniaStateProps.BIOMEBRICK_VARIANT, BiomeBrickVariant.values()[meta]);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerBlockToState(this, BiomeBrickVariant.values().length);
	}
}
