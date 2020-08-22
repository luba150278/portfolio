package com.shpp.p2p.cs.lmyetolkina.assignment3;

import com.shpp.cs.a.console.TextProgram;
import acm.util.*;

public class Assignment3Part5 extends TextProgram {

    /**
     * Use "coin_toss" method and play in "Saint Petersburg game"
     */
    public void run() {
        coinToss();
    }

    /**The first bet of the first player is 1 dollar always.
     * The second player tosses the coin.
     * If got head the first player doubles the bet.
     * If got tail the second player get all bets.
     * The game repeats if the player has less than $ 20.
     */
    private void coinToss(){
        int bet = 1;
        int sumOfWin = 0;
        int gameCounter = 0;
        String message = "";
        while (sumOfWin < 20) {
            /*Use random generator to get "head or tail" 0 - head; 1 - tail*/
            int head = RandomGenerator.getInstance().nextInt(0, 1);

            if (head == 0) {
                bet = bet * 2;
            } else {
                message += "\nThis game, you earned $" + bet;
                sumOfWin += bet;

                if (sumOfWin < 20) {
                    bet = 1;

                }
                message += "\nYour total is $" + sumOfWin;
                gameCounter++;
            }
        }
        message += "\nIt took " + gameCounter + " games to earn $20";

        println(message);
    }
}
