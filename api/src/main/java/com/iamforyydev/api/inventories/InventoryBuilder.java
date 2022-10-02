package com.iamforyydev.api.inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class InventoryBuilder
        implements InventoryHolder, InventoryInterface {

    protected final String title;
    protected final int rows;
    protected final Inventory inventory;

    public InventoryBuilder(
            String title,
            int rows
    ) {
        this.title = title;
        this.rows = rows;
        this.inventory = Bukkit.createInventory(
                null,
                rows * 9,
                title
        );

        loadItems();
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public String getTitle() {
        return title;
    }

    public int getRows() {
        return rows;
    }
}
