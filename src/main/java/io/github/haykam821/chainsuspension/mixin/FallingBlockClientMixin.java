package io.github.haykam821.chainsuspension.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.chainsuspension.SuspensionHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

@Mixin(FallingBlock.class)
public class FallingBlockClientMixin {
	@Inject(method = "randomDisplayTick", at = @At("HEAD"), cancellable = true)
	private void preventParticlesWhenSuspended(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
		if (SuspensionHelper.isSuspended(world, pos)) {
			ci.cancel();
		}
	}
}