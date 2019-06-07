package net.bingyan.common.utils;

import android.app.Application;
import android.widget.Toast;

import net.bingyan.common.R;

/**
 * Author   dashmrl
 * Date     03/03/2018
 * Time     19:30
 * Email    xinliugm@gmail.com
 */
@SuppressWarnings("StaticFieldLeak")
public class Courier {
    private static Application appRef;
    private static final int LEVEL_INFO = 0;
    private static final int LEVEL_WARN = 1;
    private static final int LEVEL_SUCCESS = 2;
    private static final int LEVEL_FAILED = 3;
    private static Toast toast;
    private static int preLevel = -1;

    public static void init(Application app) {
        appRef = app;
    }

    public static void info(CharSequence msg) {
        show(msg, LEVEL_INFO);
    }

    public static void info(int msg) {
        show(msg, LEVEL_INFO);
    }

    public static void warn(CharSequence msg) {
        show(msg, LEVEL_WARN);
    }

    public static void warn(int msg) {
        show(msg, LEVEL_WARN);
    }

    public static void success(CharSequence msg) {
        show(msg, LEVEL_SUCCESS);
    }

    public static void success(int msg) {
        show(msg, LEVEL_SUCCESS);
    }

    public static void failed(CharSequence msg) {
        show(msg, LEVEL_FAILED);
    }

    public static void failed(int msg) {
        show(msg, LEVEL_FAILED);
    }


    private static void show(CharSequence msg, int level) {
        if (toast == null) {
            toast = Toast.makeText(appRef, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        if (preLevel != level) {
            int bgRes = 0;
            switch (level) {
                case LEVEL_INFO: {
                    bgRes = R.drawable.bg_toast_frame_info;
                    break;
                }
                case LEVEL_WARN: {
                    bgRes = R.drawable.bg_toast_frame_warn;
                    break;
                }
                case LEVEL_SUCCESS: {
                    bgRes = R.drawable.bg_toast_frame_success;
                    break;
                }
                case LEVEL_FAILED: {
                    bgRes = R.drawable.bg_toast_frame_failed;
                    break;
                }
            }
            toast.getView().setBackgroundResource(bgRes);
        }
        preLevel = level;
        toast.show();
    }

    private static void show(int msg, int level) {
        show(appRef.getString(msg), level);
    }

}
