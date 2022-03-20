package com.example.texasholdem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Game State for our game, contains a list of players and other info
 * @author Xavier Santiago
 * @author Milton Nguy
 * @version 2.22.2022
 */
public class PokerGameState {
    ArrayList<Player> players;
    ArrayList<Card> dealerHand = new ArrayList<Card>();
    int timer;
    int round; //pre-flop, post-flop 1, post-flop 2, and final round
    int MAX_TIMER;
    int playerTurn;
    int blindBet;
    int currentBet; //easier to keep track of this than iterate through players every time we need it

    public PokerGameState(ArrayList<Player> players, int maxTimer, int blindBet) {
        this.players = (ArrayList<Player>) players.clone();
        this.blindBet = blindBet;
        MAX_TIMER = maxTimer; //TODO: change timer conditions in the future
        timer = MAX_TIMER;
        playerTurn = 0;
        round = 0;
        currentBet = 0;
    }

    //deep copy constructor, need to iterate through lists to make copies of all objects
    public PokerGameState(PokerGameState orig) {
        this.timer = orig.timer;
        this.round = orig.round;
        this.MAX_TIMER = orig.MAX_TIMER;
        this.playerTurn = orig.playerTurn;
        this.blindBet = orig.blindBet;
        this.currentBet = orig.currentBet;

        //the arraylists need deep copies so they don't contain references
        this.players = new ArrayList<Player>();
        for (Player each : orig.players) {
            players.add(new Player(each));
        }

        this.dealerHand = new ArrayList<Card>();
        for (Card each : orig.dealerHand) {
            dealerHand.add(new Card(each));
        }
    }

    // pass the player who is betting and the amount they want to bet
    // bet should be amount to add, not their total bet
    public boolean bet(Player player, int amount) {
        Player currentPlayer = players.get(playerTurn);

        //separated fail conditions for better readability
        if (currentPlayer.getName() != player.getName()) {
            return false;
        }
        //in theory this should never happen, since the minimum the game will let you bet is enough to stay in
        if (currentPlayer.getBet() + amount < currentBet) {
            return false;
        }

       currentPlayer.addBet(amount);

        if (currentPlayer.getBet() > currentBet) {
            currentBet = currentPlayer.getBet();
        }
        return true;
    }

    //only requirement to fold is it needs to be your turn
    public boolean fold(Player player) {
        Player currentPlayer = players.get(playerTurn);

        //needs to be your turn
        if (currentPlayer.getName() != player.getName()) {
            return false;
        }

        currentPlayer.setFold(true);
        return true;
    }

    //just sum up all bets
    public int getPool() {
        int pool = 0;
        for (Player each : players) {
            pool += each.getBet();
        }
        return pool;
    }

    @Override
    public String toString() {
        /*
        example output:

        Rules:
        - Timer Length: 30
        - Blind Bet: 100

        Current Game:
        - Round: Post-Flop 1
        - Pool: 500$
        - Turn: Jerry
        - Required bet: 200
        - Remaining time: 22

        Dealer's Hand:
        - Ace of Hearts
        - 3 of Spades
        - 10 of Hearts

        Players:
        Name: Jerry, balance: 2600, bet: 100, folded: false, hand: King of Hearts, 9 of Diamonds
        Name: Paul, balance: 800, bet: 150, folded: false, hand: 4 of clubs, 2 of Diamonds
        Name: Anna, balance: 1200, bet: 0, folded: true, hand: 7 of Hearts, 9 of Clubs
        Name: Mary, balance: 4400, bet: 200, folded: false, hand: Jack of Clubs, Ace of Diamonds
         */

        String message = "Rules:" +
                "\n- Timer Length: "+MAX_TIMER+
                "\n- Blind Bet: "+blindBet+
                "\n" +
                "\nCurrent Game:" +
                "\n- Round: ";
        message += Arrays.asList("Pre-Flop", "Post-Flop 1", "Post-Flop 2", "Final Round").get(round);

        message += "\n- Pool: "+getPool()+
                "\n- Turn: "+players.get(playerTurn)+
                "\n- Required Bet: "+currentBet+
                "\n- Remaining Time: "+timer+
                "\n"+
                "\nDealer's Hand:+\n";

        for (Card each : dealerHand) {
            message += "- "+each+"\n";
        }

        message += "\nPlayers:\n";

        for (Player each : players) {
            message += "- "+each+"\n";
        }

        return message;
    }
}
