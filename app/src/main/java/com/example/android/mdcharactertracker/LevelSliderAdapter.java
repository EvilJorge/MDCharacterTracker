package com.example.android.mdcharactertracker;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cpalomares on 8/2/2017.
 */

public class LevelSliderAdapter extends RecyclerView.Adapter<LevelSliderAdapter.ViewHolder> {
    // Store a member variable for the level labels
    private ArrayList<String> mLevelStrings;

    // Store context for easy access
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView levelTextView;

        // Constructor for the Level label view holder
        public ViewHolder(View itemView) {
            super(itemView);

            levelTextView = (TextView) itemView.findViewById(R.id.level_label);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public LevelSliderAdapter(Context context, ArrayList<String> levelStrings){
        mLevelStrings = levelStrings;
        mContext = context;
    }

    // Easy access to the context object in the RecyclerView
    private Context getContext() {
        return mContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LevelSliderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();

        // Inflate the custom layout
        View levelView = (View) LayoutInflater.from(context)
                .inflate(R.layout.item_level_slider, parent, false);

        // set the view's size, margins, paddings, etc.
        ViewHolder vh = new ViewHolder(levelView);
        return vh;
    }

    // Populate the data through the ViewHolder
    @Override
    public void onBindViewHolder(LevelSliderAdapter.ViewHolder viewHolder, int position){
        // - get element from your dataset at this position
        String newString = mLevelStrings.get(position);

        int level1Background = ContextCompat.getColor(getContext(), R.color.level1Background);
        int level2Background = ContextCompat.getColor(getContext(), R.color.level2Background);
        int level3Background = ContextCompat.getColor(getContext(), R.color.level3Background);
        int level4Background = ContextCompat.getColor(getContext(), R.color.level4Background);
        int level5Background = ContextCompat.getColor(getContext(), R.color.level5Background);

        // - replace the contents of the view with that element
        TextView textView = viewHolder.levelTextView;
        textView.setText(newString);

        switch(position) {
            case 0:
                textView.setBackgroundColor(level1Background);
                break;
            case 1:
                textView.setBackgroundColor(level2Background);
                break;
            case 2:
                textView.setBackgroundColor(level3Background);
                textView.setTextColor(Color.WHITE);
                break;
            case 3:
                textView.setBackgroundColor(level4Background);
                textView.setTextColor(Color.WHITE);
                break;
            case 4:
                textView.setBackgroundColor(level5Background);
                textView.setTextColor(Color.WHITE);
                break;
            default: break;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return mLevelStrings.size();
    }
}
