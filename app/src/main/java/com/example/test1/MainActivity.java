package com.example.test1;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout loginScreen, homeScreen;
    EditText usernameEditText, pwdText;
    TextView errormsg;
    /*ImageView oneImageView, twoImageView;*/
    boolean oneShowing, twoShowing;
    int errorCount;

    private void closeKeyboard () {
        View view = this.getCurrentFocus();
        if (view != null) {
            Log.i("info","not null");
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        } else {
            Log.i ("info", "null");
        }
    }
    public void clickLogin (View view) {
        //Log.i ("status", "Clicked");

        Log.i ("info", "usr " + usernameEditText.getText().toString() + " pwd " + pwdText.getText().toString());
        closeKeyboard();

        if ((usernameEditText.getText().toString().equals("admin")) && ((pwdText.getText().toString().equals("123")))) {
            // login successful
            Log.i ("info", "login successful");
            loginScreen.setVisibility(View.INVISIBLE);
            /*homeScreen.setVisibility(View.VISIBLE);*/
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);


 /*           usernameEditText.onEditorAction(EditorInfo.IME_ACTION_DONE);
            pwdText.onEditorAction(EditorInfo.IME_ACTION_DONE);*/

        } else  // print error message
        {
            //Toast.makeText(this, "Incorrect Login", Toast.LENGTH_SHORT).show();
            
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
        /*homeScreen.setVisibility(View.INVISIBLE);*/
        errormsg.setVisibility(View.INVISIBLE);
/*        oneImageView.setVisibility(View.VISIBLE);
        twoImageView.setVisibility(View.INVISIBLE);*/

        usernameEditText.setText("");
        pwdText.setText("");
        errorCount = 0;

        oneShowing = TRUE;
        twoShowing = FALSE;

    }

    /*public void oneClicked (View view) {
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
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginScreen = findViewById(R.id.LoginScreen);
        homeScreen = findViewById(R.id.HomeScreen);
        errormsg = findViewById(R.id.errormsgTextView);
        usernameEditText = findViewById(R.id.usernameEditText);
        pwdText = findViewById(R.id.pwdEditText);
/*        oneImageView = findViewById(R.id.oneImageView);
        twoImageView = findViewById(R.id.twoImageView);*/

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
