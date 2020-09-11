package com.example.lab1_ii_game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    TextView pointView;
    int randVal1, randCal2, max;
    int point = 0;

    void Random(){
        randVal1 = (int) (Math.random() * 10 + 0);
        randCal2 = (int) (Math.random() * 10 + 0);

        while (randVal1 == randCal2) {
            randVal1 = (int) (Math.random() * 10 + 0);

        }
        btn1.setText(randVal1 + "");
        btn2.setText(randCal2 + "");

        max = Math.max(randVal1, randCal2);
    }

    void isGameOver(){
        if(point<0){
            Toast.makeText(MainActivity.this,"Game Over!", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        pointView = (TextView) findViewById(R.id.pointView);
        Random();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(randVal1 == max){
                    point++;
                }else
                {
                    point--;
                }
                pointView.setText(String.valueOf(point));
                isGameOver();
                Random();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(randCal2 == max){
                    point++;
                }else
                {
                    point--;
                }
                pointView.setText(String.valueOf(point));
                isGameOver();
                Random();
            }
        });
    }
}
