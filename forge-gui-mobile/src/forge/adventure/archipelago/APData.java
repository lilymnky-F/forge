package forge.adventure.archipelago;

import java.util.HashMap;

public class APData {
    static HashMap<String, String> basic_to_biome = new HashMap<>();

    static {
        basic_to_biome.put("plains", "white");
        basic_to_biome.put("island", "blue");
        basic_to_biome.put("swamp", "black");
        basic_to_biome.put("mountain", "red");
        basic_to_biome.put("forest", "green");
        basic_to_biome.put("wastes", "waste");
    }

    static String correct_world_version = "0.0.1";
}