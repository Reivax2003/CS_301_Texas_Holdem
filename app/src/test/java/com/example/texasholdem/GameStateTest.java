package com.example.texasholdem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * IF YOU'RE READING THIS, YOU'RE IN THE OLD PROJECT. GO TO THE NEW ONE
 */
public class GameStateTest {
    @Test
    public void testFold() {
        ArrayList<Player> players = new ArrayList<Player>();

        //set up players
        Player p1 = new Player("Joe", 1000);
        players.add(p1);
        Player p2 = new Player("Mary", 2000);
        players.add(p2);
        Player p3 = new Player("Bill", 3000);
        players.add(p3);

        PokerGameState gState = new PokerGameState(players, 60, 100);

        //it is player 1's turn by default so they should be able to fold
        assertTrue(gState.fold(p1)); //gamestate thinks action was successful
        assertTrue(p1.isFolded()); //check that action was successful

        //turn doesn't increase unless we tell it so it is still player 1s turn
        assertFalse(gState.fold(p2)); //gamestate should not take the action
        assertFalse(p2.isFolded()); //player's state should n ot be updated
    }
    @Test
    public void testGetPool() {
        ArrayList<Player> players = new ArrayList<Player>();

        //set up players
        Player p1 = new Player("Joe", 1000);
        players.add(p1);
        Player p2 = new Player("Mary", 2000);
        players.add(p2);
        Player p3 = new Player("Bill", 3000);
        players.add(p3);

        PokerGameState gState = new PokerGameState(players, 60, 100);

        assertEquals(0, gState.getPool()); //should start at 0 since no bets

        p1.addBet(100);
        p2.addBet(300);
        p3.addBet(500);

        assertEquals(900, gState.getPool()); //should return 900, sum of bets

        gState.fold(p1);
        assertEquals(900, gState.getPool()); //should still return 900 even though someone folded
    }
    @Test
    public void toStringTest() {
        ArrayList<Player> players = new ArrayList<Player>();

        //set up players
        Player p1 = new Player("Joe", 1000);
        players.add(p1);
        Player p2 = new Player("Mary", 2000);
        players.add(p2);
        Player p3 = new Player("Bill", 3000);
        players.add(p3);

        PokerGameState gState = new PokerGameState(players, 60, 100);

        p1.setHand(new Card[]{new Card("AH"), new Card("2S")});
        p2.setHand(new Card[]{new Card("KC"), new Card("TS")});
        p3.setHand(new Card[]{new Card("6S"), new Card("8D")});

        p2.setFold(true);

        p1.addBet(100);
        p3.addBet(200);

        gState.currentBet = 200;
        gState.timer = 20;

        gState.dealerHand = new ArrayList<Card>();
        gState.dealerHand.add(new Card("4D"));
        gState.dealerHand.add(new Card("3C"));
        gState.dealerHand.add(new Card("AH"));

        gState.round = 1;

        String message =
                "Rules:\n" +
                "- Timer Length: 60\n" +
                "- Blind Bet: 100\n" +
                "\n" +
                "Current Game:\n" +
                "- Round: Post-Flop 1\n" +
                "- Pool: 300\n" +
                "- Turn: Joe\n" +
                "- Required Bet: 200\n" +
                "- Remaining Time: 20\n" +
                "\n" +
                "Dealer's Hand:\n" +
                "- 4 of Diamonds\n" +
                "- 3 of Clubs\n" +
                "- Ace of Hearts\n" +
                "\n" +
                "Players:\n" +
                "- Name: Joe, balance: 1000, bet: 100, folded: false, hand: Ace of Hearts, 2 of Spades\n" +
                "- Name: Mary, balance: 2000, bet: 0, folded: true, hand: King of Clubs, 10 of Spades\n" +
                "- Name: Bill, balance: 3000, bet: 200, folded: false, hand: 6 of Spades, 8 of Diamonds\n";
        //the last \n is supposed to be there, it makes the code easier

        assertEquals(message, gState.toString());
    }
    @Test
    public void BetBalanceTest() {
        //this will test the functionality of the bet action when it is called by
        //players, and it will also check whether bet gets removed from user's balance.
        //In this example we will be ignoring card hands and just create a bet action.

        ArrayList<Player> players = new ArrayList<Player>();

        //set up players
        Player p1 = new Player("Joe", 1000);
        players.add(p1);
        Player p2 = new Player("Mary", 2000);
        players.add(p2);
        Player p3 = new Player("Bill", 3000);
        players.add(p3);

        PokerGameState gState = new PokerGameState(players, 60, 0);

        //make players create action
        p1.addBet(400);
        p2.addBet(100);

        //should return 600 given that the first user made a bet of 400.
        assertEquals(600, p1.getBalance());

        //should return 1900 given that the first user made a bet of 100.
        assertEquals(1900,p2.getBalance());

    }


}
