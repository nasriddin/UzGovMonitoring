package uz.com.uzgovmonsys.ui.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;
import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.Navigate;
import uz.com.uzgovmonsys.di.ApplicationContext;
import uz.com.uzgovmonsys.madel.RegisterExeption;
import uz.com.uzgovmonsys.madel.Token;
import uz.com.uzgovmonsys.madel.UserRegister;
import uz.com.uzgovmonsys.network.ApiService;
import uz.com.uzgovmonsys.madel.Login;

import static uz.com.uzgovmonsys.constants.Constants.ISLOGIN;
import static uz.com.uzgovmonsys.constants.Constants.TOKEN;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthCallback> {
    @Inject
    ApiService apiService;
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    @ApplicationContext
    Context context;

    public AuthPresenter() {
        App.getAppConponent().inject(this);
    }

    @SuppressLint("CheckResult")
    public void register(UserRegister userRegister) {
        getViewState().showLoading();
        apiService.register(userRegister).subscribe(token -> {
            getViewState().hideLoading();
            if (token.getStatus() == 1) {
                Toast.makeText(context, token.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                if (token.getStatus() == 0) {
                    sharedPreferences.edit().putString(TOKEN, token.getTokenType() + " " + token.getAccessToken()).apply();
                    sharedPreferences.edit().putBoolean(ISLOGIN, true).apply();
                    getViewState().openMain();
                }
            }
            System.out.println("TOKEN" + token.getAccessToken());

        }, throwable -> {
            getViewState().hideLoading();

            System.out.println("exempion  " + throwable.toString());
        });

    }

    @SuppressLint("CheckResult")
    public void onLogin(Login login) {
        getViewState().showLoading();
        apiService.onLogin(login).subscribe(token -> {
            getViewState().hideLoading();
            Log.e("onLogin: ", token.getAccessToken());
            sharedPreferences.edit().putString(TOKEN, token.getTokenType() + " " + token.getAccessToken()).apply();
            sharedPreferences.edit().putBoolean(ISLOGIN, true).apply();
            getViewState().openMain();
        }, throwable -> {
            getViewState().hideLoading();
        });


    }

    public void create() {
        if (sharedPreferences.getBoolean(ISLOGIN, false)) {
            getViewState().hideLoading();
            getViewState().openMain();
        } else {
            getViewState().hideLoading();
            getViewState().openLoginFragment();
        }
    }
}
