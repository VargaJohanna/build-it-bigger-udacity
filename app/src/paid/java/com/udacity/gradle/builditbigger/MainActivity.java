package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.android.jokelibrary.JokeActivity;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted {
    ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jokeButton = findViewById(R.id.btn_joke);
        progressBar = findViewById(R.id.progressBar);
        tellJoke(jokeButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAsyncTask();
            }
        });
    }

    private void startAsyncTask() {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(MainActivity.this).execute();
    }

    @Override
    public void onTaskCompleted() {
        progressBar.setVisibility(View.GONE);
        startActivity(new Intent(this, JokeActivity.class));
    }
}
