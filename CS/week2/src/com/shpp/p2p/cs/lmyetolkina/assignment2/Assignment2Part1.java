package com.shpp.p2p.cs.lmyetolkina.assignment2;

import com.shpp.cs.a.console.TextProgram;

/*Task: to find the roots of the quadratic equation.
The equation is represented by the formula: ax2+bx+c=0
The coefficients are set by the user via the console.
We should check "a" coefficient. It shouldn't be equal to 0.
Next, we find the discriminant (d) of the equation. d=b^2-4*a*c
The discriminant can be less than zero, equal to zero or greater than zero.
In the first case, the equation has no real roots.
In the second case the equation has one root: x=-b/(a*2)
In the third case the equation has two roots: x1=-b+sqrt(d)/(2*a); x2=-b-sqrt(d)/(2*a)
 */
public class Assignment2Part1 extends TextProgram {
    //Quadratic coefficients
    Double a;
    Double b;
    Double c;
    double discr;//quadratic discriminant
    double x1;//the first root of the quadratic equation
    double x2;//the second root of the quadratic equation

    //Find roots of the quadratic equation
    public void run() {
        if (Ask_coefficients()) { //Ask user to enter quadratic coefficients
            Find_roots();
        }
    }

    boolean Ask_coefficients() {
        //We ask the user about value of the coefficients a, b, c
        a = readDouble("Please, enter a:");

        //Check coefficient <a>. It should not be equal to 0.
        if (a == 0) {
            println("For <a> quadratic equation, the coefficient a shouldn't be equal 0");
            return false;
        }
        b = readDouble("Please, enter b:");
        c = readDouble("Please, enter c:");
        return true;
    }

    void Find_roots() {
        double scale = Math.pow(10, 1);//This variable is needed to round the result to 1 decimal place.
        discr = b * b - a * c * 4;//The formula of discriminant
        //Depending on the value of the discriminant, we choose the method of finding the roots of the equation
        if (discr < 0) {
            println("There are no real roots");
        } else if (discr == 0) {
            x1 = -b / (a * 2);
            x1 = Math.round(x1 * scale) / scale;//Here we round the number
            println("There is one root:" + x1);
        } else {
            x1 = (-b + Math.sqrt(discr)) / (a * 2);
            x1 = Math.round(x1 * scale) / scale;//Here we round the number
            x2 = (-b - Math.sqrt(discr)) / (a * 2);
            x2 = Math.round(x2 * scale) / scale;//Here we round the number
            println("There is two root:" + x1 + " and " + x2);
        }
    }
}
