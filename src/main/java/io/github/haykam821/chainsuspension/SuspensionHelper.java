package io.github.haykam821.chainsuspension;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SuspensionHelper {
	public static boolean isSuspended(World world, BlockPos pos) {
		BlockState upState = world.getBlockState(pos.up());
		return upState.getBlock() instanceof ChainBlock && upState.get(ChainBlock.AXIS) == Direction.Axis.Y;
	}
}