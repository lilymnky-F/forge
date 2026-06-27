package forge.adventure.archipelago;

import forge.StaticData;
import forge.adventure.data.ConfigData;
import forge.adventure.util.AdventureEventController;
import forge.adventure.util.Config;
import forge.adventure.util.Current;
import forge.adventure.player.PlayerStatistic;
import forge.card.CardEdition;
import forge.item.PaperCard;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ReceiveItemEvent;

import java.util.*;

import static forge.adventure.archipelago.APData.CHILD_SETS;
import static forge.adventure.archipelago.APPersistentState.allowedBiomes;
import static forge.adventure.archipelago.APPersistentState.allowedFullBiomes;
import static forge.adventure.archipelago.Archipelago.check_for_goal;
import static forge.adventure.archipelago.Archipelago.getSlotData;
import static forge.adventure.data.RewardData.initializeAllCards;
import static forge.adventure.data.RewardData.getAllCards;


public class APReceiveItemEvents {

    @ArchipelagoEventListener
    public void receiveItem(ReceiveItemEvent event) {
        System.out.println(event.getItemName());
        System.out.println(event.getItemID());
        System.out.println(event.getLocationName());
        System.out.println(event.getIndex());

        // Get stats for index purposes
        PlayerStatistic stats = Current.player().getStatistic();
        String[] s = event.getItemName().split(" ");

        // First do non-consumables
        if (event.getItemName().contains("Access")) {
            // Find the name of the set to include, should be first string in the item
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
            return;
        }
        if (event.getItemName().contains("Biome")) {
            String biome = APData.BASIC_TO_BIOME.get(s[1].toLowerCase());
            // If they've received the biome before, allow them to enter POIs
            if (allowedBiomes.contains(biome)){
                allowedFullBiomes.add(biome);
                return;
            }
            allowedBiomes.add(biome);

            // Add rune if they don't have it
            String rune = "Starter " + biome + " Rune";
            if (!Current.player().hasItem(rune)){
                Current.player().addItem(rune);
            }
            return;
        }
        if (event.getItemName().contains("Mox Shard")) {
            check_for_goal();
        }
        // Then consumables, make sure the player doesn't get these twice
        if (event.getIndex() <= stats.getLastRecievedIndex()){
            return;
        }
        stats.setLastRecievedIndex((int) event.getIndex());

        if (event.getItemName().contains("Booster")) {
            CardEdition edition = StaticData.instance().getCardEdition(s[0]);
            if (edition == null) {
                System.out.println("Cannot find edition: " + s[0]);
                return;
            }
            if (!edition.hasBoosterTemplate()) {
                System.out.println(edition.getCode() + " doesn't have a booster template.");
                return;
            }

            Current.player().addBooster(AdventureEventController.instance().generateBooster(edition.getCode()));
            System.out.println("Added " + edition.getCode() + " booster");
            return;
        }
        if (event.getItemName().contains("Shards")) {
            int amount;
            try {
                amount = Integer.parseInt(s[0]);
            } catch (Exception e) {
                System.out.println("Could not add Shards");
                return;
            }
            Current.player().addShards(amount);
            System.out.println("Added " + s[0] + " Shards");
            return;
        }
        if (event.getItemName().contains("Gold")) {
            int amount;
            try {
                amount = Integer.parseInt(s[0]);
            } catch (Exception e) {
                System.out.println("Could not add Gold");
                return;
            }
            Current.player().giveGold(amount);
            System.out.println("Added " + s[0] + " Gold");
            return;
        }
        if (event.getItemName().contains("Random Card")) {
            List<PaperCard> validCards = new ArrayList<>();
            getAllCards().forEach(validCards::add);
            PaperCard card = validCards.get(Current.world().getRandom().nextInt(validCards.size()));
            Current.player().addCard(card);
            System.out.println("Added card: " + card.getName());
            return;
        }
        if (event.getItemName().contains("Custom Card")) {
            // Gives the player a card from their included cards.
            ArrayList<Object> included_card = new ArrayList<>();
            try {
                included_card = getSlotData().included_cards.get(stats.getIncludedCardIndex());
                stats.setIncludedCardIndex(stats.getIncludedCardIndex() + 1);
            }
            catch (IndexOutOfBoundsException e) {
                // If there's an error (recieving more cards than definied) replace it with "One with Nothing"
                included_card.add("SOK");
                included_card.add(84);
                stats.setIncludedCardIndex(0);
            }
            CardEdition edition = StaticData.instance().getCardEdition(included_card.get(0).toString());
            if (edition == null) {
                // Any error turns the card into "One with Nothing"
                edition = StaticData.instance().getCardEdition("SOK");
                included_card.set(1, 84);
            }
            CardEdition.EditionEntry cis = edition.getCardFromCollectorNumber(included_card.get(1).toString());
            if (cis == null) {
                edition = StaticData.instance().getCardEdition("SOK");
                cis = edition.getCardFromCollectorNumber("84");
            }
            PaperCard card = StaticData.instance().fetchCard(cis.name(), edition.getCode(), cis.collectorNumber());
            if (card == null) {
                //Found in the set, not supported, do not replace card.
                System.out.println("Failed to fetch (" + cis.name() + ", " + edition.getCode() + ", " + cis.collectorNumber() + ") - Not currently supported.");
                return;
            }
            Current.player().addCard(card);
            System.out.println("Added card: " + card.getName());
            return;
        }
    }
}
