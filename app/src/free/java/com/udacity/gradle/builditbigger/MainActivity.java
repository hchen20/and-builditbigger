package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.javajokes.Joker;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private static final String JOKE_EXTRA = "joke";
    public static final String TAG = "MainActivity";

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

    static class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private static MyApi myApiService = null;
        private Context context;

        public EndpointsAsyncTask() {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        @Override
        protected String doInBackground(Pair<Context, String>... pairs) {
            context = pairs[0].first;
            String joke = pairs[0].second;

            try {
                String message = myApiService.sayHi(joke).execute().getData();
                Log.d(TAG, "doInBackground: " + message);
                return myApiService.sayHi(joke).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        }
    }
}
