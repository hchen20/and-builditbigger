package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    @Test
    public void verifyAsyncTaskReturnsNonEmptyString() {
        String message;
        try {
            MainActivity activity = new MainActivity();
            message = new MainActivity.EndpointsAsyncTask().execute(new Pair<Context, String>(activity, "joke")).get();

            assertNotNull(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
