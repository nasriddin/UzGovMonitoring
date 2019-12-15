package uz.com.uzgovmonsys;

import android.app.Application;

import uz.com.uzgovmonsys.di.AppComponent;
import uz.com.uzgovmonsys.di.DaggerAppComponent;

public class App extends Application {

    private static  AppComponent appConponent;
    public static AppComponent getAppConponent(){
        return appConponent;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        appConponent= DaggerAppComponent.builder().app(this).build();
        appConponent.inject(this);
    }
}
