package io.github.haykam821.chainsuspension;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SuspensionHelper {
	private static final String MOD_ID = "chainsuspension";

	private static final Identifier UNSUSPENDABLE_BLOCKS_ID = new Identifier(MOD_ID, "unsuspendable_blocks");
	private static final Tag<Block> UNSUSPENDABLE_BLOCKS = TagFactory.BLOCK.create(UNSUSPENDABLE_BLOCKS_ID);

	public static boolean isSuspended(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.isIn(UNSUSPENDABLE_BLOCKS)) return false;
	
		BlockState upState = world.getBlockState(pos.up());
		return upState.getBlock() instanceof ChainBlock && upState.get(ChainBlock.AXIS) == Direction.Axis.Y;
	}
}