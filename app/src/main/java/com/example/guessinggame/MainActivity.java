package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private TextView pointsView;
    private int num1;
    private int num2;
    private int points;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        pointsView = findViewById(R.id.points);
        rand = new Random();
        SetButtonNums();
        points = 0;
    }

    public void SetButtonNums(){
        num1 = rand.nextInt(10);
        num2 = rand.nextInt(10);
        if(num1 == num2)
            SetButtonNums();
        button1.setText("" + num1);
        button2.setText("" + num2);
    }

    public void onClick(View v){
        if(v == button1){
            if(num1 > num2)
                rightAnswer();
            else
                wrongAnswer();
        }
        else{
            if(num2 > num1)
                rightAnswer();
            else
                wrongAnswer();
        }
        pointsView.setText("Points" + points);
        SetButtonNums();

    }

    public void wrongAnswer(){
        Toast.makeText(this, "WRONG! You lost a point", Toast.LENGTH_SHORT).show();
        points--;
    }

    public void rightAnswer(){
        Toast.makeText(this, "CONGRATS! You're not totally dumb", Toast.LENGTH_SHORT).show();
        points++;
    }
}
