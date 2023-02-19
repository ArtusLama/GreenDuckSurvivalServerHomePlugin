package de.artus.survivalserverartus;

import de.artus.survivalserverartus.commands.HomeCommand;
import de.artus.survivalserverartus.commands.ListHomes;
import de.artus.survivalserverartus.commands.RemoveHomeCommand;
import de.artus.survivalserverartus.commands.SetHomeCommand;
import de.artus.survivalserverartus.utils.HomeConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {


    Logger LOGGER = Bukkit.getLogger();
    public static String prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "SurvivalServer" + ChatColor.GRAY + "] ";

    @Override
    public void onEnable() {

        LOGGER.info(prefix + "loading plugin...");

        LOGGER.info(prefix + "loading config...");
        HomeConfig.save();

        LOGGER.info(prefix + "loading commands...");

        getCommand("sethome").setExecutor(new SetHomeCommand());
        getCommand("removehome").setExecutor(new RemoveHomeCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("listhomes").setExecutor(new ListHomes());


        LOGGER.info(prefix + "loading listeners...");



        LOGGER.info(prefix + "Plugin successfully loaded!");

    }

    @Override
    public void onDisable() {

    }
}
