package com.example.oddsareroomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface BetDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Bet bet);

    @Query("DELETE FROM bet_table")
    void deleteAll();

    @Query("SELECT * FROM bet_table ORDER BY bet ASC")
    LiveData<List<Bet>>getAlphabetizedBet();

    @Delete
    public void deleteBet(Bet... bet);
}
