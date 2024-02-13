package com.example.oddsareroomdb;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BetViewModel extends AndroidViewModel {
    private BetDepository mRepository;

    private final LiveData<List<Bet>> mAllBets;

    public BetViewModel (Application application) {
        super(application);
        mRepository = new BetDepository(application);
        mAllBets = mRepository.getAllBets();
    }

    LiveData<List<Bet>> getAllBets() { return mAllBets; }

    public void insert(Bet bet) { mRepository.insert(bet); }
}
