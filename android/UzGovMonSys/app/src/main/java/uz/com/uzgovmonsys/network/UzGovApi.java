package uz.com.uzgovmonsys.network;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;
import uz.com.uzgovmonsys.madel.Token;
import uz.com.uzgovmonsys.madel.UserRegister;

public interface UzGovApi {
    //
//    @POST("auth/session/migrate")
//    Single<MigrateResponse> migrate(@Header("sessionToken") String sessionToken,
//                                    @Body MigrateRequest migrateRequest);
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Single<Token> onLogin(@Body Login login);

    @Headers("Content-Type: application/json")
    @POST("auth/register")
    Single<Token> register(@Body UserRegister userRegister);


    @GET("regions")
    Single<List<RegionsResponse>> getRegions(@Header("Authorization") String accesToken);

    @GET("regions/{id}")
    Single<List<Organizaions>> getRegionsOrganization(@Header("Authorization") String accesToken,  @Path("id") String id);

    @GET("organizations")
    Single<List<Organizaions>> getOrganizations(@Header("Authorization") String accesToken);


}
