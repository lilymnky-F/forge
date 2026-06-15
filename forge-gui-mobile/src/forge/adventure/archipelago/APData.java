package forge.adventure.archipelago;

import java.util.ArrayList;
import java.util.HashMap;

public class APData {
    static HashMap<String, String> BASIC_TO_BIOME = new HashMap<>();

    static {
        BASIC_TO_BIOME.put("plains", "white");
        BASIC_TO_BIOME.put("island", "blue");
        BASIC_TO_BIOME.put("swamp", "black");
        BASIC_TO_BIOME.put("mountain", "red");
        BASIC_TO_BIOME.put("forest", "green");
        BASIC_TO_BIOME.put("wastes", "waste");
    }

    static String CORRECT_WORLD_VERSION = "0.0.1";

    static HashMap<String, HashMap<String, String>> CHILD_SETS = new HashMap<>();

    // WOW this is bad but I'm tired and I couldn't figure out how to natively read a json so I'll fix this later okay bye
    static {
        CHILD_SETS.put("SOS", new HashMap<>());
        CHILD_SETS.get("SOS").put("Alchemy", "YSOS");
        CHILD_SETS.get("SOS").put("Masterpiece", "SOA");
        CHILD_SETS.get("SOS").put("Commander", "SOC");
        CHILD_SETS.put("TMT", new HashMap<>());
        CHILD_SETS.get("TMT").put("Masterpiece", "PZA");
        CHILD_SETS.get("TMT").put("Eternal", "TMC");
        CHILD_SETS.put("ECL", new HashMap<>());
        CHILD_SETS.get("ECL").put("Alchemy", "YECL");
        CHILD_SETS.get("ECL").put("Commander", "ECC");
        CHILD_SETS.put("TLA", new HashMap<>());
        CHILD_SETS.get("TLA").put("Eternal", "TLE");
        CHILD_SETS.put("SPM", new HashMap<>());
        CHILD_SETS.get("SPM").put("Eternal", "SPE");
        CHILD_SETS.put("EOE", new HashMap<>());
        CHILD_SETS.get("EOE").put("Alchemy", "YEOE");
        CHILD_SETS.get("EOE").put("Masterpiece", "EOS");
        CHILD_SETS.get("EOE").put("Commander", "EOC");
        CHILD_SETS.put("FIN", new HashMap<>());
        CHILD_SETS.get("FIN").put("Masterpiece", "FCA");
        CHILD_SETS.get("FIN").put("Commander", "FIC");
        CHILD_SETS.put("TDM", new HashMap<>());
        CHILD_SETS.get("TDM").put("Alchemy", "YTDM");
        CHILD_SETS.get("TDM").put("Commander", "TDC");
        CHILD_SETS.put("DFT", new HashMap<>());
        CHILD_SETS.get("DFT").put("Alchemy", "YDFT");
        CHILD_SETS.get("DFT").put("Commander", "DRC");
        CHILD_SETS.put("FDN", new HashMap<>());
        CHILD_SETS.get("FDN").put("Commander", "FDC");
        CHILD_SETS.get("FDN").put("Eternal", "J25");
        CHILD_SETS.put("DSK", new HashMap<>());
        CHILD_SETS.get("DSK").put("Alchemy", "YDSK");
        CHILD_SETS.get("DSK").put("Commander", "DSC");
        CHILD_SETS.put("BLB", new HashMap<>());
        CHILD_SETS.get("BLB").put("Alchemy", "YBLB");
        CHILD_SETS.get("BLB").put("Commander", "BLC");
        CHILD_SETS.put("MH3", new HashMap<>());
        CHILD_SETS.get("MH3").put("Eternal", "H2R");
        CHILD_SETS.get("MH3").put("Commander", "M3C");
        CHILD_SETS.put("OTJ", new HashMap<>());
        CHILD_SETS.get("OTJ").put("Alchemy", "YOTJ");
        CHILD_SETS.get("OTJ").put("Expansion", "BIG");
        CHILD_SETS.get("OTJ").put("Commander", "OTC");
        CHILD_SETS.get("OTJ").put("Masterpiece", "OTP");
        CHILD_SETS.put("MKM", new HashMap<>());
        CHILD_SETS.get("MKM").put("Alchemy", "YMKM");
        CHILD_SETS.get("MKM").put("Eternal", "CLU");
        CHILD_SETS.get("MKM").put("Commander", "MKC");
        CHILD_SETS.put("LCI", new HashMap<>());
        CHILD_SETS.get("LCI").put("Alchemy", "YLCI");
        CHILD_SETS.get("LCI").put("Eternal", "REX");
        CHILD_SETS.get("LCI").put("Commander", "LCC");
        CHILD_SETS.put("WOE", new HashMap<>());
        CHILD_SETS.get("WOE").put("Alchemy", "YWOE");
        CHILD_SETS.get("WOE").put("Masterpiece", "WOT");
        CHILD_SETS.get("WOE").put("Commander", "WOC");
        CHILD_SETS.put("LTR", new HashMap<>());
        CHILD_SETS.get("LTR").put("Commander", "LTC");
        CHILD_SETS.put("MOM", new HashMap<>());
        CHILD_SETS.get("MOM").put("Commander", "MOC");
        CHILD_SETS.get("MOM").put("Expansion", "MAT");
        CHILD_SETS.get("MOM").put("Masterpiece", "MUL");
        CHILD_SETS.put("ONE", new HashMap<>());
        CHILD_SETS.get("ONE").put("Alchemy", "YONE");
        CHILD_SETS.get("ONE").put("Commander", "ONC");
        CHILD_SETS.put("BRO", new HashMap<>());
        CHILD_SETS.get("BRO").put("Alchemy", "YBRO");
        CHILD_SETS.get("BRO").put("Commander", "BRC");
        CHILD_SETS.get("BRO").put("Masterpiece", "BRR");
        CHILD_SETS.get("BRO").put("Eternal", "BOT");
        CHILD_SETS.put("DMU", new HashMap<>());
        CHILD_SETS.get("DMU").put("Alchemy", "YDMU");
        CHILD_SETS.get("DMU").put("Commander", "DMC");
        CHILD_SETS.put("SNC", new HashMap<>());
        CHILD_SETS.get("SNC").put("Alchemy", "YSNC");
        CHILD_SETS.get("SNC").put("Commander", "NCC");
        CHILD_SETS.put("NEO", new HashMap<>());
        CHILD_SETS.get("NEO").put("Alchemy", "YNEO");
        CHILD_SETS.get("NEO").put("Commander", "NEC");
        CHILD_SETS.put("VOW", new HashMap<>());
        CHILD_SETS.get("VOW").put("Commander", "VOC");
        CHILD_SETS.put("MID", new HashMap<>());
        CHILD_SETS.get("MID").put("Commander", "MIC");
        CHILD_SETS.put("AFR", new HashMap<>());
        CHILD_SETS.get("AFR").put("Commander", "AFC");
        CHILD_SETS.put("MH2", new HashMap<>());
        CHILD_SETS.get("MH2").put("Eternal", "H1R");
        CHILD_SETS.put("STX", new HashMap<>());
        CHILD_SETS.get("STX").put("Masterpiece", "STA");
        CHILD_SETS.put("KHM", new HashMap<>());
        CHILD_SETS.get("KHM").put("Commander", "KHC");
        CHILD_SETS.put("ZNR", new HashMap<>());
        CHILD_SETS.get("ZNR").put("Commander", "ZNC");
        CHILD_SETS.get("ZNR").put("Masterpiece", "ZNE");
        CHILD_SETS.put("AKH", new HashMap<>());
        CHILD_SETS.get("AKH").put("Masterpiece", "MP2");
        CHILD_SETS.put("KLD", new HashMap<>());
        CHILD_SETS.get("KLD").put("Masterpiece", "MPS");
        CHILD_SETS.put("BFZ", new HashMap<>());
        CHILD_SETS.get("BFZ").put("Masterpiece", "EXP");
        CHILD_SETS.put("TSP", new HashMap<>());
        CHILD_SETS.get("TSP").put("Expansion", "TSB");
    }

    static ArrayList<String> BOSS_LIST = new ArrayList<>();

    static {
        BOSS_LIST.add("Akroma");
        BOSS_LIST.add("Akroma");
        BOSS_LIST.add("Akroma");
        BOSS_LIST.add("Akroma");
        BOSS_LIST.add("Akroma");
    }
}