package io.bluebeaker.keybindunconflict;

import io.bluebeaker.keybindunconflict.mixin.AccessorKeyBinding;
import io.bluebeaker.keybindunconflict.mixin.AccessorKeyBindingMap;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyModifier;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KeyBindingsGetter {

    public static List<KeyBinding> getBindings(int keyCode, KeyModifier keyModifier)
    {
        List<KeyBinding> keyBindings = new ArrayList<>();
        Collection<KeyBinding> bindings = AccessorKeyBindingMap.getMap().get(keyModifier).lookup(keyCode);
        if (bindings != null)
        {
            for (KeyBinding binding : bindings)
            {
                if (binding.isActiveAndMatches(keyCode))
                {
                    keyBindings.add(binding);
                }
            }
        }
        return keyBindings;
    }
}
