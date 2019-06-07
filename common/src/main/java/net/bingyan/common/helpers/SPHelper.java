package net.bingyan.common.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:34
 * Email    xinliugm@gmail.com
 */

public class SPHelper {
    private final SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SPHelper(SharedPreferences sp) {
        this.sp = sp;
    }

    public void putInt(String k, int v) {
        editor.putInt(k, v);
    }

    public int getInt(String k, int defValue) {
        return sp.getInt(k, defValue);
    }

    public void putLong(String k, long v) {
        editor.putLong(k, v);
    }

    public long getLong(String k, long defValue) {
        return sp.getLong(k, defValue);
    }

    public void putFloadt(String k, float v) {
        editor.putFloat(k, v);
    }

    public float getFloat(String k, float defValue) {
        return sp.getFloat(k, defValue);
    }

    public void putBoolean(String k, boolean v) {
        editor.putBoolean(k, v);
    }

    public boolean getBoolean(String k, boolean defValue) {
        return sp.getBoolean(k, defValue);
    }

    public void putString(String k, String v) {
        editor.putString(k, v);
    }

    public String getString(String k, String defValue) {
        return sp.getString(k, defValue);
    }

    public void putStringSet(String k, Set<String> v) {
        editor.putStringSet(k, v);
    }

    public Set<String> getStringSet(String k, Set<String> defValue) {
        return sp.getStringSet(k, defValue);
    }


    private SharedPreferences.Editor editor() {
        if (editor == null) {
            return sp.edit();
        }
        return editor;
    }

    public void apply() {
        editor.apply();
    }

    public static SPHelper open(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return new SPHelper(sp);
    }
}
