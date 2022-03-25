package com.example.texasholdem;

import android.graphics.Bitmap;

/**
 * IF YOU'RE READING THIS, YOU'RE IN THE OLD PROJECT. GO TO THE NEW ONE
 */
public class Player {
    private String name;
    private int balance;
    private int bet = 0;
    private Bitmap picture;
    private Card[] hand = new Card[2];
    private boolean folded = false;

    // simple constructor
    public Player(String name, int balance) {//, Bitmap picture) {
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

    public String getName(){ return name;}

    public int getBet(){ return bet;}
    public void addBet(int newBet){

        bet += newBet;
        changeBalance(getBet()); //modified method for GameStateTest, may need to modify later
    }

    public void setFold(boolean foldStatus){ folded = foldStatus;}
    public boolean isFolded() {return folded; }

    public Card[] getHand() {return hand.clone();}
    public void setHand(Card[] hand) {this.hand = hand;}
    public void giveCard(Card card, int index) { hand[index] = card;}

    /**
     * New methods: getBalance() and changeBalance()
     * @return
     */
    public int getBalance() { return this.balance; }

    public void changeBalance(int betAmount) {
        this.balance -= betAmount;
    }


    @Override
    public String toString() {
        return "Name: "+name+", balance: "+balance+", bet: "+bet+", folded: "+folded+", hand: "+hand[0]+", "+hand[1];
    }
}
