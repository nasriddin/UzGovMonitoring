package uz.com.uzgovmonsys.database.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "phoneNumber")
    @NonNull
    public String phoneNumber;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "accessToken")
    public String pinCode;

}
