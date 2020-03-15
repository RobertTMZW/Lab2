package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Answer
                findViewById(R.id.textView2).setVisibility(View.VISIBLE);
                findViewById(R.id.textView).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Question
                findViewById(R.id.textView).setVisibility(View.VISIBLE);
                findViewById(R.id.textView2).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.addNewActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && data!= null) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String question= data.getExtras().getString("string1");
            String answer;
            answer = data.getExtras().getString("string2");




            ((TextView) findViewById(R.id.textView)).setText(question);
            ((TextView) findViewById(R.id.textView2)).setText(answer);

        }
    }


}
