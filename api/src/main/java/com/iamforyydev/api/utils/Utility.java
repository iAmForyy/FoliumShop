package com.iamforyydev.api.utils;

import org.bukkit.ChatColor;

public class Utility {

    public static String toFormat(
            String message
    ) {
        return message != null ?
                ChatColor.translateAlternateColorCodes('&', message) : "message null";
    }
}
