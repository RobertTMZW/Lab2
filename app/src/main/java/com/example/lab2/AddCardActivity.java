package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivityForResult(intent, 100);
                ((EditText) findViewById(R.id.editText)).getText().toString();
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String strQue= ((EditText) findViewById(R.id.editText)).getText().toString();
                String strAns= ((EditText) findViewById(R.id.editText2)).getText().toString();
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("string1",strQue); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("string2", strAns); // puts another string into the Intent, with the key as 'string2

                setResult(RESULT_OK, data); // set result code and bundle data for response

                finish(); // closes this activity and pass data to the original activity that launched this activity



            }
        });

    }
}
