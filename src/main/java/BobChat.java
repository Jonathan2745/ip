import java.util.Scanner;
import Errors.*;

class Bob {
    private final Scanner scanner = new Scanner(System.in);
    private final Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void start() throws InputExceptions {
        System.out.println("____________________________________________________________");
        ASCII_Art.printArt();
        System.out.println(" Hello! I'm BobChungus ");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");


        while (true) {
            String input = scanner.nextLine().trim();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0].toLowerCase();
            String arguments = (inputParts.length > 1) ? inputParts[1] : "";

            try {
                switch (command) {
                    case "bye":
                        System.out.println("____________________________________________________________");
                        System.out.println(" Bye. Hope to see you again soon!");
                        System.out.println("____________________________________________________________");
                        scanner.close();
                        return;

                    case "list":
                        System.out.println("____________________________________________________________");
                        System.out.println(" Here are the tasks in your list:");
                        if (taskCount == 0) {
                            System.out.println("No tasks added yet.");
                        } else {
                            for (int i = 0; i < taskCount; i++) {
                                System.out.println((i + 1) + ". " + tasks[i].toString());
                            }
                        }
                        System.out.println("____________________________________________________________");
                        break;

                    case "mark":
                        if (arguments.isEmpty()) throw new InputExceptions.MissingArgumentException("mark");
                        int markIndex = Integer.parseInt(arguments) - 1;
                        if (markIndex < 0 || markIndex >= taskCount) throw new InputExceptions("mark target must exist");
                        tasks[markIndex].markAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" Nice! I've marked this task as done:");
                        System.out.println("   " + tasks[markIndex].toString());
                        System.out.println("____________________________________________________________");
                        break;

                    case "unmark":
                        if (arguments.isEmpty()) throw new InputExceptions("unmark failed, no arguments");
                        int unmarkIndex = Integer.parseInt(arguments) - 1;
                        if (unmarkIndex < 0 || unmarkIndex >= taskCount)
                            throw new InputExceptions.InvalidIndexException();
                        tasks[unmarkIndex].markAsNotDone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" OK, I've marked this task as not done yet:");
                        System.out.println("   " + tasks[unmarkIndex].toString());
                        System.out.println("____________________________________________________________");
                        break;

                    case "todo":
                        if (arguments.isEmpty()) {
                            throw new InputExceptions.MissingArgumentException("todo");
                        }
                        tasks[taskCount++] = new ToDo(arguments);
                        System.out.println("Now you have " + taskCount + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                        break;

                    case "deadline":
                        String[] parts = arguments.split(" /by ", 2);
                        if (parts.length < 2) throw new InputExceptions.MissingArgumentException("deadline");
                        tasks[taskCount++] = new Deadline(parts[0], parts[1]);
                        System.out.println("Now you have " + taskCount + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                        break;

                    case "event":
                        String[] eventParts = arguments.split(" /from ", 2);
                        if (eventParts.length < 2) throw new InputExceptions.MissingArgumentException("event");
                        String[] timeParts = eventParts[1].split(" /to ", 2);
                        if (timeParts.length < 2) throw new InputExceptions.MissingArgumentException("event timing");
                        tasks[taskCount++] = new Event(eventParts[0], timeParts[0], timeParts[1]);
                        System.out.println("Now you have " + taskCount + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                        break;

                    default:
                        throw new InputExceptions.InvalidCommandException();
                }

            } catch (InputExceptions e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("____________________________________________________________");

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
                System.out.println("____________________________________________________________");
            }
        }
    }

}

public class BobChat {
    public static void main(String[] args) throws InputExceptions {
        Bob chatbot = new Bob();
        chatbot.start();
    }
}
