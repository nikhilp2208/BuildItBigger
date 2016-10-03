package com.example.android.jokesview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesViewActivity extends AppCompatActivity {
    public static String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_view);

        String joke = "Default Joke";
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_JOKE)) {
            joke = intent.getStringExtra(EXTRA_JOKE);
        }

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
