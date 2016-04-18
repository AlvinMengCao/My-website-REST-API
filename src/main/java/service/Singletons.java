package service;

import com.google.gson.Gson;

/**
 * Created by alvin on 4/18/16.
 */
public enum Singletons {
    ;
    private static final Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
