package com.iamforyydev.plugin;

import com.iamforyydev.plugin.commands.EditCommand;
import com.iamforyydev.plugin.commands.ShopCommand;
import com.iamforyydev.plugin.handler.InventoryHandler;
import com.iamforyydev.plugin.inventories.EditInventory;
import com.iamforyydev.plugin.inventories.ShopInventory;
import com.iamforyydev.plugin.listener.InventoryClickListener;
import com.iamforyydev.plugin.listener.PlayerQuitListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class FoliumShop
        extends JavaPlugin {

    private static FoliumShop instance;
    private InventoryHandler inventoryHandler;
    private ShopInventory shopInventory;
    private EditInventory editInventory;

    @Override
    public void onEnable() {
        instance = this;

        this.inventoryHandler = new InventoryHandler();
        this.shopInventory = new ShopInventory();
        this.editInventory = new EditInventory();
        commandHandler();
        eventHandler(
                new PlayerQuitListener(),
                new InventoryClickListener()
        );
    }

    @Override
    public void onDisable(){
        getInventoryHandler().save();
    }

    private void eventHandler(
            Listener... listeners
    ) {
        Arrays.stream(listeners).forEach(listener ->
                getServer().getPluginManager().registerEvents(listener, this));
    }

    private void commandHandler(
    ) {
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("editshop").setExecutor(new EditCommand());

    }

    public ShopInventory getShopInventory() {
        return shopInventory;
    }

    public EditInventory getEditInventory() {
        return editInventory;
    }

    public static FoliumShop getInstance() {
        return instance;
    }

    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }
}
