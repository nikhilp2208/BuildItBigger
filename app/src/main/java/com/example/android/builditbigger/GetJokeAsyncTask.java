package com.example.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.example.nikhil.p.myapplication.jokebackend.myJokeApi.MyJokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by nikhil.p on 05/10/16.
 */

public class GetJokeAsyncTask extends AsyncTask<GetJokeListner, Void, String> {
    public static MyJokeApi myApi = null;
    private GetJokeListner mGetJokeListner;

    @Override
    protected String doInBackground(GetJokeListner... getJokeListners) {
        if(myApi == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApi = builder.build();
        }

        mGetJokeListner = getJokeListners[0];

        try {
            return myApi.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mGetJokeListner.onReceived(result);
    }


}
