package com.iamforyydev.plugin.handler;

import com.iamforyydev.api.ItemBuilder;
import com.iamforyydev.api.ItemShop;
import com.iamforyydev.plugin.FoliumShop;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryHandler {

    private final FoliumShop plugin = FoliumShop.getInstance();
    private final List<ItemShop> itemShopList = new ArrayList<>();
    public InventoryHandler(
    ) {
        load();
    }

    private void load(
    ){
        FileConfiguration configuration = plugin.getConfig();
        configuration
                .getConfigurationSection("shop")
                .getKeys(false)
                .forEach(string -> {

                    ConfigurationSection configurationSection = configuration.getConfigurationSection(string);
                    if (configurationSection == null) {
                        return;
                    }

                    ItemShop itemShop = new ItemShop(
                            new ItemBuilder()
                                    .setName(configurationSection.getString("name"))
                                    .setLore(configurationSection.getStringList("lore"))
                                    .setMaterial(configurationSection.getString("material"))
                                    .build(),
                            configurationSection.getInt("price")
                    );

                    getItemShopList().add(itemShop);
                });
    }

    public void save(
    ){
        FileConfiguration configuration = plugin.getConfig();
        for(int index = 0; index < getItemShopList().size() ; index++){
            ItemShop itemShop = getItemShopList().get(index);
            ConfigurationSection configurationSection = configuration.createSection("shop."+index);
            configurationSection.set("name", itemShop.itemStack().getItemMeta().getDisplayName());
            configurationSection.set("material", itemShop.itemStack().getType().name());
            configurationSection.set("lore", itemShop.itemStack().getItemMeta().getLore());
            configurationSection.set("price", itemShop.price());
        }

        plugin.reloadConfig();
        plugin.saveConfig();
    }

    public ItemShop getItemShopByName(
            String name
    ) {
        for(ItemShop itemShop : getItemShopList()){
            if (itemShop.itemStack().getItemMeta().getDisplayName().equals(name)) {
                return itemShop;
            }
        }
        return null;
    }

    public boolean isItemShop(
            ItemStack itemStack
    ) {
        for(ItemShop itemShop : getItemShopList()){
            if (itemShop.itemStack() == itemStack) {
                return true;
            }
        }
        return false;
    }

    public List<ItemShop> getItemShopList() {
        return itemShopList;
    }
}
