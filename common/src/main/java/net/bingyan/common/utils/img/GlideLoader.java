package net.bingyan.common.utils.img;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     21:55
 * Email    xinliugm@gmail.com
 */

public class GlideLoader implements Loader {
    @Override
    public void loadImage(Context context, String res, ImageView target) {
        Glide.with(context)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(Context context, int res, ImageView target) {
        Glide.with(context)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(Activity activity, String res, ImageView target) {
        Glide.with(activity)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(Activity activity, int res, ImageView target) {
        Glide.with(activity)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(Fragment fragment, String res, ImageView target) {
        Glide.with(fragment)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(Fragment fragment, int res, ImageView target) {
        Glide.with(fragment)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(android.app.Fragment fragment, String res, ImageView target) {
        Glide.with(fragment)
                .load(res)
                .into(target);
    }

    @Override
    public void loadImage(android.app.Fragment fragment, int res, ImageView target) {
        Glide.with(fragment)
                .load(res)
                .into(target);
    }
}
