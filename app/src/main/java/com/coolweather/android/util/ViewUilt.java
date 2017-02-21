package com.coolweather.android.util;

import android.app.Activity;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by huxiyang on 2017/2/21.
 */

public class ViewUilt {

    public static <T extends View> T findViewById(View rootView, int resId) {
        return (T) rootView.findViewById(resId);
    }

    public static <T extends View>T findViewById(Activity activity, int resId) {
        return (T) activity.findViewById(resId);
    }
}
