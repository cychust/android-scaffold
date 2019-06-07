package net.bingyan.common.helpers;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:25
 * Email    xinliugm@gmail.com
 */

public class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void toggleShiftMode(BottomNavigationView view, boolean toggle) {
        BottomNavigationView menu = (BottomNavigationView) view.getChildAt(0);
        try {
           Field shiftingMode = menu.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menu, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menu.getChildCount(); i++) {

                BottomNavigationItemView itemView = (BottomNavigationItemView) menu.getChildAt(i);
                itemView.setShiftingMode(false);
                //set once again checked value , so viewWrapper will be updated
                itemView.setChecked(itemView.getItemData().isChecked());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
