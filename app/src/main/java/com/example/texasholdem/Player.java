package com.example.texasholdem;

import android.graphics.Bitmap;

/**
 * Player class containing all variables we need
 * @author Xavier Santiago
 * @version 2.22.2022
 */
public class Player {
    String name;
    int balance;
    int bet = 0;
    Bitmap picture;
    Card[] hand = new Card[2];
    boolean folded = false;

    // simple constructor
    public Player(String name, int balance, Bitmap picture) {
        this.name = name;
        this.balance = balance;
        this.picture = picture;
    }

    // deep copy constructor
    public Player(Player orig) {
        name = orig.name;
        balance = orig.balance;
        picture = orig.picture;
        bet = orig.bet;
        folded = orig.folded;

        //the array is the only thing we really need to do a deep copy of
        hand = orig.hand.clone();
    }

    @Override
    public String toString() {
        return "Name: "+name+", balance: "+balance+", bet: "+bet+", folded: "+folded+", hand: "+hand[0]+", "+hand[1];
    }
}
