package com.example.oddsareroomdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BetDepository {

        private BetDao mBetDao;
        private LiveData<List<Bet>> mAllBets;

        // Note that in order to unit test the WordRepository, you have to remove the Application
        // dependency. This adds complexity and much more code, and this sample is not about testing.
        // See the BasicSample in the android-architecture-components repository at
        // https://github.com/googlesamples
        BetDepository(Application application) {
            BetRoomDatabase db = BetRoomDatabase.getDatabase(application);
            mBetDao = db.betDao();
            mAllBets = mBetDao.getAlphabetizedBet();
        }

        // Room executes all queries on a separate thread.
        // Observed LiveData will notify the observer when the data has changed.
        LiveData<List<Bet>> getAllBets() {
            return mAllBets;
        }

        // You must call this on a non-UI thread or your app will throw an exception. Room ensures
        // that you're not doing any long running operations on the main thread, blocking the UI.
        void insert(Bet bet) {
            BetRoomDatabase.databaseWriteExecutor.execute(() -> {
                mBetDao.insert(bet);
            });
        }
    }

