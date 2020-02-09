package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.jokelibrary.JokeActivity;
import com.android.joker.Joker;

import static com.android.jokelibrary.JokeActivity.JOKE_EXTRA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jokeButton = findViewById(R.id.btn_joke);
        tellJoke(jokeButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(Button button) {
//        Toast.makeText(this, Joker.getJoke(), Toast.LENGTH_LONG).show();
        final Intent jokeIntent = new Intent(this, JokeActivity.class);
        jokeIntent.putExtra(JOKE_EXTRA, Joker.getJoke());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask().execute(new Pair<Context, String>(MainActivity.this, "Test"));
//                startActivity(jokeIntent);
            }
        });
    }


}
