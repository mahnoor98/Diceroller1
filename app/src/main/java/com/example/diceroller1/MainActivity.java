package com.example.diceroller1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int point = 0;
    private TextView countplaced;
    private TextView countview;
    private EditText userinput;
    private TextView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userinput = (EditText) findViewById(R.id.userinput);
        countplaced = (TextView) findViewById(R.id.point);
        countview = (TextView) findViewById(R.id.cview);
        listview = (TextView) findViewById(R.id.ls);

        FloatingActionButton fab = findViewById(R.id.fab);
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

    public void on_butoon_click(View view){

        TextView tv = this.findViewById(R.id.numberTextView);

        Random r = new Random();
        int num = r.nextInt(6)+1;

        tv.setText(Integer.toString(num));

        int n = Integer.parseInt(userinput.getText().toString());

        if (n < 1 || n > 6) {
            Toast.makeText(this, "Invalid input, must be between 1-6 range", Toast.LENGTH_SHORT).show();
        } else if (n == num) {
            Toast.makeText(this, "Congratulations ! Numbers match XD", Toast.LENGTH_SHORT).show();
            point = point + 1;
            countplaced.setText("Score: " +Integer.toString(point));
        }
    }

    public void on_butoon_click2(View view){

        ArrayList<String> list = new ArrayList<>();
        list.add("1) If you could go anywhere in the world, where would you go?");
        list.add("2) If you were stranded on a desert island, what three things would you want to take with you?");
        list.add("3) If you could eat only one food for the rest of your life, what would that be?");
        list.add("4) If you won a million dollars, what is the first thing you would buy?");
        list.add("5) If you could spaned the day with one fictional character, who would it be?");
        list.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random random = new Random();

        int numberOfItems = 1;

        for (int i = 0; i < numberOfItems; i++) {

            int randomIndex = random.nextInt(list.size());
            String Element = list.get(randomIndex);
            listview.setText(Element);
        }
    }

}
