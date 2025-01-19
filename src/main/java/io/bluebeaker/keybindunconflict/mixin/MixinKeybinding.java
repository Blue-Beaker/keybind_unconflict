package io.bluebeaker.keybindunconflict.mixin;

import io.bluebeaker.keybindunconflict.KeyBindingsGetter;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public abstract class MixinKeybinding {

    @Inject(method = "onTick(I)V",at=@At("HEAD"),cancellable = true)
    private static void onTick(int keyCode, CallbackInfo ci){
        keybind_unconflict$tickKeyCode(keyCode);
        ci.cancel();
    }

    @Unique
    private static void keybind_unconflict$tickKeyCode(int keyCode) {
        boolean pressed = false;
        for (KeyBinding keybinding : KeyBindingsGetter.getBindings(keyCode, KeyModifier.getActiveModifier())){
            if (keybinding != null)
            {
                ((AccessorKeyBinding)keybinding).setPressTime(((AccessorKeyBinding)keybinding).getPressTime()+1);
                pressed = true;
            }
        }
        if(pressed) return;
        for (KeyBinding keybinding : KeyBindingsGetter.getBindings(keyCode, KeyModifier.NONE)){
            if (keybinding != null)
            {
                ((AccessorKeyBinding)keybinding).setPressTime(((AccessorKeyBinding)keybinding).getPressTime()+1);
            }
        }
    }
}
