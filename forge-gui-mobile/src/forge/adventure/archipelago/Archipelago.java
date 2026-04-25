package forge.adventure.archipelago;

import io.github.archipelagomw.Client;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.flags.ItemsHandling;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class Archipelago extends Client {
    public static Archipelago archipelago;
    public static ForgeSlotData slotData;
    public static APPersistentState state = new APPersistentState();
    // public static String lastDeathlinkPlayer = "Unknown";

    public Archipelago() {
        super();
        this.setGame("Forge Adventure");
        this.setItemsHandlingFlags(ItemsHandling.SEND_ITEMS + ItemsHandling.SEND_OWN_ITEMS + ItemsHandling.SEND_STARTING_INVENTORY);

        // this.getEventManager().registerListener(new APPrintJsonEvents());
        this.getEventManager().registerListener(new APReceiveItemEvents());
        this.getEventManager().registerListener(new APConnectEvents());
        // this.getEventManager().registerListener(new APDeathlinkEvents());
        // this.getEventManager().registerListener(new APBouncedEvents());
    }

    @Override
    public void onError(Exception ex) {
        // output to console
    }

    @Override
    public void onClose(String reason, int attemptingReconnect) {
        // output to console error
        if (attemptingReconnect > 0) {
            // output to console that we're reconnecting
        }
        slotData = null;
    }

    // Helper Methods //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Runs a Command on the Archipelago Client if it's present, otherwise runs a separate method
     * @param success the method to run if the Client is present
     * @param fail the method to run if the Client isn't present
     * @return returns 1 if the client is present, otherwise returns 0. Is used for Minecraft Text commands
     */
    public static int runCommand(Consumer<Archipelago> success, Runnable fail) {
        if (!run(success)) {
            fail.run();
            return 0;
        }
        return 1;
    }

    /**
     * Runs an action on the Archipelago Client if it's present
     * @param consumer the method to run
     * @return returns true if the Client is present
     */
    public static boolean run(Consumer<Archipelago> consumer) {
        if (archipelago != null) {
            consumer.accept(archipelago);
            return true;
        }
        return false;
    }
    // Slot Data Methods ///////////////////////////////////////////////////////////////////////////////////////////////

    public static ForgeSlotData initSlotData(ConnectionResultEvent event) {
        slotData = event.getSlotData(ForgeSlotData.class);
        return slotData;
    }

    public static ForgeSlotData getSlotData() {
        return slotData;
    }

    public static int getFromSlot(Function<ForgeSlotData, Integer> function) {
        ForgeSlotData slot = Archipelago.getSlotData();
        if (slot != null) {
            return function.apply(slot);
        }
        return -1;
    }


    public static class ForgeSlotData {
        public String world_version;

        public int goal_condition;

        public int keys_required;

        public int pips_required;

        public int deathlink;
//        public int traplink;

        public Set<String> starting_cards;
        public Set<String> disabled_biomes;

//        public long seed;
//        public int randomize_mob_spawns;
    }
}
