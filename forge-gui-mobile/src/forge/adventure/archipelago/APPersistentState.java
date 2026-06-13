package forge.adventure.archipelago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APPersistentState {
    public static APPersistentState state = new APPersistentState();

    public static List<String> allowedBiomes = new ArrayList<>();
    public static List<String> allowedFullBiomes = new ArrayList<>();
    public static Integer lastBiome = null;

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
}

