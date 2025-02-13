import java.util.Scanner;

class Bob {
    private final Scanner scanner = new Scanner(System.in);
    private final Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void start() {
        System.out.println("____________________________________________________________");
        ASCII_Art.printArt();
        System.out.println(" Hello! I'm BobChungus ");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");


        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Here are the tasks in your list:");
                if (taskCount == 0) {
                    System.out.println(" No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i].toString());
                    }
                }
                System.out.println("____________________________________________________________");
            }

            if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[index].toString());
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsNotDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[index].toString());
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("Invalid input");
                }
            } else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                tasks[taskCount++] = new ToDo(description);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ", 2);
                if (parts.length == 2) {
                    tasks[taskCount++] = new Deadline(parts[0], parts[1]);
                } else {
                    System.out.println("Invalid deadline description");
                }
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from ", 2);
                if (parts.length == 2) {
                    String[] timeParts = parts[1].split(" /to ", 2);
                    if (timeParts.length == 2) {
                        tasks[taskCount++] = new Event(parts[0], timeParts[0], timeParts[1]);
                    }
                } else {
                    System.out.println("Invalid input, please input a starting and ending time");
                }
                System.out.println("Now you have " + taskCount + "  tasks in the list.");
                System.out.println("____________________________________________________________");
            } else {
                System.out.println(" Invalid command. Please try again.");
            }
        }

        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");

        scanner.close();
    }

}

public class BobChat {
    public static void main(String[] args) {
        Bob chatbot = new Bob();
        chatbot.start();
    }
}
