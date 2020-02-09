package com.android.jokelibrary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {
    public static String jokeToDisplay = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        setJoke(jokeToDisplay);
    }

    private void setJoke(String joke) {
        TextView jokeText = findViewById(R.id.tv_joke);
        jokeText.setText(joke);
    }
}
