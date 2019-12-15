package uz.com.uzgovmonsys.ui.auth;

import com.arellomobile.mvp.MvpView;

public interface AuthCallback extends MvpView {

    public void showLoading();

    public void hideLoading();

    void openRegisterFragment();

    void openLoginFragment();

    void openMain();
}
