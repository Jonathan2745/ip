import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
import Errors.*;


class Bob {

    Bob() throws FileNotFoundException {
    }

//    private final Scanner scanner = new Scanner(System.in);
    private final UI ui = new UI();
    private final Storage storage = new Storage("data/userTasks.txt");
    private final TaskList taskList = new TaskList( storage.loadTasks());


//    private final String filepath = "data/userTasks.txt";
//    static final ArrayList<Task> tasks = new ArrayList<>();


    public void start() {
        ui.showWelcome();
        while (true) {
            String userInput = ui.getUserInput();
//            Parser.parseCommand(userInput, taskList, storage, ui);
            try {
                Parser.parseCommand(userInput, taskList, storage, ui);
            } catch (InputExceptions e) {
                System.out.println("Error: " + e.getMessage()); // Prints error but continues running
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

    }




//
//    public void start() throws InputExceptions {
//        System.out.println("____________________________________________________________");
//        ASCII_Art.printArt();
//        System.out.println(" Hello! I'm BobChungus ");
//        System.out.println(" What can I do for you?");
//        System.out.println("____________________________________________________________");
//
//        try {
//            loadFileContents(filepath); // Call method inside try block
//        } catch (FileNotFoundException e) {
//            System.err.println("Error: File not found. " + e.getMessage());
//        }
//
//        while (true) {
//            String input = scanner.nextLine().trim();
//            String[] inputParts = input.split(" ", 2);
//            String command = inputParts[0].toLowerCase();
//            String arguments = (inputParts.length > 1) ? inputParts[1] : "";
//
//            try {
//                switch (command) {
//                    case "bye":
//                        System.out.println("____________________________________________________________");
//                        System.out.println(" Bye. Hope to see you again soon!");
//                        System.out.println("____________________________________________________________");
//                        saveFileContents(filepath);
//                        scanner.close();
//                        return;
//
//                    case "list":
//                        System.out.println("____________________________________________________________");
//                        System.out.println(" Here are the tasks in your list:");
//                        if (tasks.isEmpty()) {
//                            System.out.println("No tasks added yet.");
//                        } else {
//                            for (int i = 0; i < tasks.size(); i++) {
//                                System.out.println((i + 1) + ". " + tasks.get(i).toString());
//                            }
//                        }
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "mark":
//                        if (arguments.isEmpty()) throw new InputExceptions.MissingArgumentException("mark");
//                        int markIndex = Integer.parseInt(arguments) - 1;
//                        if (markIndex < 0 || markIndex >= tasks.size()) throw new InputExceptions("mark target must exist");
//                        tasks.get(markIndex).markAsDone();
//                        System.out.println("____________________________________________________________");
//                        System.out.println(" Nice! I've marked this task as done:");
//                        System.out.println("   " + tasks.get(markIndex).toString());
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "unmark":
//                        if (arguments.isEmpty()) throw new InputExceptions("unmark failed, no arguments");
//                        int unmarkIndex = Integer.parseInt(arguments) - 1;
//                        if (unmarkIndex < 0 || unmarkIndex >= tasks.size())
//                            throw new InputExceptions.InvalidIndexException();
//                        tasks.get(unmarkIndex).markAsNotDone();
//                        System.out.println("____________________________________________________________");
//                        System.out.println(" OK, I've marked this task as not done yet:");
//                        System.out.println("   " + tasks.get(unmarkIndex).toString());
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "todo":
//                        if (arguments.isEmpty()) {
//                            throw new InputExceptions.MissingArgumentException("todo");
//                        }
//                        tasks.add( new ToDo(arguments) );
//                        System.out.println("Now you have " + (tasks.size()) + " tasks in the list.");
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "deadline":
//                        String[] parts = arguments.split(" /by ", 2);
//                        if (parts.length < 2) throw new InputExceptions.MissingArgumentException("deadline");
//                        tasks.add( new Deadline(parts[0], parts[1]));
//                        System.out.println("Now you have " + (tasks.size()) + " tasks in the list.");
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "event":
//                        String[] eventParts = arguments.split(" /from ", 2);
//                        if (eventParts.length < 2) throw new InputExceptions.MissingArgumentException("event");
//                        String[] timeParts = eventParts[1].split(" /to ", 2);
//                        if (timeParts.length < 2) throw new InputExceptions.MissingArgumentException("event timing");
//                        tasks.add( new Event(eventParts[0], timeParts[0], timeParts[1]));
//                        System.out.println("Now you have " + (tasks.size()) + " tasks in the list.");
//                        System.out.println("____________________________________________________________");
//                        break;
//
//                    case "delete":
//                        if (arguments.isEmpty()) {
//                            throw new InputExceptions.MissingArgumentException("todo");
//                        }
//                        int deleteIndex = Integer.parseInt(arguments) - 1;
//                        if (deleteIndex < 0 || deleteIndex >= tasks.size()) {
//                            throw new InputExceptions.InvalidIndexException();
//                        }
//                        Task removedTask = tasks.remove(deleteIndex);
//                        System.out.println("____________________________________________________________");
//                        System.out.println(" Noted. I've removed this task:");
//                        System.out.println("   " + removedTask);
//                        System.out.println("Now you have " + tasks.size()  + " tasks in the list.");
//                        System.out.println("____________________________________________________________");
//                        break;
//
//
//
//                    default:
//                        throw new InputExceptions.InvalidCommandException();
//                }
//
//            } catch (InputExceptions e) {
//                System.out.println("Error: " + e.getMessage());
//                System.out.println("____________________________________________________________");
//
//            } catch (NumberFormatException e) {
//                System.out.println("Error: Please enter a valid number.");
//                System.out.println("____________________________________________________________");
//            }
//        }
//    }

}

public class BobChat {
    public static void main(String[] args) throws InputExceptions, IOException {
        Bob chatbot = new Bob();
        chatbot.start();
    }
}


//    // Load tasks from file
//    private static void loadFileContents(String filePath) throws FileNotFoundException {
//        File file = new File(filePath);
//        if (!file.exists()) {
//            System.out.println("File does not exist, starting with an empty list.");
//            return;
//        }
//
//        Scanner scanner = new Scanner(file);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            tasks.add(Task.fromString(line)); // Convert line to Task and add
//        }
//        scanner.close();
//        System.out.println("Tasks loaded successfully.");
//    }
//
//    // Save tasks to file
//    private static void saveFileContents(String filePath) {
//        try (FileWriter fileWriter = new FileWriter(filePath);
//             PrintWriter writer = new PrintWriter(fileWriter)) {
//
//            for (Task task : tasks) {
//                writer.println(task); // Uses Task's toString() method
//            }
//
//            System.out.println("Tasks saved successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving tasks: " + e.getMessage());
//        }
//    }