package com.example.potoki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Button button1, button2, button3, button4;
    String str1 = "", str2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread1 thread1 = new Thread1();
                thread1.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("Поток 1: " + str1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread (new Thread2());
                thread.start();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText("Поток 2: " + str2);
            }
        });

    }
    class Thread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(1000); //Приостанавливает поток на 1 секунду
                } catch(InterruptedException e) {}
                str1 = str1 + "1";
            }
        }
    }

    class Thread2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(1000); //Приостанавливает поток на 1 секунду
                } catch(InterruptedException e) {}
                str2 = str2 + "2";
            }
        }
    }
}