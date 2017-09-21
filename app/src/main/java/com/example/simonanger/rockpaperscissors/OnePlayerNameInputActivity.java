package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OnePlayerNameInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_name_input);
    }

    public void onOnePlayerButtonClicked(View button) {
        Intent intent = new Intent(this, RockPaperScissorsActivity.class);
        startActivity(intent);
    }
}
