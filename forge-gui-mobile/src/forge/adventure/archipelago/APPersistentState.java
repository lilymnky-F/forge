package forge.adventure.archipelago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Saves Data to the Minecraft World
 *  - Received Items
 *  - Checked Locations
 *  - Status of various abilities
 *  - The Current Archipelago Server
 */
public class APPersistentState {
    public static APPersistentState state = new APPersistentState();

    // Saves the Indexes of items to prevent them from being re-given in a world that they were already obtained in
    private final Map<Long, String> receivedItems = new HashMap<>();
    // Saves unlocked advancements, so they're granted to any additional players in the world
    private final List<Long> advancementIds = new ArrayList<>();
    // Saves found Itemsanity Checks
    private final List<Long> itemsanityIds = new ArrayList<>();

//    private final Set<Item> collectedItems = new HashSet<>();
    private boolean hasKilledEnderDragon;
    private boolean hasKilledWither;
    private int currentRubyCount;

    private String currentServer = "";
    private String currentPlayer = "";
    private String currentPassword = "";

    /**
     * Changes the Archipelago Server Info assigned to the world
     * @param server the server
     * @param player the player slot
     * @param password the password
     */
    public void updateServerInformation(String server, String player, String password) {
        this.currentServer = server;
        this.currentPlayer = player;
        this.currentPassword = password;
    }

    public String getCurrentServer() {
        return this.currentServer;
    }

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getCurrentPassword() {
        return this.currentPassword;
    }

    // Goal Management Stuff ///////////////////////////////////////////////////////////////////////////////////////////

    public boolean hasKilledEnderDragon() {
        return this.hasKilledEnderDragon;
    }

    public boolean hasKilledWither() {
        return this.hasKilledWither;
    }

    public int getCollectedRubies() {
        return this.currentRubyCount;
    }

    public void setHasKilledEnderDragon(boolean hasKilledEnderDragon) {
        this.hasKilledEnderDragon = hasKilledEnderDragon;
    }

    public void setHasKilledWither(boolean hasKilledWither) {
        this.hasKilledWither = hasKilledWither;
    }

    public void setCurrentRubyCount(int currentRubyCount) {
        this.currentRubyCount = currentRubyCount;
    }
}

