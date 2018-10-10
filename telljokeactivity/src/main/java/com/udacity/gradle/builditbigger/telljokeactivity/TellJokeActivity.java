package com.udacity.gradle.builditbigger.telljokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TellJokeActivity extends AppCompatActivity {
    private static final String JOKE_EXTRA = "joke";

    private TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);

        jokeTv = (TextView) findViewById(R.id.joke_tv);

        String jokeMessage = getIntent().getStringExtra(JOKE_EXTRA);

        jokeTv.setText(jokeMessage);
    }
}
