package etcodehome.freeterraforged.client.gui.screen.presetconfig;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import net.minecraft.network.chat.Component;

final class PresetTranslations {
    private PresetTranslations() {
    }

    static Component text(String group, String id, String fallback) {
        return Component.translatableWithFallback(
            "freeterraforged.gui." + group + "." + id.toLowerCase(Locale.ROOT).replace(' ', '_'),
            fallback
        );
    }

    static String terrain(String name) {
        // Composite terrain names join registered terrain IDs with a hyphen.
        return Arrays.stream(name.split("-"))
            .map(part -> text("terrain", part, part).getString())
            .collect(Collectors.joining(" / "));
    }
}
