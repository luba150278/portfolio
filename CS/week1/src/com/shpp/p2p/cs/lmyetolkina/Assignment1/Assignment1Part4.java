package com.shpp.p2p.cs.lmyetolkina.Assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot{
    /* Task: Karel needs to put the beepers in a checkerboard pattern.
        Initial data:
        1. The world has rectangular shape.
        2. The started position is the south-east corner.
        3. Karel should put one of the beepers in the first cell.
        =========================================================
        Algorithm:
        1. Used two methods:
        - firstMove() - Karl sequentially goes through all the rows except the last.
            He is facing either east or west while moving. He puts beepers in each second cell
            and makes it in a checkerboard pattern. This method is recursive.
            Karel stops to use recursion when reach the last row.
            If Karel appears at the start of a new row, he checks the ending of the world.
            He looks on the left or right sides depending on the direction.
        - finishMove() - Karl goes from start to end of row and put beepers in each second cell
     */
    public void run() throws Exception {

        firstMove(); //This method was describe before (see "Algorithm") and contains details bellow
        finishMove();//This method was describe before (see "Algorithm") and contains details bellow
    }

    private void firstMove() throws Exception{

        if (facingEast() ) {
            //This branch is performed if Karel is facing to the East
            if (noBeepersPresent()) {
                putBeeper();//Karel puts the first beeper into the first cell
            }

            while (frontIsClear()) {
                moveMovePutBeeper();//In this method Karel makes two steps and puts the beeper.
            }

            turnLeft();//For going to next row Karel turns left
            checkExistBeeper();//Karel checks to existing beeper. If the beeper exists he makes step
                                //otherwise he makes one step and puts beeper if cell is empty
            turnLeft(); //Karel turns left again
            if(rightIsClear())firstMove();// and repeats method. Before he checks reaching the last row

        } else {
            //This branch is performed if Karel is facing to the East
            while (frontIsClear()) {
                //Depending on whether there is a beeper in the cell or not, Karel selects the sequence of actions
                if (beepersPresent()) {
                    moveMovePutBeeper();//In this method Karel makes two steps and puts the beeper.
                } else {
                    movePutBeeperMove();//In this method Karel makes one step, puts the beeper and makes one more step.
                }
            }

            turnRight();//For going to next row Karel turns right
            checkExistBeeper();//Karel checks to existing beeper. If the beeper exists he makes step
                                //otherwise he makes one step and puts beeper if cell is empty
            turnRight(); //Karel turns right again
            if(leftIsClear()) firstMove(); //and repeats method. Before he checks reaching the last row
        }

    }

    private void finishMove() throws Exception {
        //Karl goes from start to end of the last row and put beepers in each second cell

        //Karel checks the first cell and chooses the action:
        // - If the cell is empty Karel makes one step, puts the beeper and makes one more step.
        //Karel uses "movePutBeeperMove()" method for it.
        // - Otherwise, Karel just makes one step
        if(noBeepersPresent()){
            movePutBeeperMove();
        }
        else{
            if(frontIsClear()){
                move();
            }
        }

        //Farther, Karel puts the beepers into each second cell while he has a free way.
        //He uses "repeatMovePutBeeperMove()" method for it.
        while(frontIsClear()){
            repeatMovePutBeeperMove();
        }
    }


    private void turnRight() throws Exception {//The method uses turnLeft() method 3 times to turn Karel to right
        for( int i = 0; i < 3; i++){
            turnLeft();
        }
    }

    private void checkExistBeeper()throws Exception {
        //Karel checks to existing beeper.
        // If the beeper exists he makes step otherwise he makes one step and puts beeper if cell is empty
        if (beepersPresent()) {
            //If the cell isn't empty and the path is free Karel makes one step
            if (frontIsClear()){
                move();
            }
        } else {
            //If the cell is empty and the path is free then Karel makes one step and puts one beeper if the cell is empty
            if (frontIsClear()){
                move();
                if (noBeepersPresent()) {
                    putBeeper();
                }
            }
        }
    }

    private void moveMovePutBeeper() throws Exception{
        //Karel makes two steps and puts beeper while he has free way.
        //Before making every step, Karel checks if his path is clear.
        if (frontIsClear()) {
            move();
        }

        if (frontIsClear()) {
            move();
            if (noBeepersPresent()) {//Karel puts the beeper only if the cell is free
                putBeeper();
            }
        }
    }

    private void movePutBeeperMove() throws Exception{
        if(frontIsClear()){
            repeatMovePutBeeperMove();//This part of this code repeats sometimes so this part has coding in the new method.
        }
    }

    private void repeatMovePutBeeperMove() throws Exception{
        //Karel makes one step, puts beeper if he has the empty cell, and makes one more step if he has a free way.
        move();
        if (noBeepersPresent()){
            putBeeper();
        }
        if(frontIsClear()){
            move();
        }
    }
}
