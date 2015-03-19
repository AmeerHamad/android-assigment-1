package com.example.ameer.guessrandomnumber;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    private int RandomNum;
   private EditText a1 ;
    Button checkbutton;
    Button play;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (EditText) findViewById(R.id.UserNumber);
        Random R1 = new Random();
        RandomNum = R1.nextInt(1000);

        checkbutton = (Button) findViewById(R.id.checkbutton);
        play = (Button) findViewById(R.id.play);

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int userNumber;
                    userNumber = Integer.parseInt(a1.getText().toString());
                    check(userNumber, RandomNum);


            }
        });

      play.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Random R1 = new Random();
              RandomNum = R1.nextInt(1000);
              toast();

          }
      });

    }

    public void check(int userNumber,int RandomNum){
        if (userNumber > 1000 || userNumber < 0) {
            flag = false;
            Toast.makeText(this, "Ooops!Your numbe Should only be between 0 and 1000", Toast.LENGTH_LONG).show();
            userNumber = Integer.parseInt(a1.getText().toString());
        }

        if (userNumber == RandomNum) {
            Toast.makeText(this, "Good!You gussed it correctly", Toast.LENGTH_LONG).show();
        } else if ((int) Math.abs(userNumber - RandomNum) <= 5) {
            Toast.makeText(this, "Almost!SO CLOSE Dude!", Toast.LENGTH_LONG).show();
        } else if (RandomNum > userNumber) {
            Toast.makeText(this, "Wrong Nmber!The correct Number is Greater!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Wrong Number!The correct Number is Smaller!", Toast.LENGTH_LONG).show();
        }

    }
public void toast(){
    Toast.makeText(this, "Please enter a new number", Toast.LENGTH_LONG).show();
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
