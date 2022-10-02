package com.iamforyydev.api.user;

import java.util.UUID;

public class User {

    private final UUID uuid;
    private int coins;

    public User(
            UUID uuid
    ) {
        this.uuid = uuid;
        this.coins = 0;
    }

    public void removeCoins(
            int coins
    ) {
        this.coins -= coins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
