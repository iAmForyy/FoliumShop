package com.iamforyydev.api.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserHandler {

    private static final Map<UUID, User> userHashMap = new HashMap<>();

    public static User getUserByUuid(
            UUID uuid
    ) {
        if (getUserHashMap().containsKey(uuid)) {
            return getUserHashMap().get(uuid);
        }

        User user = new User(uuid);
        getUserHashMap().put(uuid, user);
        return getUserHashMap().get(uuid);
    }

    public static Map<UUID, User> getUserHashMap() {
        return userHashMap;
    }

    public static void removeUser(
            UUID uuid
    ) {
        getUserHashMap().remove(uuid);
    }

}
