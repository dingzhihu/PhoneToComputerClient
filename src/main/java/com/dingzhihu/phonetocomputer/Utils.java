package com.dingzhihu.phonetocomputer;

import android.app.Activity;
import android.view.ViewGroup;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created with IntelliJ IDEA.
 * User: dingzhihu
 * Date: 13-2-25
 * Time: 下午1:43
 */
public final class Utils {

    public static void confirm(Activity activity, CharSequence text) {
        Crouton.makeText(activity, text, buildStyle(0xff99cc00)).show();
    }

    public static void info(Activity activity, CharSequence text) {

        Crouton.makeText(activity, text, buildStyle(0xff33b5e5)).show();


    }

    public static void alert(Activity activity, CharSequence text) {
        Crouton.makeText(activity, text, buildStyle(0xffff4444)).show();

    }

    private static Style buildStyle(int color) {
        return new Style.Builder()
                .setDuration(1000)
                .setBackgroundColorValue(color)
                .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .build();

    }


}
