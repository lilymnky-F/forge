package forge.adventure.archipelago;

import io.github.archipelagomw.Client;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;
// import org.apTest.APPersistentState;

/*import net.deadlydiamond98.archipelago.APMod;
import net.deadlydiamond98.archipelago.archipelago.items.type.AbstractAPItem;
import net.deadlydiamond98.archipelago.archipelago.locations.APLocations;
import net.deadlydiamond98.archipelago.networking.s2c.SendArchipelagoInfoS2CPacket;
import net.deadlydiamond98.archipelago.networking.s2c.SendUncheckedItemsS2CPacket;
import net.deadlydiamond98.archipelago.util.APAdvancementHelper;
import net.deadlydiamond98.archipelago.util.APServerUtil;
import net.deadlydiamond98.koalalib.init.KoalaLibSounds;*/


public class APConnectEvents {

    @ArchipelagoEventListener
    public void onConnectionEvent(ConnectionResultEvent event) {
        if (event.getResult() == ConnectionResult.Success) {
            // APPersistentState state = APPersistentState.get();
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
            /*
            // Unlocks Optional Abilities that aren't randomized
            slot.possible_randomized_abilities.forEach(ability -> {
                if (!slot.randomized_abilities.contains(ability)) {
                    state.triggerCheck(ability.toLowerCase());
                }
            });
            */

            Archipelago.run(archipelago -> {
                // Enable Deathlink
                if (slot.deathlink != 0) {
                    archipelago.setDeathLinkEnabled(true);
                }
/*                // Enable Traplink
                if (slot.traplink != 0) {
                    archipelago.addTag("TrapLink");
                }
               // Unlock Advancements that are already received
                archipelago.getLocationManager().getCheckedLocations().forEach(aLong -> {
                    if (APLocations.ADVANCEMENT_LOCATIONS.containsValue(aLong)) {
                        state.putAdvancementId(aLong);
                    }
                });*/
            });
        }
    }
}
