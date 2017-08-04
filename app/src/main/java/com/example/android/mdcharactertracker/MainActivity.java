package com.example.android.mdcharactertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when Heroes button is clicked
    public void loadHeroes(View view){
        // Build intent to load CharacterActivity
        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);
    }
}
