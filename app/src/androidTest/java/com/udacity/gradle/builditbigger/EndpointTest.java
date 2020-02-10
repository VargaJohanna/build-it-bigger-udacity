package com.udacity.gradle.builditbigger;

import com.android.jokelibrary.JokeActivity;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;

public class EndpointTest {

    @Test
    public void endpointAsyncTaskShouldReturnJoke() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);

        new EndpointsAsyncTask(new OnTaskCompleted() {
            @Override
            public void onTaskCompleted() {
                signal.countDown();
            }
        }).execute();

        // Add this wait to ensure that the AsyncTask has finished.
        signal.await();

        assertFalse(JokeActivity.jokeToDisplay.isEmpty());
    }
}