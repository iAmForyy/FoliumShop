package com.iamforyydev.plugin.listener;

import com.iamforyydev.api.user.UserHandler;
import com.iamforyydev.plugin.FoliumShop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener
        implements Listener {

    private final FoliumShop plugin = FoliumShop.getInstance();

    @EventHandler
    public void onPlayerJoin(
            PlayerQuitEvent quitEvent
    ) {
        Player player = quitEvent.getPlayer();
        UserHandler.removeUser(player.getUniqueId());
    }


}
