package com.android.jokelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static String JOKE_EXTRA = "JOKE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        String jokeToShow = "";
        if(extras != null) {
            jokeToShow = extras.getString(JOKE_EXTRA);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        setJoke(jokeToShow);
    }

    private void setJoke(String joke) {
        TextView jokeText = findViewById(R.id.tv_joke);
        jokeText.setText(joke);
    }
}
