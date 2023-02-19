package de.artus.survivalserverartus.commands;

import de.artus.survivalserverartus.Main;
import de.artus.survivalserverartus.utils.HomeConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListHomes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player player) {
            player.sendMessage(Main.prefix + "Du hast folgende Homes:");
            Object[] homeNames = HomeConfig.getHomes(player).getKeys(false).toArray();


            Object home1;

            try {home1 = homeNames[0];} catch (Exception e) {home1 = "-";}


            player.sendMessage(Main.prefix + ChatColor.GREEN + "1. " + ChatColor.GRAY + " -> " + ChatColor.GREEN + home1);

        }


        return false;
    }
}
