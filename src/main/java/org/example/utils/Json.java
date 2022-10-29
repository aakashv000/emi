package org.example.utils;

import com.google.gson.Gson;

public class Json {
    /**
     * Converts json String to given pojo class's object
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseJsonToClass (String jsonStr, Class<T> clazz) {
        T object = null;
        try {
            Gson gson = new Gson();
            object = gson.fromJson(jsonStr, clazz);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }
}
