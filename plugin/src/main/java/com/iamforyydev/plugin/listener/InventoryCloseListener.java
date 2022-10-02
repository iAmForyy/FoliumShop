package com.iamforyydev.plugin.listener;

import com.iamforyydev.api.ItemShop;
import com.iamforyydev.plugin.FoliumShop;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryCloseListener
        implements Listener {

    private final FoliumShop plugin = FoliumShop.getInstance();

    @EventHandler
    public void onInventoryClose(
            InventoryCloseEvent closeEvent
    ) {

        Inventory inventory = closeEvent.getInventory();
        if (inventory == plugin.getEditInventory().getInventory()) {
            for(ItemStack itemStack : inventory.getContents()){
                plugin.getInventoryHandler().getItemShopList().add(
                        new ItemShop(itemStack, 0)
                );
            }

            plugin.reloadConfig();
            plugin.saveConfig();
        }

    }


}
