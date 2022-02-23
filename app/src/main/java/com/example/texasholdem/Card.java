package com.example.texasholdem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Card class containing a value and suit for a card
 * has compressed card names, ex: 4H or AC
 * has full card names, ex: 4 of hearts or Ace of Spades
 *
 * @author Xavier Santiago
 * @version 22.02.2022
 */
public class Card {
    public Character suit;
    public int value;
    public String shortName;
    public String longName;
    private ArrayList<String> values = new ArrayList<String>
            (Arrays.asList(null,null,"2","3","4","5","6","7","8","9","T","J","Q","K","A"));

    // ex: Card(4, 'S') for 4 of spades
    public Card(int value, Character suit) {
        this.suit = Character.toUpperCase(suit); //standardize suit as upper case
        this.value = value;
        this.shortName = values.get(value)+suit.toString();
        longName = getLongName();
    }

    // ex: Card("4S") for 4 of spades
    public Card(String shortName) {
        this.shortName = shortName;
        value = values.indexOf(shortName.substring(0,1));
        this.suit = Character.toUpperCase(shortName.toCharArray()[1]);
        longName = getLongName();
    }

    // copy constructor, no variables require deep copies since we just have primitives and strings
    public Card(Card orig) {
        suit = orig.suit;
        value = orig.value;
        shortName = orig.shortName;
        longName = orig.longName;
    }

    // already stored as longName
    @Override
    public String toString() {
        return longName;
    }

    // this needs to be run when the card is created and any time something is changed
    private String getLongName() {
        String name = "";

        if (value <= 10) { //if it's a number card we can just use it's value as a string
            name += value;
        } else { //otherwise, we can check which face card it is based on value
            name += Arrays.asList("King", "Queen", "King", "Ace").get(value-11);
        }

        name += " of ";

        //check for suit name
        if (suit == 'H') {name += "Hearts";}
        else if (suit == 'D') {name += "Diamonds";}
        else if (suit == 'S') {name += "Spades";}
        else if (suit == 'C') {name += "Clubs";}
        else {name += "Invalid Suit";}

        return name;
    }
}
