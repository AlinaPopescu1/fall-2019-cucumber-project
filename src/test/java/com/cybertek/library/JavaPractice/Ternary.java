package com.cybertek.library.JavaPractice;

public class Ternary {
    public static void main(String[] args) {
    //finraMultiBranch();
    finraTernary();
    }

    // Fizz Buzz || Fizz || Buzz
    // Write a method which prints out the numbers from 1 to 30
    // but for numbers which are a multiple of 3 (divisible), print "FIN" instead of the number,
    // and for numbers which are a multiple of 5 (divisible), print "RA" instead of the number.
    // For numbers which are a multiple of both 3 and 5 (divisible), print "FINRA" instead of the number.

    public static void finraMultiBranch() {
        String result = "";
        for (int i = 1; i <= 30; i++) {
            if (i % 5 == 0 && i % 3 == 0)
                result += "FINRA ";
            else if (i % 5 == 0)
                result += "RA ";
            else if (i % 3 == 0)
                result += "FIN ";
            else
                result += i + " ";
        }
        System.out.println(result);
    }

    /*
    Syntax ternary:
                         q mark            colon
    variable = (condition) ? expressionTrue : expressionFalse;
     */
    public static void finraTernary() {
        String result = "";
        for (int i = 1; i <= 30; i++) {
           // variable = (condition) ? expressionTrue : expressionFalse;
            result += (i % 5 == 0 && i % 3 == 0) ? "FINRA " : (i % 5 == 0) ? "RA " : (i % 3 == 0) ? "FIN " : i + " ";
        }
        System.out.println(result);
    }
}
