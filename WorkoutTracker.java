import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutTracker {
    private int sets;
    private String name;
    private final List<Integer> weights;
    private final List<Integer> reps;

    public WorkoutTracker() {
        this.sets = 0;
        this.name = "";
        this.weights = new ArrayList<>();
        this.reps = new ArrayList<>();
    }

    public void addWorkout(Scanner scanner) {
        System.out.print("Enter exercise name: ");
        this.name = scanner.nextLine().trim(); // supports multi-word names

        this.sets = readPositiveInt(scanner, "Enter number of sets: ");

        for (int i = 1; i <= this.sets; i++) {
            int rep = readPositiveInt(scanner, "Enter reps for set " + i + ": ");
            int weight = readNonNegativeInt(scanner, "Enter weight (lbs) for set " + i + ": ");
            this.reps.add(rep);
            this.weights.add(weight);
        }
    }

    public void printLog() {
        System.out.println("Exercise Name: " + this.name);
        System.out.println("Number of sets: " + this.sets);
        for (int i = 0; i < this.sets; i++) {
            System.out.println("Set " + (i + 1) + ": " + reps.get(i) + " reps at " + weights.get(i) + " lbs");
        }
    }

    // --- Input helper methods ---
    private int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val > 0) return val;
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }

    private int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val >= 0) return val;
                System.out.println("Please enter zero or a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }
}
