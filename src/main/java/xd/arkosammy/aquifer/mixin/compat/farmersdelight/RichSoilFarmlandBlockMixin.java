package xd.arkosammy.aquifer.mixin.compat.farmersdelight;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nhoryzon.mc.farmersdelight.block.RichSoilFarmlandBlock;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RichSoilFarmlandBlock.class)
public class RichSoilFarmlandBlockMixin {

    @ModifyReturnValue(method = "hasWater", at = @At(value = "RETURN"))
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
