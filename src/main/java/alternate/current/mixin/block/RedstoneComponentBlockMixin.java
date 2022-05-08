package alternate.current.mixin.block;

import org.spongepowered.asm.mixin.Mixin;

import alternate.current.interfaces.mixin.IBlock;

import net.minecraft.class_3772;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneComponentBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

@Mixin(RedstoneComponentBlock.class)
public class RedstoneComponentBlockMixin implements IBlock {

	@Override
	public boolean isSignalSourceTo(World world, BlockPos pos, BlockState state, Direction dir) {
		return state.method_16934(class_3772.field_18724) == dir;
	}

	@Override
	public boolean isDirectSignalSourceTo(World world, BlockPos pos, BlockState state, Direction dir) {
		return state.method_16934(class_3772.field_18724) == dir;
	}
}
