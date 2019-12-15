package uz.com.uzgovmonsys.network;

import android.content.Context;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;
import uz.com.uzgovmonsys.madel.Token;
import uz.com.uzgovmonsys.madel.UserRegister;

public class ApiServiceImple implements ApiService {
    private final Context context;
    private final UzGovApi uzGovApi;

    public ApiServiceImple(Context context, UzGovApi uzGovApi) {
        this.context = context;
        this.uzGovApi = uzGovApi;
    }

    @Override
    public Single<Token> onLogin(Login login) {
        return uzGovApi.onLogin(login).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<Token> register(UserRegister userRegister) {
        return uzGovApi.register(userRegister).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<List<RegionsResponse>> getRegions(String accesToken) {
        return uzGovApi.getRegions(accesToken).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<Organizaions>> getOrganizations(String accesToken) {
        return uzGovApi.getOrganizations(accesToken).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<Organizaions>> getRegionsOrganization(String accesToken,String id) {
        return  uzGovApi.getRegionsOrganization(accesToken,id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


//    @Override
//    public Single<GetSessionTokenResponse> getSessionToken(String clientVersion, String deviceModel, String platformVersion) {
//        return myUztelecomAPI.getSessionToken(clientVersion, deviceModel, platformVersion)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

}
