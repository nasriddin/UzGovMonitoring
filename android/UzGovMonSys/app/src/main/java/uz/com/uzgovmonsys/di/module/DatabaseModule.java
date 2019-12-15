package uz.com.uzgovmonsys.di.module;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uz.com.uzgovmonsys.database.AppDatabase;
import uz.com.uzgovmonsys.database.DatabaseService;
import uz.com.uzgovmonsys.database.DatabaseServiceImp;
import uz.com.uzgovmonsys.di.ApplicationContext;

import static uz.com.uzgovmonsys.constants.Constants.DATABASE_NAME;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    static DatabaseService provideDatabaseService(AppDatabase database){
        return new DatabaseServiceImp(database);
    }

    @Provides
    static AppDatabase provideDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context,AppDatabase.class,DATABASE_NAME).build();
    }
}
