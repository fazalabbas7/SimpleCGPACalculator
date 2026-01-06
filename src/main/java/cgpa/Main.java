package cgpa;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  ArrayList<Subject> subjects = new ArrayList<>();
        char choice;
        System.out.println("===== Simple CGPA Calculator =====\n");
        // do-while loop subject entry
        do {
            System.out.print("Enter Subject Name: ");
            String subjectName = input.next();
            System.out.print("Enter Grade Points (e.g. 3.2): ");
            double gradePoint = input.nextDouble();
            System.out.print("Enter Credit Hours: ");
            int creditHours = input.nextInt();
            subjects.add(new Subject(subjectName, gradePoint, creditHours));
            System.out.print("Add another subject? (y/n): ");
            choice = input.next().charAt(0);
            System.out.println();
        } while (choice == 'y' || choice == 'Y');
        // CGPA Calculation
        double totalPoints = 0;
        int totalCredits = 0;
        int i = 0;
        // while loop
        while (i < subjects.size()) {
            totalPoints = totalPoints + subjects.get(i).getTotalPoints();
            totalCredits = totalCredits + subjects.get(i).getCreditHours();
            i++;
        }
        double cgpa = totalPoints / totalCredits;
        System.out.println(" Your CGPA is: " + cgpa);
    }
}   //New class added code