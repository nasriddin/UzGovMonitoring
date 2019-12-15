package uz.com.uzgovmonsys.database;

import androidx.room.Dao;

import io.reactivex.Completable;
import io.reactivex.Single;
import uz.com.uzgovmonsys.database.entity.User;


@Dao
public interface DatabaseService {

    Completable inserUser(User user);

  //  Single<User> getUser();
}
