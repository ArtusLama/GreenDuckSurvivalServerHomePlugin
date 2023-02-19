package de.artus.survivalserverartus.commands;

import de.artus.survivalserverartus.Main;
import de.artus.survivalserverartus.utils.HomeConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 1) {
                Location homeLoc = HomeConfig.getHome(player, args[0]);
                if (homeLoc == null) {
                    player.sendMessage(Main.prefix + "Das Home " + ChatColor.RED + "'" + args[0] + "'" + ChatColor.GRAY + " exestiert nicht!");
                } else {

                    if (player.getLevel() >= 2) {
                        player.giveExpLevels(-2);
                        player.teleport(homeLoc);
                        player.sendMessage(Main.prefix + "Du wurdest erfolgreich zu deinem Home " + ChatColor.GREEN + "'" + args[0] + "'" + ChatColor.GRAY + " teleportiert!");
                        player.sendMessage(ChatColor.GRAY + "(" + ChatColor.GREEN + "-2 Level" + ChatColor.GRAY + ")");

                    } else {
                        player.sendMessage(Main.prefix + "Du hast " + ChatColor.RED + "nicht genug Level " + ChatColor.GRAY + "zum teleportieren!");
                    }
                }

            } else {
                player.sendMessage(Main.prefix + "Bitte benutze " + ChatColor.RED + "'/home [HomeName]'");
            }
        }


        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> completions = new ArrayList<>();

        if (args.length == 1){
            List<String> commands = new ArrayList<>(HomeConfig.getHomes((Player) sender).getKeys(false));
            StringUtil.copyPartialMatches(args[0], commands, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}
