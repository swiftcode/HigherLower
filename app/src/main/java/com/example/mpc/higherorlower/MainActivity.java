package com.example.mpc.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int targetNumber;

    public void setRandomNumber() {
        targetNumber = randomRange(0, 10);
    }

    public static int randomRange(int min, int max) {
        Random generator = new Random();
        int r = generator.nextInt((max - min) + 1) + min;
        return r;
    }

    public void guessButtonPressed(View view) {
        final EditText guessBoxString = (EditText) findViewById(R.id.guessBox);
        int myGuess  = Integer.parseInt(guessBoxString.getText().toString());

        if (myGuess == targetNumber) {
            Toast.makeText(MainActivity.this, "You guessed it", Toast.LENGTH_LONG).show();
            setRandomNumber();
            Toast.makeText(MainActivity.this, "A new number has been generated.", Toast.LENGTH_LONG).show();
            guessBoxString.setText("");
        } else {
            String missedMessage = myGuess < targetNumber ? "Too low" : "Too high";
            Toast.makeText(MainActivity.this, missedMessage, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setRandomNumber();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
