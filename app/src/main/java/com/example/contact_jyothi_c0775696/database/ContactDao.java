package com.example.contact_jyothi_c0775696.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contact_jyothi_c0775696.model.Contact;

import java.util.List;
@Dao
public interface ContactDao {

    @Insert
    void insert(Contact contact);
    @Delete
    void delete(Contact contact);
    @Update
    void update(Contact contact);
    @Query("SELECT count(id) from contact")
    Integer count();
    @Query("SELECT count(id) from contact")
    LiveData<Integer> countLive();
    @Query("SELECT * from contact")
    LiveData<List<Contact>> getUserDetails();
    @Query("SELECT * from contact")
    List<Contact> getDefault();

}
