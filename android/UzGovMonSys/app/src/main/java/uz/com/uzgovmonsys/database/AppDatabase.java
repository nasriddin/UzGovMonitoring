package uz.com.uzgovmonsys.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import uz.com.uzgovmonsys.database.dao.UserDao;
import uz.com.uzgovmonsys.database.entity.User;


@Database(entities = {
        User.class

}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
