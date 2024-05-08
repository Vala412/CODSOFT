import java.util.*;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Grade Calculator");
        System.out.println("========================================");
        // System.out.println();
        System.out.println("Enter the marks of 5 subjects: ");
        
        int total = 0;

        for(int i=0; i<5; i++){

            System.out.println("Subject " + (i + 1) + ": ");
            int marks = sc.nextInt();
            
            if(marks < 0 || marks > 100){
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                i--;
                continue;
            }

            total += marks;
        }

        double percentage = (total / 500.0) * 100;

        System.out.println("========================================");
        System.out.println("Result");
        System.out.println("========================================");

        System.out.println("Total marks: " + total);
        System.out.println("Percentage: " + percentage);

        if (percentage >= 90) {
            System.out.println("Grade: A+");
        } else if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 70) {
            System.out.println("Grade: B");
        } else if (percentage >= 60) {
            System.out.println("Grade: C");
        } else if (percentage >= 50) {
            System.out.println("Grade: D");
        } else if (percentage >= 40) {
            System.out.println("Grade: E");
        } else if (percentage < 40) {
            System.out.println("Grade: F");
            
        }
        System.out.println("========================================");
    }
}