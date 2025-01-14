package io.bluebeaker.keybindunconflict.mixin;

import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(KeyBinding.class)
public interface AccessorKeyBinding {
    @Accessor
    int getPressTime();
    @Accessor
    void setPressTime(int time);
}
