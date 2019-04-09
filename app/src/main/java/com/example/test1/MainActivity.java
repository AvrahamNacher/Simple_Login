package com.example.test1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout loginScreen, homeScreen;
    EditText usernameEditText, pwdText;
    TextView errormsg;
    int errorCount;

    public void clickFunction (View view) {
        Log.i ("status", "Clicked");

        Log.i ("info", "usr " + usernameEditText.getText().toString() + " pwd " + pwdText.getText().toString());


        if ((usernameEditText.getText().toString().equals("admin")) && ((pwdText.getText().toString().equals("123")))) {
            // login successful
            Log.i ("info", "login successful");
            loginScreen.setVisibility(View.INVISIBLE);
            homeScreen.setVisibility(View.VISIBLE);

        } else  // print error message
        {
            Log.i ("info", "bad login");
            errorCount++;
            switch (errorCount) {
                case 1:
                    errormsg.setText("Please enter a valid Username and Password. Press 'Login' again for hints");
                    break;
                case 2:
                    errormsg.setText("Hint: Username is 'admin'");
                    break;
                case 3:
                    errormsg.setText("Hint: Password is '123'");
                    break;
                default:
                    errormsg.setText("Buddy, use 'admin' for the username and '123' for the password!");
                    break;
            }
            errormsg.setVisibility(View.VISIBLE);

        }
    }
    public void restartButton (View view) {
        restart();
    }
    public void restart () {

        loginScreen.setVisibility(View.VISIBLE);
        homeScreen.setVisibility(View.INVISIBLE);
        errormsg.setVisibility(View.INVISIBLE);

        usernameEditText.setText("");
        pwdText.setText("");
        errorCount = 0;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginScreen = findViewById(R.id.LoginScreen);
        homeScreen = findViewById(R.id.HomeScreen);
        errormsg = findViewById(R.id.errormsgTextView);
        usernameEditText = findViewById(R.id.usernameEditText);
        pwdText = findViewById(R.id.pwdEditText);

        usernameEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                usernameEditText.setText("");
                errormsg.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        pwdText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pwdText.setText("");
                errormsg.setVisibility(View.INVISIBLE);
                return false;
            }
        });


        restart ();

    }
}
