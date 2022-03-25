package com.example.texasholdem;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * IF YOU'RE READING THIS, YOU'RE IN THE OLD PROJECT. GO TO THE NEW ONE
 */

public class PokerHumanPlayer extends GameHumanPlayer implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    //TODO: move View.OnClickListener to GameMainActivity

    /**
     * A basic implementation of PokerHumanPlayer derived from GameFrameWork Diagram. Many things
     * are still incomplete and need further implementations.
     */
    private Button bet;
    private Button fold;
    private Player user;
    private SeekBar valueSB;
    private TextView valueTV;
    private int valueInt;


    //TEMPORARY BLANK CLASSES
    @Override
    public void onClick(View view) { }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) { }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
    //END TEMPORARY BLANK CLASSES

    /**
     *
     * Note from Xavier:
     * Had to edit this out temporarily as it was throwing errors
     *
    @Override
    public void onClick(View view) {
        //checks if id equals the bet action.
        Bet betAction = new Bet(this); //TODO: implement methods in GameHumanPlayer to make these possible
        Fold foldAction = new Fold(this);

        if (view.getId() == bet.getId()) {
            game.sendAction(betAction);

        }
        if (view.getId() == fold.getId()) {
            game.sendAction(foldAction);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.currBetSB) {
            valueTV.setText(i + " $");
            valueInt = i;
        }

        //TODO: GameFramework & surfaceView to invalidate
        //.invalidate()
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //TODO implement GameMainActivity
    public void setAsGui(GameMainActivity activity) {

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.activity_main);

        //Initialize the widget reference member variables
        this.bet = activity.findViewById(R.id.buttonBet);
        this.valueSB = activity.findViewById(R.id.currBetSB);
        this.valueTV = activity.findViewById(R.id.currBetTV);

        //Listen for button presses
        bet.setOnClickListener(this);
        fold.setOnClickListener(this);

    }
    */
}
