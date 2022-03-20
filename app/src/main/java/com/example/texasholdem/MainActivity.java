/**
 * Texas HoldEm.
 *
 * @author  Thomas Kone, Xavier Santiago, Milton Nguy, Kevin Nguyen
 * @version 1.0
 */

package com.example.texasholdem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* lines 31-37 are part of the Bet class. See info there.
         *
         *
         *
         */


        Button bet = findViewById(R.id.buttonBet);
        SeekBar betSB = findViewById(R.id.currBet);
        Player user = new Player("Milton", 1000);
        TextView betTV = findViewById(R.id.currBetVal);

        Bet betAction = new Bet(bet, betSB, user, betTV);
        bet.setOnClickListener(betAction);

    }
}