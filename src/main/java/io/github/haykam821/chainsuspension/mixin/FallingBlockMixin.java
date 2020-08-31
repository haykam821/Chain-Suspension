package io.github.haykam821.chainsuspension.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.chainsuspension.SuspensionHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Mixin(FallingBlock.class)
public class FallingBlockMixin {
	@Inject(method = "scheduledTick", at = @At("HEAD"), cancellable = true)
	private void preventFallingWhenSuspended(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		if (SuspensionHelper.isSuspended(world, pos)) {
			ci.cancel();
		}
	}
}