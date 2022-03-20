package com.example.texasholdem;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Bet implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Button action;
    private Player user;
    private SeekBar valueSB;
    private TextView valueTV;
    private int valueInt;

    public Bet(Button x, SeekBar v, Player y, TextView a) {
        this.action = x;
        this.valueSB = v;
        this.user = y;
        this.valueTV = a;
    }
    @Override
    public void onClick(View view) {

        if (view.getId() == action.getId()) {
            user.addBet(valueInt);

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.currBet) {
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
}
