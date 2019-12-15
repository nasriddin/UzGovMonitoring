package uz.com.uzgovmonsys.network;

import android.media.session.MediaSession;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Header;
import retrofit2.http.Part;
import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;
import uz.com.uzgovmonsys.madel.Token;
import uz.com.uzgovmonsys.madel.UserRegister;

public interface ApiService {
    //serverFuncktions

    // Single<HomeResponse> homeUzonline(String authToken, String langCode, long date);

    Single<Token> onLogin(Login login);

    Single<Token> register(UserRegister userRegister);
    Single<List<RegionsResponse>> getRegions(String accesToken);
    Single<List<Organizaions>> getOrganizations(String accesToken);
    Single<List<Organizaions>> getRegionsOrganization(String accesToken, String id);

}
