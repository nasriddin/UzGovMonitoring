package uz.com.uzgovmonsys;

import android.content.Context;
import android.content.Intent;

import uz.com.uzgovmonsys.ui.home.MainActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class Navigate {

    public static void openMain(Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}
