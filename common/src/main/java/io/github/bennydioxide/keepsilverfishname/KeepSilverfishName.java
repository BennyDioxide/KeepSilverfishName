package io.github.bennydioxide.keepsilverfishname;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class KeepSilverfishName {
    public static final String MOD_ID = "keepsilverfishname";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static Map<BlockPos, Component> silverfishNameMap = new HashMap<>();

    public static void init() {

    }
}