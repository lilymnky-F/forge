package forge.adventure.archipelago;

import forge.adventure.data.BiomeData;
import forge.adventure.world.WorldSave;
import io.github.archipelagomw.Client;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class APConnectEvents {

    @ArchipelagoEventListener
    public void onConnectionEvent(ConnectionResultEvent event) {
        if (event.getResult() == ConnectionResult.Success) {
            Archipelago.ForgeSlotData slot = Archipelago.initSlotData(event);
            System.out.println("Connected");
            String version = slot.world_version;

            if (version != null) {
                 /*if (!version.contains(APMod.VALID_WORLD_VERSION)) {
                    // Inform the user their world is invalid, and tell them the correct one
                    Archipelago.run(Client::close);
                    return;
                }*/
            } else {
                // Inform the user the apworld they connected to is invalid? IDK how this would happen but good to have ig
                Archipelago.run(Client::close);
                return;
            }

            List<BiomeData> biomeData = WorldSave.getCurrentSave().getWorld().getData().GetBiomes();
            for (Map.Entry<String, ArrayList<String>> entry: slot.enemy_locations.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();

                for (BiomeData biome: biomeData){
                    if (Objects.equals(biome.name, key)){
                        biome.enemies = value.toArray(new String[0]);
                    }
                }
            }

            Archipelago.run(archipelago -> {
                // Enable Deathlink
                if (slot.deathlink != 0) {
                    archipelago.setDeathLinkEnabled(true);
                }

            });
        }
    }
}
