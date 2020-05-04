package com.cybertek.library.JavaPractice;

public class NestedIfElse {
    public static void main(String[] args) {
        mySalary(100000, true);
    }

        public static void mySalary(int salary, boolean position){
        if (salary > 85000) {
            System.out.println("I worked hard for this salary");
            if (position) {
                System.out.println("I am a SDET");
            } else {
                System.out.println("I am a Scrum Master");
            }
        }else{
            System.out.println("It's OK for a start");
        }
    }
}
