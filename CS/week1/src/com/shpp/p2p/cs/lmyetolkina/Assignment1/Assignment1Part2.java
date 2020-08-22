package com.shpp.p2p.cs.lmyetolkina.Assignment1;
import com.shpp.karel.KarelTheRobot;

/*
 * In this task, Karel should build columns in each fourth cell starting from the first cell.
 * Karel should put only one beeper in empty cells of the column and should ignore not empty cells.
 *
 */
public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {

        while(frontIsClear()) {//Karel moves while he won't fill all columns by beepers
            if (noBeepersPresent()) {
                putBeeper();//This method lets Karel put beeper in the cell. This is a method from the inner library.
            }
            repeatPartOfPath();//The method is coding the repeat part of Karel's path.
        }

        //If world has one cell in width Karel puts one beeper in the first cell
        if (noBeepersPresent()) {
            putBeeper();
        }

        //Karl moves on the last part of the path
            turnLeft();//This method helps Karel to turn left. This is a method from the inner library.
            moveAndPutBeeper();//The method lets Karel to move by cells and put the beeper in empty cells.The code is shown below.
    }

    //The method is coding the repeat part of Karel's path.
    private void repeatPartOfPath() throws Exception{
        if (leftIsClear()){
            //Karel makes this branch if the wall doesn't fill all cells of the column

            turnLeft();
            moveAndPutBeeper();//The method lets Karel to move by cells and put the beeper in empty cells.The code is shown below.
            turnRight(); //This method helps Karel to turn right. The code is shown below.
            threeSteps();//The method lets Karel move between the walls. It's three-step according to task conditions.
                         // The code is shown below.
            turnRight();

            //Karl moves while has a free way.
            while (frontIsClear()) {
                move();//This method lets Karel move step by step. This is a method from the inner library.
            }
            turnLeft();
        }
        else{
            //Karel makes this branch if the wall fills all cells of the column
            if(frontIsClear()){
                threeSteps();
            }
        }

        //Karl makes one step and appears under wall
        if(frontIsClear()){
            move();
        }
    }

    private void turnRight() throws Exception {
    //The method uses turnLeft() method 3 times to turn Karel to right
        for( int i = 0; i < 3; i++){
            turnLeft();
        }
    }

    private void threeSteps()throws Exception {
    //The method repeat move() method 4 times. Karl does the forth steps or less if his path doesn't free.
        for(int i = 0; i < 3; i++){
            if(frontIsClear()){
                move();
            }
        }
    }

    private void moveAndPutBeeper() throws Exception{
    //Karl moves from cells and puts the beeper in empty cells. He goes while has a free path.
            while (frontIsClear()) {
                move();

                if (noBeepersPresent()) {
                    putBeeper();
                }
            }
    }

}
