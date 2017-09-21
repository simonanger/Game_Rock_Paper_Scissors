package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void onOnePlayerBeginButtonClicked(View button) {
        Intent intent = new Intent(this, OnePlayerNameInputActivity.class);
        startActivity(intent);
    }

    public void onTwoPlayerBeginButtonClicked(View button) {
        Intent intent = new Intent(this, TwoPlayerNameInputActivity.class);
        startActivity(intent);
    }
}
