package com.cybertek.library.JavaPractice;

public class Switch {
    /*

Data types supported by switch statements include the following:
    *byte and Byte
    *short and Short
    *char and Character
    *int and Integer
    *String
    *enum values

    This is how it works:
•	The switch expression is evaluated once.
•	The value of the expression is compared with the values of each case.
•	If there is a match, the associated block of code is executed.
•	When Java reaches a break keyword, it breaks out of the switch block.
•	This will stop the execution of more code and case testing inside the block.
•	When a match is found, and the job is done, it's time for a break. There is no need for more testing.
•	The default keyword specifies some code to run if there is no case match.

     *break is used when you want to exit from the loop/switch statement,
     *while return is used to go back to the step where it was called or to stop further execution.


     -When using SWITCH statement let’s not forget to use break statement
     for each case statement, otherwise it will keep executing code for cases below.
     */


    public static void main(String[] args) {
        getUser("admin");
    }

    public static void getUser(String user) {
        switch (user) {
            case "librarian":
                System.out.println("Log in as a librarian");
                break;
            case "admin":
                System.out.println("Log in as an admin");
                break;
            case "student":
                System.out.println("Log in as a student");
                break;
            case "teacher":
                System.out.println("Log in as a teacher");
                break;
            default:
                System.out.println("No such user or misspelled");
        }
    }
}


