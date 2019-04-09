package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class HomePage extends AppCompatActivity {
    boolean oneShowing, twoShowing;
    ImageView oneImageView, twoImageView;

    public void oneClicked (View view) {
        if (oneShowing) {
            oneImageView.setImageResource(R.drawable.num_03);

        } else {
            oneImageView.setImageResource(R.drawable.num_01);
        }
        oneShowing = !oneShowing; // switch for next time
        oneImageView.setVisibility(View.INVISIBLE);
        twoImageView.setVisibility(View.VISIBLE);
    }

    public void twoClicked (View view) {
        oneImageView.setVisibility(View.VISIBLE);
        twoImageView.setVisibility(View.INVISIBLE);
    }

    public void restartButton (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Log.i ("info", "Home Page");

        oneImageView = findViewById(R.id.oneImageView);
        twoImageView = findViewById(R.id.twoImageView);

        oneImageView.setVisibility(View.VISIBLE);
        twoImageView.setVisibility(View.INVISIBLE);

        oneShowing = TRUE;
        twoShowing = FALSE;
    }
}
