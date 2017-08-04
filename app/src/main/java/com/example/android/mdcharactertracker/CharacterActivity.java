package com.example.android.mdcharactertracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class CharacterActivity extends AppCompatActivity {
    // Data Lists
    private ArrayList<String> mLevelStrings;
            //new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.level_labels_list)));

    // LevelSlider View, Adapter, and Layout Manager
    private RecyclerView mLevelSlider;
    private LevelSliderAdapter mLevelSliderAdapter;
    //private RecyclerView.LayoutManager mLevelSliderManager;
    private LinearLayoutManager mLevelSliderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        // Populate Level Strings
        mLevelStrings = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.level_labels_list)));

        // Attach lists to the Adapters and the Adapters to the Views
        mLevelSliderAdapter = new LevelSliderAdapter(this, mLevelStrings);
        mLevelSlider = (RecyclerView) findViewById(R.id.level_recview);
        mLevelSlider.setAdapter(mLevelSliderAdapter);

        // Calculste size and set LayoutManager for LevelSlider
        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (80 * scale + 0.5f);

        mLevelSliderManager = new LinearLayoutManager(this);
        mLevelSlider.getLayoutParams().width = pixels * mLevelStrings.size();
        mLevelSliderManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        // Set layout manager to LinearLayoutManager
        //mLevelSliderManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLevelSlider.setLayoutManager(mLevelSliderManager);
    }
}
