package de.artus.survivalserverartus.utils;

import de.artus.survivalserverartus.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class HomeConfig {


    public static File ConfigFile = new File("plugins/survivalServer", "homes.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() {
        try {
            Config.save(ConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setHome(Player player, Location loc, String homeName) {
        ConfigurationSection section = getHomes(player);
        if (section == null || section.getKeys(false).size() < 3){
            Config.set("homes." + player.getUniqueId() + "." + homeName, loc);
            save();
            player.sendMessage(Main.prefix + "Das Home " + ChatColor.GREEN + "'" + homeName + "'" + ChatColor.GRAY + " wurde erfolgreich erstellt!");
        }
        else {
            player.sendMessage(Main.prefix + "Du hast schon die maximale Anzahl an Homes gesetzt! Benutze " + ChatColor.RED + "'/delhome [HomeName]'" + ChatColor.GRAY + ", um eins zu löschen!");
        }
    }

    public static ConfigurationSection getHomes(Player player) {
        return Config.getConfigurationSection("homes." + player.getUniqueId());
    }



    public static Location getHome(Player player, String homeName) {
        return Config.getLocation("homes." + player.getUniqueId() + "." + homeName);
    }

    public static void removeHome(Player player, String homeName) {
        if (getHome(player, homeName) != null){
            getHomes(player).set(homeName, null);
            save();
            player.sendMessage(Main.prefix + "Das Home " + ChatColor.GREEN + "'" + homeName + "'" + ChatColor.GRAY + " wurde erfolgreich entfernt");

        } else {
            player.sendMessage(Main.prefix + "Das Home " + ChatColor.RED + "'" + homeName + "'" + ChatColor.GRAY + " konnte nicht entfernt werden, da dieses nicht exestiert!");
        }

    }









}
