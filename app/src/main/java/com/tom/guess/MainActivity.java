package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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
    int count;
    private TextView com;
    private Button butt;
    private String word;
    private String message;
    private TextView edCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "secret: " + secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edGuess = findViewById(R.id.guessing);
        react = findViewById(R.id.reaction);
        com = findViewById(R.id.comment);
        butt = findViewById(R.id.button);
        edCount = findViewById(R.id.counter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secret = new Random().nextInt(10) + 1;
                Log.d(TAG, "secret: " + secret);
                count = 0;
                edCount.setText(count + "");
                edGuess.setText("");
                react.setText("Trust your intuition.");
                Toast.makeText(MainActivity.this, "You've restart the game!", Toast.LENGTH_LONG).show();
                com.setVisibility(View.GONE);
                edGuess.setVisibility(View.VISIBLE);
                butt.setVisibility(View.VISIBLE);

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    public void guessNumber(View view) {
        num = Integer.parseInt(edGuess.getText().toString());
        count++;
        edCount.setText(count + "");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
//        if (num == secret) {
//            react.setText("That is Right!!");
//            Toast.makeText(MainActivity.this, "You're smart!", Toast.LENGTH_LONG).show();
            if(count <= 3) {
//                com.setText("How genius you are!");
                word = "How genius you are!";
            } else if (3 < count && count < 6) {
//                com.setText("Great job!");
                word = "Great job!";
            } else {
                word = "Haha, poor you!";
//                com.setText("Haha, poor you!");
            }
    //        react.setText("You guess " + count + " times.");
    //        com.setVisibility(View.VISIBLE);
    //        edGuess.setVisibility(View.GONE);
    //        butt.setVisibility(View.GONE);
    //    } else if (num > 10 || num < 1) {
    //        react.setText("You're out of range...");
    //        Toast.makeText(MainActivity.this, "Please guess 1~10", Toast.LENGTH_LONG).show();
    //    } else {
//            react.setText("Wrong! Try again~");
            message = "That is Right!!";
            if (num < secret) {
//                Toast.makeText(MainActivity.this, "Guess a bigger one.", Toast.LENGTH_LONG).show();
                message = "Guess Wrong. Try again~";
                word = "Guess a bigger one.";
                listener = null;
            } else if (num > secret) {
//                Toast.makeText(MainActivity.this, "Guess a smaller one.", Toast.LENGTH_LONG).show();
                message = "Guess Wrong. Try again~";
                word = "Guess a smaller one.";
                listener = null;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(message)
                    .setMessage(word)
                    .setPositiveButton("OK", listener)
                    .show();
        }
    //}
    public void reset() {
        secret = new Random().nextInt(10) + 1;
        Log.d(TAG, "secret: " + secret);
        count = 0;
        edCount.setText(count + "");
        edGuess.setText("");
        react.setText("Trust your intuition.");
        Toast.makeText(MainActivity.this, "You've restart the game!", Toast.LENGTH_LONG).show();
        com.setVisibility(View.GONE);
        edGuess.setVisibility(View.VISIBLE);
        butt.setVisibility(View.VISIBLE);
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
