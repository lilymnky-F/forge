package forge.adventure.archipelago;

import io.github.archipelagomw.Client;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.flags.ItemsHandling;


import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Archipelago.archipelago = new Archipelago();
        ArchipelagoServerConnector.connectToServer("archipelago.gg:39441", "Player1", "");
    }
}