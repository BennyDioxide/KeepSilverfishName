package io.github.bennydioxide.keepsilverfishname.mixin;

import io.github.bennydioxide.keepsilverfishname.KeepSilverfishName;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.block.InfestedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InfestedBlock.class)
public class InfestedBlockMixin {


    @Inject(method = "spawnInfestation", at = @At("HEAD"), cancellable = true)
    private void saveName(ServerLevel level, BlockPos pos, CallbackInfo ci) {
        Silverfish silverfish = EntityType.SILVERFISH.create(level);
        silverfish.moveTo((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        Component name = KeepSilverfishName.silverfishNameMap.remove(pos);
        silverfish.setCustomName(name);
        KeepSilverfishName.LOGGER.debug(String.format("A silverfish named %s has been spawned!", name));
        level.addFreshEntity(silverfish);
        silverfish.spawnAnim();
        ci.cancel();
    }
}
