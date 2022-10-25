package org.example.utils;

import com.google.gson.Gson;

public class Json {
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
