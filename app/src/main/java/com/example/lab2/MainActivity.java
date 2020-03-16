package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

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

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.textView)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.textView2)).setText(allFlashcards.get(0).getAnswer());
        }
        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // advance our pointer index so we can show the next card
                currentCardDisplayedIndex++;

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }

                // set the question and answer TextViews with data from the database
                ((TextView) findViewById(R.id.textView)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.textView2)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
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
            flashcardDatabase.insertCard(new Flashcard(question, answer));


            }

        }

    int currentCardDisplayedIndex = 0;
        FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;

}

