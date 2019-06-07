package net.bingyan.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:33
 * Email    xinliugm@gmail.com
 */

public class JSON {
    private static Gson GSON = new GsonBuilder().setLenient().create();

    public static Gson getGson(){
        return GSON;
    }

    public static String stringfy(Object o) {
        return GSON.toJson(o);
    }

    public static  <T> T parse(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

    public static  <T> T parse(String json, TypeToken<T> typeToken) {
        return GSON.fromJson(json, typeToken.getType());
    }

    public static <T> T parse(File file, Class<T> type) {
        try {
            return GSON.fromJson(new JsonReader(new BufferedReader(new FileReader(file))),type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  <T> T parse(File file, TypeToken<T> typeToken) {
        try {
            return GSON.fromJson(new JsonReader(new BufferedReader(new FileReader(file))),typeToken.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
