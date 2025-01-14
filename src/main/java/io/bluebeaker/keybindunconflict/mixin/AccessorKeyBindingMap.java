package io.bluebeaker.keybindunconflict.mixin;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.IntHashMap;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.client.settings.KeyModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Collection;
import java.util.EnumMap;

@Mixin(value = KeyBindingMap.class,remap = false)
public interface AccessorKeyBindingMap {
    @Accessor
    static EnumMap<KeyModifier, IntHashMap<Collection<KeyBinding>>> getMap(){
        throw new AssertionError();
    }
}
