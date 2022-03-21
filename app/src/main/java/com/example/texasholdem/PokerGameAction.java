package com.example.texasholdem;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class PokerGameAction {

    // the player who generated the request
    private Player player;


    public PokerGameAction(Player p) {
        this.player = p;
    }

    //return player's action.
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }

}
