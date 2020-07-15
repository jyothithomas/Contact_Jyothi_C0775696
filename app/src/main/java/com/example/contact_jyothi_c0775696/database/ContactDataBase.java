package com.example.contact_jyothi_c0775696.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contact_jyothi_c0775696.model.Contact;

@Database(entities = Contact.class , exportSchema = false , version = 4)
public abstract class ContactDataBase extends RoomDatabase {


    public static final String DB_NAME = "user_db";

    private static ContactDataBase uInstance;


    public static ContactDataBase getInstance(Context context)
    {
        if(uInstance == null)
        {
            uInstance = Room.databaseBuilder(context.getApplicationContext(), ContactDataBase.class, ContactDataBase.DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return uInstance;
    }

    public abstract ContactDao daoObject();
}

