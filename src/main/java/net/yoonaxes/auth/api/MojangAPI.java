package net.yoonaxes.auth.api;

import org.apache.commons.lang3.Validate;

public class MojangAPI {

    public final static String SERVER_URL = "https://api.mojang.com";

    public String getId(String username) {
        Validate.notNull(username, "A username can't be null.");

        ContentAPI content = new ContentAPI(SERVER_URL + "/users/profiles/minecraft/" + username);

        if(content.getData() == null)
            return null;

        return content.toJson().get("id").getAsString();
    }

    public boolean isPremiumAccount(String username) {
        Validate.notNull(username, "A username can't be null.");

        return new ContentAPI(SERVER_URL + "/users/profiles/minecraft/" + username).getData() != null;
    }
}
