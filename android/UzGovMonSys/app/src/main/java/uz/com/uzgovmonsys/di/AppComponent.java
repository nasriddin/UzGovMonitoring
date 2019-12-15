package uz.com.uzgovmonsys.di;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.ui.auth.AuthPresenter;
import uz.com.uzgovmonsys.di.module.AppModule;
import uz.com.uzgovmonsys.ui.home.MainPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(AuthPresenter authPresenter);

    void inject(MainPresenter mainPresenter);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder app(App app);

        AppComponent build();
    }
}
