package com.example.oddsareroomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity (tableName = "bet_table")
//public class Bet {
//    @PrimaryKey (autoGenerate = true)
//    private int id;
//    @NonNull
//    private String abet;
//    @ColumnInfo (name = "bet")
//    private String mAbet;
//
//    public Bet(@NonNull String abet) {this.mAbet = abet;}
//
//    public String getBet(){return this.mAbet;}
//    public int getId(){return this.id;}
//}
@Entity(tableName = "bet_table")
public class Bet {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "bet")
    private String mBet;

    public Bet(@NonNull String bet) {
        this.mBet = bet;
    }

    public String getBet() {
        return this.mBet;
    }
}