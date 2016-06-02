package service;

import com.google.gson.Gson;

/**
 * 单例的Gson对象, Gson对象能够将任意的Object转化为JSON的形式。只需调用它的toJson(Object)方法。
 * Created by alvin on 4/18/16.
 */
public enum GsonInstance {
    INSTANCE;
    private final static Gson gson = new Gson();
    public Gson getGson() {
        return gson;
    }
}
