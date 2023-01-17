package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean activeGame = true;
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // 0 = X
    // 1 = O;
    // 2 = Blank
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};


    @SuppressLint("SetTextI18n")
    public void playTap(View view){
        if(!activeGame){
            gameReset(view);
        }
        ImageView img = (ImageView) view;
        String winStr;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage] == 2) {       //Checking if any block is blank
            gameState[tappedImage] = activePlayer;
            //img.setTranslationY(-1000f);      //For animation we use translation in either direction
            if (activePlayer == 0) {
                TextView status = findViewById(R.id.status);
                activePlayer = 1;
                img.setImageResource(R.drawable.i3);   //Extracting the images of X & O
                status.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.i2);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");
            }
            //img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check if anybody has won
        for (int[] winposition:winPositions){
        if(gameState[winposition[0]] == gameState[winposition[1]] &&
                gameState[winposition[1]] == gameState[winposition[2]]
                 && gameState[winposition[0]] != 2){
            if(gameState[winposition[0]] == 0) {
                winStr = "X has Won";
            }
            else{
                winStr = "O has Won";
            }
            TextView status = findViewById(R.id.status);
            status.setText(winStr);
            activeGame = false;
        }
        }
    }
    public void gameReset(View view){
        activeGame = true;
        activePlayer = 0;
        for (int i = 0; i<gameState.length; i++){
            gameState[i] = 2;

        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}