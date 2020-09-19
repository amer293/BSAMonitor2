
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

    public static void main(String[] args) {
        // Define constant variables
        final double FAILING_GRADE = 5.4;
        // Points you get if you are below 5,5
        final int ZERO_POINTS = 0;
        // Total points you can get if you have all grades 5,5 or higher
        final int TOTAL_POINTS = 28;
        // min and max for input
        final double MIN = 1;
        final double MAX = 10;

        // Array of all classes
        String[] classes = { "Fasten Your Seatbelts", "Programming", "Business", "Personal Skills", "Project Skills",
                "Management & Organization", "Databases" };

        // Array of all points liked to classes
        int[] points = { 9, 4, 4, 2, 3, 2, 4 };

        // Arraylist of the grades for easier input
        List<Double> grades = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.printf("%n");

        // Loops trough all the classes till there are no more and add the grade
        for (String aClass : classes) {
            System.out.print(aClass + ": ");
            double grade = input.nextDouble();
            // Checks if grade input is not lower than 1.0 or bigger than 10.0
            while (grade < MIN || grade > MAX) {
                System.out.print(aClass + ": ");
                grade = input.nextDouble();
            }

            // Adds the grade to the ArrayList
            grades.add(grade);
        }

        // Convert ArrayList to normal array to be used later
        Double[] myGrades = new Double[grades.size()];
        myGrades = grades.toArray(myGrades);

        System.out.println();

        System.out.println("-------------------------------------------------------------------------------------");
        // Prints all classes + marks and points earned
        for (int i = 0; i < classes.length; i++) {
            System.out.printf(
                    "| Vak/Project : %25s | " + " Cijfer: %s | " + "Behaalde studiepunten: "
                            + (myGrades[i] > FAILING_GRADE ? points[i] : ZERO_POINTS) + "  | %n",
                    classes[i], myGrades[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------");

        // Total points earned
        int myPointsEarned = 0;

        // Calculate total poins earned by looping trough
        for (int i = 0; i < classes.length; i++) {
            if (myGrades[i] > FAILING_GRADE) {
                myPointsEarned = myPointsEarned + points[i];
            }
        }

        // Prints display total points and earned points
        System.out.println();
        System.out.printf("Totaal behaalde studiepunten: %s/%s %n", myPointsEarned, TOTAL_POINTS);

        // If the earned points are less than totalpoints then you failed
        if (myPointsEarned < TOTAL_POINTS) {
            System.out.println("PAS OP: Je ligt op schema voor een negatieve BSA");
        } else {
            System.out.println("GOED GEDAAN: Je ligt op schema voor een mooi jaar");
        }

        // Close scanner input to prevent Resource leak
        input.close();
    }
}
