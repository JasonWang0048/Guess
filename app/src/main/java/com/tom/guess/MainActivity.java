package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText edGuess;
    int secret = new Random().nextInt(10) + 1;
    String TAG = MainActivity.class.getSimpleName();
    private int num;
    private TextView react;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "secret: " + secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edGuess = findViewById(R.id.guessing);
        react = findViewById(R.id.reaction);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void guessNumber(View view) {
        num = Integer.parseInt(edGuess.getText().toString());
        if (num == secret) {
            react.setText("That is Right!!");
            Toast.makeText(MainActivity.this, "You're smart!", Toast.LENGTH_LONG).show();
        } else {
            react.setText("Wrong! Try again~");
            if (num < secret) {
                Toast.makeText(MainActivity.this, "Guess a bigger one.", Toast.LENGTH_LONG).show();
            } else if (num > secret) {
                Toast.makeText(MainActivity.this, "Guess a smaller one.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a number!!!", Toast.LENGTH_LONG).show();
            }
        }
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
