package com.example.oddsareroomdb;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class BetListAdapter extends ListAdapter<Bet, WordViewHolder> {

    public BetListAdapter(@NonNull DiffUtil.ItemCallback<Bet> diffCallback) {
        super(diffCallback);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @NonNull

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Bet current = getItem(position);
        holder.bind(current.getBet());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Bet> {

        @Override
        public boolean areItemsTheSame(@NonNull Bet oldItem, @NonNull Bet newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bet oldItem, @NonNull Bet newItem) {
            return oldItem.getBet().equals(newItem.getBet());
        }
    }
}
