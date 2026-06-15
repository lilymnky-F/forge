package forge.adventure.archipelago;

import forge.StaticData;
import forge.adventure.data.ConfigData;
import forge.adventure.util.AdventureEventController;
import forge.adventure.util.Config;
import forge.adventure.util.Current;
import forge.card.CardEdition;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ReceiveItemEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static forge.adventure.archipelago.APData.CHILD_SETS;
import static forge.adventure.archipelago.APPersistentState.allowedBiomes;
import static forge.adventure.archipelago.APPersistentState.allowedFullBiomes;
import static forge.adventure.data.RewardData.initializeAllCards;


public class APReceiveItemEvents {

    @ArchipelagoEventListener
    public void receiveItem(ReceiveItemEvent event) {
        System.out.println(event.getItemName());
        System.out.println(event.getItemID());
        System.out.println(event.getLocationName());
        System.out.println(event.getIndex());
        if (event.getItemName().contains("Booster")) {
            String[] s = event.getItemName().split(" ");
            CardEdition edition = StaticData.instance().getCardEdition(s[0]);
            if (edition == null)
                System.out.println("Cannot find edition: " + s[0]);
            if (!edition.hasBoosterTemplate())
                System.out.println(edition.getCode() + " doesn't have a booster template.");

            int amount = 1;
            if (s.length >= 2) {
                try {
                    amount = Integer.parseInt(s[1]);
                } catch (NumberFormatException ignored) {
                }
            }

            for (int i = 0; i < amount; i++) {
                Current.player().addBooster(AdventureEventController.instance().generateBooster(edition.getCode()));
            }

            System.out.println("Added " + amount + " " + edition.getCode() + " booster(s)");
        }
        if (event.getItemName().contains("Access")) {
            // Find the name of the set to include, should be first string in the item
            String[] s = event.getItemName().split(" ");
            CardEdition edition = StaticData.instance().getCardEdition(s[0]);
            if (edition == null)
                System.out.println("Cannot find edition: " + s[0]);

            // Load the Config, to add it to the allowed sets
            ConfigData configData = Config.instance().getConfigData();
            Set<String> allowed = new HashSet<>();
            if (configData.allowedEditions != null) {
                allowed = new HashSet<>(Arrays.asList(configData.allowedEditions));
            }
            allowed.add(s[0]);

            // Check for Child Sets
            HashMap<String, String> poteintalChildSets = CHILD_SETS.get(s[0]);
            if (poteintalChildSets != null){
                for (String set_type: Archipelago.getSlotData().include_extras) {
                    String child_set = poteintalChildSets.get(set_type);
                    if (child_set != null) {
                        allowed.add(child_set);
                    }
                }
            }

            // Add all found sets to allowed editions
            configData.allowedEditions = allowed.toArray(new String[0]);
            initializeAllCards();
            System.out.println("Added set " + s[0] + " to allowed sets.");
        }
        if (event.getItemName().contains("Biome")) {
            String[] s = event.getItemName().split(" ");
            String biome = APData.BASIC_TO_BIOME.get(s[1].toLowerCase());
            if (allowedBiomes.contains(biome)){
                allowedFullBiomes.add(APData.BASIC_TO_BIOME.get(s[1].toLowerCase()));
            }
            allowedBiomes.add(APData.BASIC_TO_BIOME.get(s[1].toLowerCase()));
        }

    }
}
