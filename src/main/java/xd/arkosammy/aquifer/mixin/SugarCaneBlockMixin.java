package xd.arkosammy.aquifer.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SugarCaneBlock.class)
public class SugarCaneBlockMixin {

    @ModifyReturnValue(method = "canPlaceAt", at = @At(value = "TAIL"))
    private boolean checkForWaterUnderneathBlock(boolean original, @Local WorldView world, @Local BlockPos pos){
        if(world.isClient()){
           return original;
        }
        BlockState groundBlock = world.getBlockState(pos.down());
        if(!groundBlock.isIn(BlockTags.DIRT) && !groundBlock.isIn(BlockTags.SAND)) {
            return original;
        }
        BlockPos underneathPos = pos.down().down();
        BlockState underneathBlock = world.getBlockState(underneathPos);
        FluidState underneathFluid = world.getFluidState(underneathPos);
        return original || underneathFluid.isIn(FluidTags.WATER) || underneathBlock.isOf(Blocks.FROSTED_ICE);
    }

}
