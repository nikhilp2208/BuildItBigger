package com.example.android.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.android.jokesview.JokesViewActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements GetJokeListner {

    ProgressBar spinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        spinner = (ProgressBar) view.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        Button getJokeButton = (Button) view.findViewById(R.id.get_joke_button);
        getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startJokeActivity();
            }
        });

        return view;
    }

    @Override
    public void onReceived(String joke) {
        Intent intent = new Intent(getActivity(),JokesViewActivity.class);
        intent.putExtra(JokesViewActivity.EXTRA_JOKE, joke);
        spinner.setVisibility(View.GONE);
        startActivity(intent);
    }

    private void startJokeActivity() {
        spinner.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask().execute(this);
    }
}
