package uz.com.uzgovmonsys.ui.auth;

import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.Navigate;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.madel.UserRegister;

public class AuthActivity extends MvpAppCompatActivity implements AuthCallback, AuthActivityListener {

    @BindView(R.id.container)
    FrameLayout container;

    @InjectPresenter
    AuthPresenter presenter;

    @BindView(R.id.viewProgress)
    FrameLayout loadingView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        //  presenter.create();
        //openRegisterFragment();
        showLoading();
        presenter.create();
    }

    public void openRegisterFragment() {
        fragmentManager.beginTransaction().replace(R.id.container, new RegisterFragment()).addToBackStack(RegisterFragment.TAG)
                .commit();
    }

    @Override
    public void openMain() {
        Navigate.openMain(getApplicationContext());
        finish();

    }

    public void openLoginFragment() {
        fragmentManager.beginTransaction().replace(R.id.container, new LoginFragment()).addToBackStack(LoginFragment.TAG)
                .commit();
    }


    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();

        } else if (count == 1) {
            finish();
        } else {
            Log.d("back", "onBackPressed");
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);

    }

    @Override
    public void register(UserRegister userRegister) {
        presenter.register(userRegister);
    }

    @Override
    public void login(Login login) {
        presenter.onLogin(login);
    }

    @Override
    public void createAuth() {
        openRegisterFragment();
    }
}
