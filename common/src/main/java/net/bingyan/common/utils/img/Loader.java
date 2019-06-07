package net.bingyan.common.utils.img;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     21:56
 * Email    xinliugm@gmail.com
 */

interface Loader {
    void loadImage(Context context, String res, ImageView target);

    void loadImage(Context context, int res, ImageView target);

    void loadImage(Activity activity, String res, ImageView target);

    void loadImage(Activity activity, int res, ImageView target);

    void loadImage(Fragment fragment, String res, ImageView target);

    void loadImage(Fragment fragment, int res, ImageView target);

    void loadImage(android.app.Fragment fragment, String res, ImageView target);

    void loadImage(android.app.Fragment fragment, int res, ImageView target);
}
