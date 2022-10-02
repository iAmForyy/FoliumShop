package com.iamforyydev.api;

import com.iamforyydev.api.utils.Utility;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private String name;
    private List<String> lore;
    private Material material;
    public ItemBuilder(
    ) {
        this.material = Material.STONE;
    }

    public ItemBuilder setName(
            String name
    ) {
        if (name == null || name.isEmpty()) {
            return this;
        }

        this.name = Utility.toFormat(name);
        return this;
    }

    public ItemBuilder setLore(
            List<String> lore
    ) {
        if (lore == null || lore.isEmpty()) {
            return this;
        }

        lore.replaceAll(Utility::toFormat);
        this.lore = lore;
        return this;
    }

    public ItemBuilder setMaterial(
            String materialName
    ) {
        Material materialTarget = Material.getMaterial(materialName);
        if (materialTarget == null) {
            return this;
        }

        this.material = materialTarget;
        return this;
    }

    public ItemStack build(
    ) {

        ItemStack itemStack = new ItemStack(this.material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
