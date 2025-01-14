package io.bluebeaker.keybindunconflict;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = KeybindUnconflict.MODID,type = Type.INSTANCE,category = "general")
public class KeybindUnconflictConfig {
    @Comment("Example")
    @LangKey("config.keybindunconflict.example.name")
    public static boolean example = true;
}