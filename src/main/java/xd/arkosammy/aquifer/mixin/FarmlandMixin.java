package xd.arkosammy.aquifer.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FarmlandBlock.class)
public class FarmlandMixin {

    @ModifyReturnValue(method = "isWaterNearby", at = @At(value = "TAIL"))
    private static boolean checkForWaterUnderneath(boolean original, @Local WorldView world, @Local BlockPos pos){
        boolean isWaterNearby = false;
        for(BlockPos blockPos : BlockPos.iterate(pos.add(-2, -1, -2), pos.add(2, -1, 2))){
            if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                isWaterNearby = true;
            }
        }
        return original || isWaterNearby;
    }

}
