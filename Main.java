import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<WorkoutTracker> history = new ArrayList<>();

        while (true) {
            System.out.println("\nRepTrack");
            System.out.println("""
                1. Track Workout
                2. View History
                3. Quit""");
            System.out.print("Make a selection: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {
                    WorkoutTracker tracker = new WorkoutTracker();
                    tracker.addWorkout(scanner);
                    tracker.printLog();
                    history.add(tracker);
                }
                case "2" -> {
                    if (history.isEmpty()) {
                        System.out.println("No workouts logged yet.");
                    } else {
                        System.out.println("=== Workout History ===");
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println("\nWorkout #" + (i + 1));
                            history.get(i).printLog();
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Thank you for using RepTrack!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid input. Please select 1, 2, or 3.");
            }
        }
    }
}
