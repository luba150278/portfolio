package com.shpp.p2p.cs.lmyetolkina.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {
    /*Minimum minutes per day for saving cardiovascular health*/
    private static final double MINS_PER_DAY_HEALTH = 30;
    /*Minimum days per week for saving cardiovascular health*/
    private static final int DAYS_PER_WEEK_HEALTH = 5;
    /*Minimum minutes per day for lower blood pressure*/
    private static final double MINS_PER_DAY_PRESS = 40;
    /*Minimum days per week for lower blood pressure*/
    private static final int DAYS_PER_WEEK_PRESS = 3;
    /*Sum of days with enough sports activity to save health*/
    private int checkDaysHealth = 0;
    /*Sum of days with enough sports activity to save normal pressure*/
    private int checkDaysPressureLevel = 0;
    /*Review string*/
    private String review = "Cardiovascular health:\n";
    /**
     * The method asks the user about sport times and reviews his health and pressure
     **/
    public void run() {
            /*Ask the user about sport times and get sum week result*/
            if(AskUser()) {
                /*Check the week results and print message. Use function "check_function(...) for repeat part of code"*/
                review += CheckFunction(checkDaysHealth, DAYS_PER_WEEK_HEALTH, "for cardiovascular health.");
                review += "\nBlood pressure:\n" + CheckFunction(checkDaysPressureLevel, DAYS_PER_WEEK_PRESS,
                        "to keep a low blood pressure.");
            }
            println(review);
    }

    /**
     * Ask user about minutes per day, check it and save sum results
     */
    private boolean AskUser(){
        for (int i = 1; i <= 7; i++) {
            double minutes = readDouble("How many minutes did you do on day " + i + "?");
            if(minutes < 0 ){
                review = "Please, use only positive number value or 0. Try again.";
                return false;
            }
            if (minutes >= MINS_PER_DAY_PRESS) {
                checkDaysHealth++;
                checkDaysPressureLevel++;
            } else if (minutes >= MINS_PER_DAY_HEALTH && minutes < MINS_PER_DAY_PRESS) {
                checkDaysHealth++;
            }
        }
        return true;
    }

    /**
     * Return result string after checking data
     * @param checkDays - count of training days
     * @param minimumDays - minimum days needed to good health
     * @param cardioOrPressureCheckString - finish of review string. Change value depending on that checking:
     *                                    cardiovascular health or pressure level
     * @return review string
     */
    private String CheckFunction(int checkDays, int minimumDays, String cardioOrPressureCheckString) {
        String resultString = "";
        if (checkDays>= minimumDays) {
            resultString += "Great job! You've done enough exercise " + cardioOrPressureCheckString;
        } else {
            resultString += "You needed to train hard for at least " + (minimumDays - checkDays) + " more day(s) a week!";
        }
        return resultString;
    }
}
