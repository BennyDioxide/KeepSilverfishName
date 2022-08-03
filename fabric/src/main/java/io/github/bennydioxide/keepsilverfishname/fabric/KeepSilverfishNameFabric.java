package io.github.bennydioxide.keepsilverfishname.fabric;

import io.github.bennydioxide.keepsilverfishname.fabriclike.KeepSilverfishNameFabricLike;
import net.fabricmc.api.ModInitializer;

public class KeepSilverfishNameFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KeepSilverfishNameFabricLike.init();
    }
}