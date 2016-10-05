package com.example.android.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nikhil.p on 05/10/16.
 */

public class ApplicationTest extends ApplicationTestCase<Application> {
    private String jokeText = null;

    public ApplicationTest() {
        super(Application.class);
    }

    public void testJokeAsyncTask() throws InterruptedException {
        new GetJokeAsyncTask().execute(new GetJokeListner() {
            @Override
            public void onReceived(String joke) {
                jokeText = joke;
            }
        });

        Thread.sleep(5000);
        assertFalse(TextUtils.isEmpty(jokeText));
    }
}
