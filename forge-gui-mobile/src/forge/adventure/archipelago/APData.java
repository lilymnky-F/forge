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
        CHILD_SETS.get("SOS").put("alchemy", "YSOS");
        CHILD_SETS.get("SOS").put("masterpiece", "SOA");
        CHILD_SETS.get("SOS").put("commander", "SOC");
        CHILD_SETS.put("TMT", new HashMap<>());
        CHILD_SETS.get("TMT").put("masterpiece", "PZA");
        CHILD_SETS.get("TMT").put("eternal", "TMC");
        CHILD_SETS.put("ECL", new HashMap<>());
        CHILD_SETS.get("ECL").put("alchemy", "YECL");
        CHILD_SETS.get("ECL").put("commander", "ECC");
        CHILD_SETS.put("TLA", new HashMap<>());
        CHILD_SETS.get("TLA").put("eternal", "TLE");
        CHILD_SETS.put("SPM", new HashMap<>());
        CHILD_SETS.get("SPM").put("eternal", "SPE");
        CHILD_SETS.put("EOE", new HashMap<>());
        CHILD_SETS.get("EOE").put("alchemy", "YEOE");
        CHILD_SETS.get("EOE").put("masterpiece", "EOS");
        CHILD_SETS.get("EOE").put("commander", "EOC");
        CHILD_SETS.put("FIN", new HashMap<>());
        CHILD_SETS.get("FIN").put("masterpiece", "FCA");
        CHILD_SETS.get("FIN").put("commander", "FIC");
        CHILD_SETS.put("TDM", new HashMap<>());
        CHILD_SETS.get("TDM").put("alchemy", "YTDM");
        CHILD_SETS.get("TDM").put("commander", "TDC");
        CHILD_SETS.put("DFT", new HashMap<>());
        CHILD_SETS.get("DFT").put("alchemy", "YDFT");
        CHILD_SETS.get("DFT").put("commander", "DRC");
        CHILD_SETS.put("FDN", new HashMap<>());
        CHILD_SETS.get("FDN").put("commander", "FDC");
        CHILD_SETS.get("FDN").put("eternal", "J25");
        CHILD_SETS.put("DSK", new HashMap<>());
        CHILD_SETS.get("DSK").put("alchemy", "YDSK");
        CHILD_SETS.get("DSK").put("commander", "DSC");
        CHILD_SETS.put("BLB", new HashMap<>());
        CHILD_SETS.get("BLB").put("alchemy", "YBLB");
        CHILD_SETS.get("BLB").put("commander", "BLC");
        CHILD_SETS.put("MH3", new HashMap<>());
        CHILD_SETS.get("MH3").put("eternal", "H2R");
        CHILD_SETS.get("MH3").put("commander", "M3C");
        CHILD_SETS.put("OTJ", new HashMap<>());
        CHILD_SETS.get("OTJ").put("alchemy", "YOTJ");
        CHILD_SETS.get("OTJ").put("expansion", "BIG");
        CHILD_SETS.get("OTJ").put("commander", "OTC");
        CHILD_SETS.get("OTJ").put("masterpiece", "OTP");
        CHILD_SETS.put("MKM", new HashMap<>());
        CHILD_SETS.get("MKM").put("alchemy", "YMKM");
        CHILD_SETS.get("MKM").put("eternal", "CLU");
        CHILD_SETS.get("MKM").put("commander", "MKC");
        CHILD_SETS.put("LCI", new HashMap<>());
        CHILD_SETS.get("LCI").put("alchemy", "YLCI");
        CHILD_SETS.get("LCI").put("eternal", "REX");
        CHILD_SETS.get("LCI").put("commander", "LCC");
        CHILD_SETS.put("WOE", new HashMap<>());
        CHILD_SETS.get("WOE").put("alchemy", "YWOE");
        CHILD_SETS.get("WOE").put("masterpiece", "WOT");
        CHILD_SETS.get("WOE").put("commander", "WOC");
        CHILD_SETS.put("LTR", new HashMap<>());
        CHILD_SETS.get("LTR").put("commander", "LTC");
        CHILD_SETS.put("MOM", new HashMap<>());
        CHILD_SETS.get("MOM").put("commander", "MOC");
        CHILD_SETS.get("MOM").put("masterpiece", "MUL");
        CHILD_SETS.put("ONE", new HashMap<>());
        CHILD_SETS.get("ONE").put("alchemy", "YONE");
        CHILD_SETS.get("ONE").put("commander", "ONC");
        CHILD_SETS.put("BRO", new HashMap<>());
        CHILD_SETS.get("BRO").put("alchemy", "YBRO");
        CHILD_SETS.get("BRO").put("commander", "BRC");
        CHILD_SETS.get("BRO").put("masterpiece", "BRR");
        CHILD_SETS.get("BRO").put("eternal", "BOT");
        CHILD_SETS.put("DMU", new HashMap<>());
        CHILD_SETS.get("DMU").put("alchemy", "YDMU");
        CHILD_SETS.get("DMU").put("commander", "DMC");
        CHILD_SETS.put("SNC", new HashMap<>());
        CHILD_SETS.get("SNC").put("alchemy", "YSNC");
        CHILD_SETS.get("SNC").put("commander", "NCC");
        CHILD_SETS.put("NEO", new HashMap<>());
        CHILD_SETS.get("NEO").put("alchemy", "YNEO");
        CHILD_SETS.get("NEO").put("commander", "NEC");
        CHILD_SETS.put("VOW", new HashMap<>());
        CHILD_SETS.get("VOW").put("commander", "VOC");
        CHILD_SETS.put("MID", new HashMap<>());
        CHILD_SETS.get("MID").put("commander", "MIC");
        CHILD_SETS.put("AFR", new HashMap<>());
        CHILD_SETS.get("AFR").put("commander", "AFC");
        CHILD_SETS.put("MH2", new HashMap<>());
        CHILD_SETS.get("MH2").put("eternal", "H1R");
        CHILD_SETS.put("STX", new HashMap<>());
        CHILD_SETS.get("STX").put("masterpiece", "STA");
        CHILD_SETS.put("KHM", new HashMap<>());
        CHILD_SETS.get("KHM").put("commander", "KHC");
        CHILD_SETS.put("ZNR", new HashMap<>());
        CHILD_SETS.get("ZNR").put("commander", "ZNC");
        CHILD_SETS.get("ZNR").put("masterpiece", "ZNE");
        CHILD_SETS.put("AKH", new HashMap<>());
        CHILD_SETS.get("AKH").put("masterpiece", "MP2");
        CHILD_SETS.put("KLD", new HashMap<>());
        CHILD_SETS.get("KLD").put("masterpiece", "MPS");
        CHILD_SETS.put("BFZ", new HashMap<>());
        CHILD_SETS.get("BFZ").put("masterpiece", "EXP");
        CHILD_SETS.put("TSP", new HashMap<>());
        CHILD_SETS.get("TSP").put("expansion", "TSB");
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