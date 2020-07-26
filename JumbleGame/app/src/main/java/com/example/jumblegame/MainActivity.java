package com.example.jumblegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv_info;
    TextView tv_word;
    EditText et_guess;
    Button w_check,w_new;
    Random r;
    String currentWord;
    String[] dictionary={
            "one","two","three","four","five"
            ,"six","seven","eight","nine","ten","Java","javascript","python","language","Tree","Soil","Rain","Water","Land","Ocean","Dog","Eat","Rat","Toe","Computer","Laptop","mouse"
            ,"Keyboard","Screen","Exam","Book","Family","Friends","Animal","clouds"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info=(TextView) findViewById(R.id.tv_info);
        tv_word=(TextView) findViewById(R.id.tv_word);
        et_guess=(EditText) findViewById(R.id.et_guess);
        w_check=(Button) findViewById(R.id.w_check);
        w_new=(Button) findViewById(R.id.w_new);
        r=new Random();
        newGame();
        w_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Well done!!!");
                    w_check.setEnabled(false);
                    w_new.setEnabled(true);
                }
                else{
                    tv_info.setText("Try Again!!");

                }
            }
        });
        w_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }
    //shuffle algo
    private String shuffleWord(String word){
        List<String> letters= Arrays.asList(word.split("")) ;
        Collections.shuffle(letters);
        String shuffled="";
        for (String letter:letters){
            shuffled+=letter;
        }
        return shuffled;
    }
    private void newGame(){
        //get random word from the dictionary
        currentWord=dictionary[r.nextInt(dictionary.length)];
        //show the shuffled word
        tv_word.setText(shuffleWord(currentWord));
        //clear the text field
        et_guess.setText("");
        //switch buttons
        w_new.setEnabled(false);
        w_check.setEnabled(true);
    }
}