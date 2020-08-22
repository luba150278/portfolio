package com.shpp.p2p.cs.lmyetolkina.Assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot{
    /*
        Task: Karel needs to find the middle of the south wall.
        Initial data:
        1. Karel appears on the south-west corner and sees at the East.
        2. The world hasn't any beepers and walls.
        3. The world can be square or not. But the world has a height equal width at least.
        Assumptions:
        1.If the world has the odd count cells then Karel should put a beeper in the central cell.
        Otherwise, Karel should put a beeper in one of two central cells.
        2.No matter where Karl watches after finishing the task.
        =========================================================
        Algorithm:
        Karel goes from one edge of the south wall to the second edge and puts beepers into cells from edge to the middle.
        Karel puts one beeper in one cell. But Karl puts two beepers in the last empty cell. This empty cell is a central cell.
        Then Karel goes to the edge of the south wall and turns around.
        Further, Karel moves from beginning to end of the south wall and picks up one beeper from each cell.
        All cells will empty and central cell will have one beeper.

    */
    public void run() throws Exception {

        if(noBeepersPresent()){
            //Here Karel puts one beeper in the start cell if it is empty.
            putBeeper();
        }

        if(frontIsClear() ) {
            move();//Here Karel makes one step.
            KarelFirstLine();//This method describes bellow

            KarelNextLines();//This method describes bellow

            pickUpBeepers();//This method describes bellow
        }

    }

    private void KarelFirstLine() throws Exception{

        while(frontIsClear() ){//Here Karel goes to end of the south wall.
            move();
        }
        if(noBeepersPresent()){// He puts one beeper in the last cell if it is empty.
            putBeeper();
        }

        // He turns left twice. It's equal to turn around.
        turnLeft();
        turnLeft();
        move(); // Karel makes one step.
    }

    private void KarelNextLines() throws Exception{
        while(noBeepersPresent()) {
            if (noBeepersPresent()) {
                //Karel puts the one beeper in cell after making U-turn and one step
                putBeeper();
            }
            move();// Karel makes one step.
            while (noBeepersPresent()) {
                move();//Karel returns to the last filled cell.
            }

            turnLeft();//Karel turns left twice. It's equal to turn around.
            turnLeft();
            move();//Karel makes one step.

            if (beepersPresent()) {
             //Karel went to the central cell
                putBeeper();//Karel puts one more beeper in the central cell

                while (frontIsClear()) {
                    move();//Karel come back to one of two sides of the south wall
                }
                turnLeft();//Karel turns left twice. It's equal to turn around.
                turnLeft();
            }
        }
    }

    private void pickUpBeepers() throws Exception {
        //Here Karel picks up one beeper from each cell while he has free way
        while(frontIsClear()){
            if(beepersPresent()){
                pickBeeper();//This method lets Karel pick up one beeper;
            }
            move();//Karel makes one step.
        }

        if(beepersPresent()){
            pickBeeper();//Karel picks up the beeper from the last cell
        }
    }
}
