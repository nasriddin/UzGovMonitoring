package uz.com.uzgovmonsys.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.di.ApplicationContext;

import static uz.com.uzgovmonsys.constants.Constants.SHARED_PREFERENCES;


@Module(includes = {DatabaseModule.class, NetworkModule.class})
public abstract class AppModule {

    @Provides
    @ApplicationContext
    static Context provideAppContext(Application application) {
        return application.getApplicationContext();
    }

    @Binds
    @Singleton
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Application application(App app);

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

}
