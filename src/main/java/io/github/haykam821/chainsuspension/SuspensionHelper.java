package io.github.haykam821.chainsuspension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class SuspensionHelper {
	private static final String MOD_ID = "chainsuspension";

	private static final Identifier UNSUSPENDABLE_BLOCKS_ID = new Identifier(MOD_ID, "unsuspendable_blocks");
	private static final TagKey<Block> UNSUSPENDABLE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, UNSUSPENDABLE_BLOCKS_ID);

	private static final Identifier SUSPENSION_BLOCKS_ID = new Identifier(MOD_ID, "suspension_blocks");
	private static final TagKey<Block> SUSPENSION_BLOCKS = TagKey.of(Registry.BLOCK_KEY, SUSPENSION_BLOCKS_ID);

	public static boolean isSuspended(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.isIn(UNSUSPENDABLE_BLOCKS)) return false;
	
		BlockState upState = world.getBlockState(pos.up());
		if (upState.getBlock() instanceof ChainBlock) {
			return upState.get(ChainBlock.AXIS) == Direction.Axis.Y;
		}

		return upState.isIn(SUSPENSION_BLOCKS);
	}
}