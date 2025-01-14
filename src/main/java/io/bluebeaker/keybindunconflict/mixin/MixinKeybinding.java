package io.bluebeaker.keybindunconflict.mixin;

import io.bluebeaker.keybindunconflict.KeyBindingsGetter;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public abstract class MixinKeybinding {

    @Inject(method = "onTick(I)V",at=@At("HEAD"),cancellable = true)
    private static void onTick(int keyCode, CallbackInfo ci){
        for (KeyBinding keybinding : KeyBindingsGetter.getBindings(keyCode, KeyModifier.getActiveModifier())){
            if (keybinding != null)
            {
                ((AccessorKeyBinding)keybinding).setPressTime(((AccessorKeyBinding)keybinding).getPressTime()+1);
            }
        }
        ci.cancel();
    }
}
