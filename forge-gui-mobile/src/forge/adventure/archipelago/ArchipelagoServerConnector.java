package forge.adventure.archipelago;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ArchipelagoServerConnector {
    private static final APPersistentState state = APPersistentState.state;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static String lastConnectedServer = "archipelago.gg:";
    public static String lastConnectedPlayer = "";

    public static String archipelagoServer = "";
    public static String archipelagoPlayer = "";
    public static String archipelagoPassword = "";


    public static void connectToServer() {
        String server = state.getCurrentServer();
        if (server.isEmpty()) {
            if (!archipelagoServer.isEmpty()) {
                connectToServer(archipelagoServer, archipelagoPlayer, archipelagoPassword);
                archipelagoServer = "";
                archipelagoPlayer = "";
                archipelagoPassword = "";
            }
        } else {
            connectToServer(server, state.getCurrentPlayer(), state.getCurrentPassword());
        }
    }

    public static int connectToServer(String server, String player, String password) {
        AtomicInteger i = new AtomicInteger();
        Archipelago.run(archipelago -> {
            archipelago.setName(player);
            archipelago.setPassword(password);
            try {
                archipelago.connect(server);
                // updateLastConnectedServer(server, player);
                state.updateServerInformation(server, player, password);
                i.set(1);
            } catch (URISyntaxException e) {
                // inform user connection failed
            }
        });
        return i.get();
    }

    public static void updateLastConnectedServer(String newServer, String player) {
        lastConnectedServer = newServer;
        lastConnectedPlayer = player;
        writeLastConnectedServer();
    }

    // Read and Write last Connected Server to file

    public static void readLastConnectedServer() {
        try {
            FileReader reader = new FileReader(getPath().toFile());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            lastConnectedServer = json.get("lastConnectedServer").getAsString();
            lastConnectedPlayer = json.get("lastPlayer").getAsString();
            reader.close();
        } catch (Exception ignored) {
            try {
                if (!Files.exists(getPath())) {
                    Files.createFile(getPath());
                }
                writeLastConnectedServer();
            } catch (Exception ignored2) {}
        }
    }

    public static void writeLastConnectedServer() {
        try {
            FileWriter writer = new FileWriter(getPath().toFile());
            GSON.toJson(Map.of("lastConnectedServer", lastConnectedServer, "lastPlayer", lastConnectedPlayer), writer);
            writer.close();
        } catch (Exception ignored) {}
    }

    private static Path getPath() {
        return null;
        // return FabricLoader.getInstance().getConfigDir().resolve("forge_ap_reconnection.json");
    }
}
