package uz.com.uzgovmonsys.ui.home;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.gson.Gson;

import javax.inject.Inject;

import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.network.ApiService;

import static uz.com.uzgovmonsys.constants.Constants.TOKEN;
import static uz.com.uzgovmonsys.constants.Constants.TOKENS;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainCallback> {


    @Inject
    ApiService apiService;
    @Inject
    SharedPreferences sharedPreferences;
    String accessToken;

    public MainPresenter() {
        App.getAppConponent().inject(this);
        accessToken = sharedPreferences.getString(TOKEN, "");
    }


    @SuppressLint("CheckResult")
    public void getRegions() {

        apiService.getRegions(accessToken).subscribe(regionsResponses -> {
            getViewState().setRegions(regionsResponses);
            getViewState().hideLoading();
        }, throwable -> {

        });
    }

    @SuppressLint("CheckResult")
    public void getOrganizations() {
        apiService.getOrganizations(accessToken).subscribe(organizaions -> {
            getViewState().hideLoading();
            getViewState().organizations(organizaions);
            Log.e("organization 1", "getOrganizations: " + organizaions.get(0).getName());
        }, throwable -> {

            getViewState().hideLoading();
        });


    }


    @SuppressLint("CheckResult")
    public void getOrganizationsByID(String id) {
        apiService.getRegionsOrganization(accessToken, id).subscribe(organizaions -> {
                    Log.e("org", organizaions.size() + " ");
                    getViewState().hideLoading();
                    getViewState().organizations(organizaions);
                },
                throwable -> getViewState().hideLoading());
    }
}
