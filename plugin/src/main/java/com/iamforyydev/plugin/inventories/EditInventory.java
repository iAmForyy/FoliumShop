package com.iamforyydev.plugin.inventories;

import com.iamforyydev.api.inventories.InventoryBuilder;
import org.bukkit.entity.Player;

public class EditInventory
        extends InventoryBuilder {

    public EditInventory() {
        super("Admin Gui", 6);
    }

    @Override
    public void loadItems() {
    }

    @Override
    public void openInventory(Player player) {
        player.openInventory(getInventory());
    }
}
