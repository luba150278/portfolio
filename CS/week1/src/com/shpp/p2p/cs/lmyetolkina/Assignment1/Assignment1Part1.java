package com.shpp.p2p.cs.lmyetolkina.Assignment1;
import com.shpp.karel.KarelTheRobot;

// In this task, Karel should find a door, pick up a newspaper and come back to start position.

public class Assignment1Part1 extends KarelTheRobot{

    public void run() throws Exception {
        goToBeep();//Karel goes to the Newspaper
        makeBeep();//Karel picks up the Newspaper
        comeBackToStart();//Karel comes back to start position
    }

    private void goToBeep() throws Exception {//Karel go to the Newspaper

        while(frontIsClear()){//Karel moves while path is clear
            move(); //This method helps Karel to make one step. This is a method from the inner library.
        }

        turnRight();//This method helps Karel to turn right. The code is shown below.

        while(leftIsBlocked()){//Karel moves while doesn't see a door
            move();
        }

        turnLeft(); //This method helps Karel to turn left. This is a method from the inner library.
        move(); //Karel makes two steps and goes out of his house
        move();
    }

    private void turnRight() throws Exception {//The method uses turnLeft() method 3 times to turn Karel to right
        for( int i = 0; i < 3; i++){
            turnLeft();
        }
    }

    private void makeBeep() throws Exception {//Karel pick up the Newspaper
        pickBeeper(); //This method helps Karel to pick up a newspaper (newspaper = beeper). This is a method from the inner library.
    }

    private void comeBackToStart() throws Exception {//Karel come back to start position

        turnLeft();  //Karel turns left twice. It's equal to turn around.
        turnLeft();

        while(frontIsClear()){//Karel moves while path is clear
            move();
        }
        turnRight();//
        while(frontIsClear()){//Karel moves while path is clear
            move();
        }
        //Karel comes back to the start position!
    }
}
