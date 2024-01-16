package xd.arkosammy.aquifer;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aquifer implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("aquifer");

	@Override
	public void  onInitialize() {

		//LOGGER.info("");

		// TODO: Find a better solution
		/*
		// Force the player to swing their hand and play a placing sound effect if they can place a sugarcane block
		UseBlockCallback.EVENT.register(((player, world, hand, hitResult) -> {
			if (!(player instanceof ServerPlayerEntity serverPlayerEntity) || !(world instanceof ServerWorld serverWorld)) {
				return ActionResult.PASS;
			}
			Block heldBlock = Block.getBlockFromItem(serverPlayerEntity.getStackInHand(hand).getItem());
			if(heldBlock instanceof SugarCaneBlock sugarCaneBlock){
				BlockState hitBlockState = serverWorld.getBlockState(hitResult.getBlockPos());
				BlockPos placePos = hitResult.getBlockPos().offset(hitResult.getSide());
				if(sugarCaneBlock.canPlaceAt(hitBlockState, serverWorld, placePos)){
					serverPlayerEntity.swingHand(hand, true);
					serverWorld.playSound(null, placePos, sugarCaneBlock.getDefaultState().getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, sugarCaneBlock.getDefaultState().getSoundGroup().getVolume(), sugarCaneBlock.getDefaultState().getSoundGroup().getPitch());
				}
			}
			return ActionResult.PASS;
		}));

		 */

	}
}