package uz.com.uzgovmonsys.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.readystatesoftware.chuck.ChuckInterceptor;
import com.squareup.moshi.Moshi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import uz.com.uzgovmonsys.BuildConfig;
import uz.com.uzgovmonsys.di.ApplicationContext;
import uz.com.uzgovmonsys.network.ApiService;
import uz.com.uzgovmonsys.network.ApiServiceImple;
import uz.com.uzgovmonsys.network.UzGovApi;

import static uz.com.uzgovmonsys.constants.Constants.BASE_URL;
import static uz.com.uzgovmonsys.constants.Constants.CONNECT_TIMEOUT;
import static uz.com.uzgovmonsys.constants.Constants.READ_TIMEOUT;
import static uz.com.uzgovmonsys.constants.Constants.WRITE_TIMEOUT;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    static ApiService provideNetworkService(@ApplicationContext Context context,
                                            UzGovApi uzGovApi)
                                             {
        return new ApiServiceImple(context, uzGovApi);
    }

    @Provides
    static UzGovApi provideMyUztelecomApi(Retrofit retrofit) {
        return retrofit.create(UzGovApi.class);
    }

    @Provides
    static Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, MoshiConverterFactory moshiConverterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL+"/")
                .addConverterFactory(gsonConverterFactory)
                .addConverterFactory(moshiConverterFactory)
               // .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    static OkHttpClient provideOkHttpClient(@ApplicationContext Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
       // if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(new ChuckInterceptor(context));
            okHttpClientBuilder.addInterceptor(interceptor);
       //}

        return okHttpClientBuilder
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .cache(null)
                .build();
    }

    @Provides
    static Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    static MoshiConverterFactory provideMoshiConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Provides
    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    static GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}
