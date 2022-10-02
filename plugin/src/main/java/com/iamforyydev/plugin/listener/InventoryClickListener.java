package com.iamforyydev.plugin.listener;

import com.iamforyydev.api.ItemShop;
import com.iamforyydev.api.user.User;
import com.iamforyydev.api.user.UserHandler;
import com.iamforyydev.plugin.FoliumShop;
import com.iamforyydev.plugin.inventories.ShopInventory;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener
        implements Listener {

    private final FoliumShop plugin = FoliumShop.getInstance();

    @EventHandler
    public void onInventoryClick(
            InventoryClickEvent clickEvent
    ) {

        Inventory inventory = clickEvent.getInventory();
        ShopInventory shopInventory = plugin.getShopInventory();
        if (inventory == shopInventory.getInventory()) {
            ItemStack itemStack = clickEvent.getCurrentItem();
            if (plugin.getInventoryHandler().isItemShop(itemStack)) {

                String itemName = itemStack.getItemMeta().getDisplayName();
                ItemShop itemShop = plugin.getInventoryHandler().getItemShopByName(itemName);
                if (itemShop == null) {
                    return;
                }

                Player player = (Player) clickEvent.getWhoClicked();
                if (itemShop.price() != 0) {
                    User user = UserHandler.getUserByUuid(player.getUniqueId());
                    user.removeCoins(itemShop.price());
                }

                player.getInventory().addItem(itemStack);
                player.sendMessage(ChatColor.GREEN + "You have purchased successfully!");
            }
        }
    }
}
