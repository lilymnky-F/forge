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
        CHILD_SETS.put("sos", new HashMap<>());
        CHILD_SETS.get("sos").put("alchemy", "ysos");
        CHILD_SETS.get("sos").put("masterpiece", "soa");
        CHILD_SETS.get("sos").put("commander", "soc");
        CHILD_SETS.put("tmt", new HashMap<>());
        CHILD_SETS.get("tmt").put("masterpiece", "pza");
        CHILD_SETS.get("tmt").put("eternal", "tmc");
        CHILD_SETS.put("ecl", new HashMap<>());
        CHILD_SETS.get("ecl").put("alchemy", "yecl");
        CHILD_SETS.get("ecl").put("commander", "ecc");
        CHILD_SETS.put("tla", new HashMap<>());
        CHILD_SETS.get("tla").put("eternal", "tle");
        CHILD_SETS.put("spm", new HashMap<>());
        CHILD_SETS.get("spm").put("eternal", "spe");
        CHILD_SETS.put("eoe", new HashMap<>());
        CHILD_SETS.get("eoe").put("alchemy", "yeoe");
        CHILD_SETS.get("eoe").put("masterpiece", "eos");
        CHILD_SETS.get("eoe").put("commander", "eoc");
        CHILD_SETS.put("fin", new HashMap<>());
        CHILD_SETS.get("fin").put("masterpiece", "fca");
        CHILD_SETS.get("fin").put("commander", "fic");
        CHILD_SETS.put("tdm", new HashMap<>());
        CHILD_SETS.get("tdm").put("alchemy", "ytdm");
        CHILD_SETS.get("tdm").put("commander", "tdc");
        CHILD_SETS.put("dft", new HashMap<>());
        CHILD_SETS.get("dft").put("alchemy", "ydft");
        CHILD_SETS.get("dft").put("commander", "drc");
        CHILD_SETS.put("fdn", new HashMap<>());
        CHILD_SETS.get("fdn").put("commander", "fdc");
        CHILD_SETS.get("fdn").put("eternal", "j25");
        CHILD_SETS.put("dsk", new HashMap<>());
        CHILD_SETS.get("dsk").put("alchemy", "ydsk");
        CHILD_SETS.get("dsk").put("commander", "dsc");
        CHILD_SETS.put("blb", new HashMap<>());
        CHILD_SETS.get("blb").put("alchemy", "yblb");
        CHILD_SETS.get("blb").put("commander", "blc");
        CHILD_SETS.put("mh3", new HashMap<>());
        CHILD_SETS.get("mh3").put("eternal", "h2r");
        CHILD_SETS.get("mh3").put("commander", "m3c");
        CHILD_SETS.put("otj", new HashMap<>());
        CHILD_SETS.get("otj").put("alchemy", "yotj");
        CHILD_SETS.get("otj").put("expansion", "big");
        CHILD_SETS.get("otj").put("commander", "otc");
        CHILD_SETS.get("otj").put("masterpiece", "otp");
        CHILD_SETS.put("mkm", new HashMap<>());
        CHILD_SETS.get("mkm").put("alchemy", "ymkm");
        CHILD_SETS.get("mkm").put("eternal", "clu");
        CHILD_SETS.get("mkm").put("commander", "mkc");
        CHILD_SETS.put("lci", new HashMap<>());
        CHILD_SETS.get("lci").put("alchemy", "ylci");
        CHILD_SETS.get("lci").put("eternal", "rex");
        CHILD_SETS.get("lci").put("commander", "lcc");
        CHILD_SETS.put("woe", new HashMap<>());
        CHILD_SETS.get("woe").put("alchemy", "ywoe");
        CHILD_SETS.get("woe").put("masterpiece", "wot");
        CHILD_SETS.get("woe").put("commander", "woc");
        CHILD_SETS.put("ltr", new HashMap<>());
        CHILD_SETS.get("ltr").put("commander", "ltc");
        CHILD_SETS.put("mom", new HashMap<>());
        CHILD_SETS.get("mom").put("commander", "moc");
        CHILD_SETS.get("mom").put("masterpiece", "mul");
        CHILD_SETS.put("one", new HashMap<>());
        CHILD_SETS.get("one").put("alchemy", "yone");
        CHILD_SETS.get("one").put("commander", "onc");
        CHILD_SETS.put("bro", new HashMap<>());
        CHILD_SETS.get("bro").put("alchemy", "ybro");
        CHILD_SETS.get("bro").put("commander", "brc");
        CHILD_SETS.get("bro").put("masterpiece", "brr");
        CHILD_SETS.get("bro").put("eternal", "bot");
        CHILD_SETS.put("dmu", new HashMap<>());
        CHILD_SETS.get("dmu").put("alchemy", "ydmu");
        CHILD_SETS.get("dmu").put("commander", "dmc");
        CHILD_SETS.put("snc", new HashMap<>());
        CHILD_SETS.get("snc").put("alchemy", "ysnc");
        CHILD_SETS.get("snc").put("commander", "ncc");
        CHILD_SETS.put("neo", new HashMap<>());
        CHILD_SETS.get("neo").put("alchemy", "yneo");
        CHILD_SETS.get("neo").put("commander", "nec");
        CHILD_SETS.put("vow", new HashMap<>());
        CHILD_SETS.get("vow").put("commander", "voc");
        CHILD_SETS.put("mid", new HashMap<>());
        CHILD_SETS.get("mid").put("commander", "mic");
        CHILD_SETS.put("afr", new HashMap<>());
        CHILD_SETS.get("afr").put("commander", "afc");
        CHILD_SETS.put("mh2", new HashMap<>());
        CHILD_SETS.get("mh2").put("eternal", "h1r");
        CHILD_SETS.put("stx", new HashMap<>());
        CHILD_SETS.get("stx").put("masterpiece", "sta");
        CHILD_SETS.put("khm", new HashMap<>());
        CHILD_SETS.get("khm").put("commander", "khc");
        CHILD_SETS.put("znr", new HashMap<>());
        CHILD_SETS.get("znr").put("commander", "znc");
        CHILD_SETS.get("znr").put("masterpiece", "zne");
        CHILD_SETS.put("akh", new HashMap<>());
        CHILD_SETS.get("akh").put("masterpiece", "mp2");
        CHILD_SETS.put("kld", new HashMap<>());
        CHILD_SETS.get("kld").put("masterpiece", "mps");
        CHILD_SETS.put("bfz", new HashMap<>());
        CHILD_SETS.get("bfz").put("masterpiece", "exp");
        CHILD_SETS.put("tsp", new HashMap<>());
        CHILD_SETS.get("tsp").put("expansion", "tsb");
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