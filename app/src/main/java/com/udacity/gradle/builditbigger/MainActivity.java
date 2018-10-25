package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import com.udacity.gradle.builditbigger.javajokes.Joker;



public class MainActivity extends AppCompatActivity {
    private static final String JOKE_EXTRA = "joke";

    private Joker jokeTeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate Joker class
        jokeTeller = new Joker();
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

    public void tellJoke(View view) {
//        String message= new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Joke")).get();
//
//        Intent jokeIntent = new Intent(this, TellJokeActivity.class);
//        jokeIntent.putExtra(JOKE_EXTRA, message);
//
//
//
//        Toast.makeText(this, "Starting new activity", Toast.LENGTH_SHORT).show();
//        startActivity(jokeIntent);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "joke"));
    }
}
