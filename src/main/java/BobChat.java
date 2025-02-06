import java.util.Scanner;

class Task {
    private final String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}

class Bob {
    private final Scanner scanner = new Scanner(System.in);
    private final String name = "Bob";
    private final Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void start() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm " + name);
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        String input;
        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Here are the tasks in your list:");
                if (taskCount == 0) {
                    System.out.println(" No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i].getStatusIcon());
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[index].getStatusIcon());
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsNotDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[index].getStatusIcon());
                    System.out.println("____________________________________________________________");
                }
            } else {
                if (taskCount < 100) {
                    tasks[taskCount++] = new Task(input);
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println(" Task list is full!");
                }
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
