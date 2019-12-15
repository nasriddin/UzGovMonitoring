package uz.com.uzgovmonsys.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public  class UtilsClass {


    public static void showKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            (new Handler()).postDelayed(() -> {
                view.requestFocus();
                inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

            }, 50);
        }
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//    public static void animateView(Context context, ViewGroup viewGroup) {
//        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
//        if (vibrator != null && vibrator.hasVibrator()) {
//            vibrator.vibrate(200L);
//        }
//        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake_pin);
//        viewGroup.startAnimation(shake);
//    }
}
