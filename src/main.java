/**
 /@Title: BSAMonitor V2
 /@Author: Amer Zahirovic
 /@Group: IS109 SQUAD D
 /@Description: Een applicatie die je voortgang van bsa kan bijhouden en je ziet of je op schema bent of niet met punten
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        //Define constant variables
        final double FAILING_GRADE = 5.4;
        //Points you get if you are below 5,5
        final int ZERO_POINTS = 0;
        //Total points you can get if you have all grades 5,5 or higher
        final int TOTAL_POINTS = 28;
        //min and max for input
        final double MIN = 1;
        final double MAX = 10;

        //Array of all classes
        String[] classes = {
                "Fasten Your Seatbelts",
                "Programming",
                "Business",
                "Personal Skills",
                "Project Skills",
                "Management & Organization",
                "Databases"
        };

        //Array of all points liked to classes
        int[] points = {
                12,
                3,
                2,
                2,
                3,
                2,
                4
        };

        //Arraylist of the grades for easier input
        List<Double> grades = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.printf("%n");

        //Loops trough all the classes till there are no more and add the grade
        for (String aClass : classes) {
            System.out.printf(aClass  + " (1 - 10): ");
            double grade = input.nextDouble();

            while(grade < MIN || grade > MAX)
            {
                System.out.printf(aClass + " (1 - 10): ");
                grade = input.nextDouble();
            }
            //Adds the grade to the ArrayList
            grades.add(grade);
        }

        //Convert ArrayList to normal array to be used later
        Double[] myGrades = new Double[grades.size()];
        myGrades = grades.toArray(myGrades);

        System.out.printf("%n");

        //Prints all classes + marks and points earned
        for (int i = 0; i < classes.length; i++)
        {
            System.out.printf("Vak/Project : " + classes[i] + " Cijfer: " + myGrades[i] +
                    " Behaalde studiepunten: " + (myGrades[i] > FAILING_GRADE ? points[i] : ZERO_POINTS) + "%n");
        }

        //Total points earned
        int myPointsEarned = 0;

        //Calculate total poins earned by looping trough
        for (int i = 0; i < classes.length; i++)
        {
            if(myGrades[i] > FAILING_GRADE)
            {
                myPointsEarned = myPointsEarned + points[i];
            }
        }

        //Prints display total points and earned points
        System.out.printf("%n");
        System.out.printf("Totaal behaalde studiepunten: "+ myPointsEarned + "/" + TOTAL_POINTS + "%n");

        //If the earned points are less than totalpoints then you failed
        if(myPointsEarned < TOTAL_POINTS)
        {
            System.out.printf("PAS OP: Je ligt op schema voor een negatieve BSA %n");
        }else {
            System.out.printf("GOEDZO: Je ligt op schema voor een mooi jaar %n");
        }

    }
}
