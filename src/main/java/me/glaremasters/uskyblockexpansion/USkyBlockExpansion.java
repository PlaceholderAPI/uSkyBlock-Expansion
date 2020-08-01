package me.glaremasters.uskyblockexpansion;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import us.talabrek.ultimateskyblock.api.uSkyBlockAPI;

import java.text.DecimalFormat;

public final class USkyBlockExpansion extends PlaceholderExpansion {

    private uSkyBlockAPI api;
    private DecimalFormat level = new DecimalFormat("#.##");

    private final String VERSION = getClass().getPackage().getImplementationVersion();

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getRequiredPlugin()) != null;
    }

    @Override
    public boolean register() {
        api = (uSkyBlockAPI) Bukkit.getPluginManager().getPlugin(getRequiredPlugin());
        if (api != null) {
            return super.register();
        }
        return false;
    }

    @Override
    public String getAuthor() {
        return "Gianluca";
    }

    @Override
    public String getRequiredPlugin() {
        return "uSkyBlock";
    }

    @Override
    public String getIdentifier() {
        return "uskyblock";
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String onRequest(OfflinePlayer player, String arg) {
        Player p = (Player) player;
        if (player == null) return "";

        switch(arg) {
            case "island_level":
                return String.valueOf(level.format(api.getIslandLevel(p)));
            case "island_rank":
                return String.valueOf(api.getIslandRank(p).getRank());
        }
        return "";
    }

}

