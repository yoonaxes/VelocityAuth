package net.yoonaxes.auth.api;

import com.google.gson.*;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This API was used to check if the player has a premium account.
 * @author yoonaxes
 */
public class ContentAPI {

    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

    @Getter
    private String data;

    public ContentAPI(String url) {
        Validate.notNull(url, "A url can't be null.");

        try {
            this.connect(new URL(url));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    public ContentAPI(URL url) {
        Validate.notNull(url, "A url can't be null.");

        this.connect(url);
    }

    private void connect(URL url) {
        try {
            URLConnection connection = url.openConnection();

            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setUseCaches(false);
            connection.connect();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            this.data = bufferedReader.readLine();

            bufferedReader.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public JsonObject toJson() {
        return JsonParser.parseString(this.getData()).getAsJsonObject();
    }
}