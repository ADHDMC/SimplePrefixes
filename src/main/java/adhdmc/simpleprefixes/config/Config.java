package adhdmc.simpleprefixes.config;

import adhdmc.simpleprefixes.SimplePrefixes;
import adhdmc.simpleprefixes.util.Message;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public enum SAVING_TYPE { PDC, FILE }
    private static SAVING_TYPE savingType = SAVING_TYPE.PDC;
    private static String defaultPrefix = "<white>[<gray>Player</gray>]</white> ";

    public static void loadConfig() {
        SimplePrefixes.getPlugin().reloadConfig();
        FileConfiguration config = SimplePrefixes.getPlugin().getConfig();
        try {
            savingType = SAVING_TYPE.valueOf(config.getString("saving-type", "pdc").toUpperCase());
        } catch (IllegalArgumentException e) {
            SimplePrefixes.getPlugin().getLogger().warning(Message.LOGGER_INVALID_CONFIG_SAVING_TYPE.getMessage());
        }
        defaultPrefix = config.getString("default-prefix", defaultPrefix);
    }

    public static SAVING_TYPE getSavingType() { return savingType; }
    public static String getDefaultPrefix() { return defaultPrefix; }

}
