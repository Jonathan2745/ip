import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {


        // Prints Initial Greeting
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Bob");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        // Declare variables
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] tasks = new String[100];
        int taskCount = 0;


        // Scans for variables
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;

            }

        // "List" command - prints out list
            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                if (taskCount == 0) {
                    System.out.println(" No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");


            } else {
                if (taskCount < 100) {
                    tasks[taskCount++] = input;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Task list is full!");
                    System.out.println("____________________________________________________________");
                }
            }

            System.out.println("____________________________________________________________");
            System.out.println(" Bye. Hope to see you again soon!");
            System.out.println("____________________________________________________________");

        }
    }
}
