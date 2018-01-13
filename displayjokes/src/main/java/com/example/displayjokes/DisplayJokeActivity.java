package com.example.displayjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplay_joke);
        Bundle bundle = getIntent().getExtras();
        String joke = bundle.getString("joke");
        TextView textView = (TextView) findViewById(R.id.displayJoke_tv);
        if (joke != null)
            if (!joke.isEmpty()) {
                textView.setText(joke);
            } else {
                textView.setText("Sorry No joke Something Went Wrong");
            }
    }
}
