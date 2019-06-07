package net.bingyan.common.utils;

import android.util.Log;

import net.bingyan.common.BuildConfig;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:33
 * Email    xinliugm@gmail.com
 */

public class Logger {
    public static void verbose(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(getTag(), msg);
        }
    }

    public static void debug(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(getTag(), msg);
        }
    }

    public static void info(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(getTag(), msg);
        }
    }

    public static void warn(String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(getTag(), msg);
        }
    }

    public static void error(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(getTag(), msg);
        }
    }
    private static  String getTag() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackElement = stackTrace[4];

        return "(${stackElement.fileName}:${stackElement.lineNumber})" + stackElement.getMethodName();
    }
}
