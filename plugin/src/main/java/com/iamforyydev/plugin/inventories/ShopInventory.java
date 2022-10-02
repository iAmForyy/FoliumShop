package com.iamforyydev.plugin.inventories;

import com.iamforyydev.api.inventories.InventoryBuilder;
import com.iamforyydev.plugin.FoliumShop;
import org.bukkit.entity.Player;

public class ShopInventory
        extends InventoryBuilder {

    private final FoliumShop plugin = FoliumShop.getInstance();
    public ShopInventory(
    ) {
        super("Shop Gui", 6);
    }

    @Override
    public void loadItems() {
        plugin.getInventoryHandler()
                .getItemShopList()
                .forEach(itemShop ->
                        getInventory().addItem(itemShop.itemStack())
                );
    }

    @Override
    public void openInventory(Player player) {
        player.openInventory(getInventory());
    }
}
