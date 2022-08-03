package io.github.bennydioxide.keepsilverfishname.mixin;

import io.github.bennydioxide.keepsilverfishname.KeepSilverfishName;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.entity.monster.Silverfish$SilverfishMergeWithStoneGoal")
public class SilverfishMergeWithStoneGoalMixin extends RandomStrollGoal {


    public SilverfishMergeWithStoneGoalMixin(PathfinderMob pathfinderMob, double d) {
        super(pathfinderMob, d);
    }

    @Redirect(method = "start",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"))
    private boolean start(LevelAccessor instance, BlockPos blockPos, BlockState blockState, int i) {
        Component name = this.mob.getName();
        KeepSilverfishName.LOGGER.debug(String.format("A silverfish named %s has infest a block!", name));
        KeepSilverfishName.silverfishNameMap.put(blockPos, name);
        return instance.setBlock(blockPos, blockState, i);
    }
}
