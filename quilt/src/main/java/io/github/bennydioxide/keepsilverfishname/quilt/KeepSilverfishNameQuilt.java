package io.github.bennydioxide.keepsilverfishname.quilt;

import io.github.bennydioxide.keepsilverfishname.fabriclike.KeepSilverfishNameFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class KeepSilverfishNameQuilt implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        KeepSilverfishNameFabricLike.init();
    }
}
