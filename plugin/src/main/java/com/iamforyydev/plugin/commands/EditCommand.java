package com.iamforyydev.plugin.commands;

import com.iamforyydev.plugin.FoliumShop;
import com.iamforyydev.plugin.inventories.EditInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class EditCommand
        implements CommandExecutor {

    private final FoliumShop plugin = FoliumShop.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            return false;
        }

        Player player = (Player) sender;
        EditInventory editInventory = plugin.getEditInventory();
        editInventory.openInventory(player);
        return true;
    }
}
