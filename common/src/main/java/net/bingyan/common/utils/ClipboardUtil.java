package net.bingyan.common.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/**
 * Author   dashmrl
 * Date     03/03/2018
 * Time     19:50
 * Email    xinliugm@gmail.com
 */

public class ClipboardUtil {

    public static void copyText(Context ctx, String label, String text) {
        getCM(ctx).setPrimaryClip(ClipData.newPlainText(label, text));
    }

    public static String pasteText(Context ctx) {
        ClipboardManager cm = getCM(ctx);
        if (cm.hasPrimaryClip()) {
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null) {
                if (clipData.getItemCount() > 0) {
                    return clipData.getItemAt(0).getText().toString();
                }
            }
        }
        return "";
    }

    public static void copyRawUri(Context ctx, String label, Uri uri) {
        getCM(ctx).setPrimaryClip(ClipData.newRawUri(label, uri));
    }

    public static Uri pasteRawUri(Context ctx) {
        ClipboardManager cm = getCM(ctx);
        if (cm.hasPrimaryClip()) {
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null) {
                if (clipData.getItemCount() > 0) {
                    return clipData.getItemAt(0).getUri();
                }
            }
        }
        return null;
    }

    public static void copyUri(Context ctx, String label, Uri uri) {
        getCM(ctx).setPrimaryClip(ClipData.newUri(ctx.getContentResolver(), label, uri));
    }

    public static Uri pasteUri(Context ctx) {
        ClipboardManager cm = getCM(ctx);
        if (cm.hasPrimaryClip()) {
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null) {
                if (clipData.getItemCount() > 0) {
                    return clipData.getItemAt(0).getUri();
                }
            }
        }
        return null;
    }

    public static void copyIntent(Context ctx, String label, Intent intent) {
        getCM(ctx).setPrimaryClip(ClipData.newIntent(label, intent));
    }

    public static Intent pasteIntent(Context ctx) {
        ClipboardManager cm = getCM(ctx);
        if (cm.hasPrimaryClip()) {
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null) {
                if (clipData.getItemCount() > 0) {
                    return clipData.getItemAt(0).getIntent();
                }
            }
        }
        return null;
    }

    private static ClipboardManager getCM(Context ctx) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ctx.getSystemService(ClipboardManager.class);
        } else {
            return (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
        }
    }
}
