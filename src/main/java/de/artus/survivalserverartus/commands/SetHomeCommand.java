package de.artus.survivalserverartus.commands;

import de.artus.survivalserverartus.Main;
import de.artus.survivalserverartus.utils.HomeConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 1) {
                if (HomeConfig.getHome(player, args[0]) == null) {
                    HomeConfig.setHome(player, player.getLocation(), args[0]);
                } else {
                    player.sendMessage(Main.prefix + "Das Home " + ChatColor.RED + "'" + args[0] + "'" + ChatColor.GRAY + " exestiert bereits! Entferne es zuerst mit " + ChatColor.RED + "'/delhome" + args[0] + "'");
                }

            } else {
                player.sendMessage(Main.prefix + "Bitte benutze " + ChatColor.RED + "'/sethome [HomeName]'");
            }
        }


        return true;
    }


}
