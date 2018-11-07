package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    @Test
    public void verifyAsyncTaskReturnsNonEmptyString() {
        String message;
        try {
            message = new MainActivity.EndpointsAsyncTask().execute(new Pair<Context, String>(InstrumentationRegistry.getTargetContext(), "joke")).get();


            assertNotNull(message);
            assertThat(message, not(isEmptyString()));
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }

    }
}
