package uz.com.uzgovmonsys.database;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import uz.com.uzgovmonsys.database.entity.User;

public class DatabaseServiceImp implements DatabaseService {

    private AppDatabase appDatabase;

    public DatabaseServiceImp(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Completable inserUser(User user) {
        return Completable.fromAction(() -> appDatabase.userDao().insertUser(user)).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    @Override
//    public Single<User> getUser() {
//        return appDatabase.userDao().getUser().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }
}
