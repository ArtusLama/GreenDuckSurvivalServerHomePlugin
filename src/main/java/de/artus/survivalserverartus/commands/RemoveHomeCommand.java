package de.artus.survivalserverartus.commands;

import de.artus.survivalserverartus.Main;
import de.artus.survivalserverartus.utils.HomeConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveHomeCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 1) {
                HomeConfig.removeHome(player, args[0]);
            } else {
                player.sendMessage(Main.prefix + "Bitte benutze " + ChatColor.RED + "'/delhome [HomeName]'");
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
