package service;

import com.google.gson.Gson;

/**
 * Created by alvin on 4/18/16.
 */
public enum GsonInstance {
    INSTANCE;
    private final static Gson gson = new Gson();
    public Gson getGson() {
        return gson;
    }
}
