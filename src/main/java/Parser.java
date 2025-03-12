import Errors.InputExceptions;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Parses user commands and executes corresponding actions.
 */
class Parser {

    /** Scanner for reading user input. */
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateTimeInputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Reads and returns user input from the console, trimming whitespace.
     *
     * @return The trimmed user input as a string.
     */
    public static String getUserInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Parses and executes the user command.
     *
     * @param input The user input string.
     * @param taskList The list of tasks.
     * @param storage The storage handler for saving tasks.
     * @param ui The user interface handler for displaying messages.
     * @throws InputExceptions If an invalid command or missing argument is encountered.
     */
    public static void parseCommand(String input, TaskList taskList, Storage storage, UI ui) throws InputExceptions {
        String[] inputParts = input.split(" ", 2);
        String command = inputParts[0].toLowerCase();
        String arguments = (inputParts.length > 1) ? inputParts[1] : "";

        switch (command) {
            case "bye":
                ui.showGoodbye();
                storage.saveTasks(taskList.getListOfTasks());
                System.exit(0);
                break;

            case "list":
                ui.showList();
                if (taskList.size() == 0) {
                    System.out.println("No tasks added yet.");
                } else {
                    for (int i = 0; i < taskList.size(); i++) {
                        System.out.println((i + 1) + ". " + taskList.getTask(i));
                    }
                }
                ui.printLine();
                break;

            case "todo":
                if (arguments.isEmpty()) {
                    throw new InputExceptions.MissingTodoArgumentException("todo");
                }
                taskList.addTask(new ToDo(false, arguments));
                ui.printLine();
                break;

            case "deadline":
                String[] parts = arguments.split(" /by ", 2);
                if (parts.length < 2) {
                    throw new InputExceptions.MissingDeadlineArgumentException("deadline");
                }
                try {
                    LocalDate deadlineBy = LocalDate.parse(parts[1], dateTimeInputFormat);
                    taskList.addTask(new Deadline(false, parts[0], deadlineBy));
                } catch (DateTimeParseException e) {
                    throw new InputExceptions.InvalidDateFormatException();
                }
                ui.printLine();
                break;

            case "event":
                String[] eventParts = arguments.split(" /from ", 2);
                if (eventParts.length < 2) {
                    throw new InputExceptions.MissingEventArgumentException("event");
                }
                String[] timeParts = eventParts[1].split(" /to ", 2);
                if (timeParts.length < 2) {
                    throw new InputExceptions.MissingEventArgumentException("event");
                }
                try {
                    LocalDate startDate = LocalDate.parse(timeParts[0], dateTimeInputFormat);
                    LocalDate endDate = LocalDate.parse(timeParts[1], dateTimeInputFormat);
                    taskList.addTask(new Event(false, eventParts[0], startDate, endDate));
                } catch (DateTimeParseException e) {
                    throw new InputExceptions.InvalidDateFormatException();
                }
                ui.printLine();
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(arguments) - 1;
                taskList.removeTask(deleteIndex);
                ui.deletedTask(deleteIndex);
                break;

            case "mark":
                int markIndex = Integer.parseInt(arguments) - 1;
                taskList.getTask(markIndex).markAsDone();
                ui.markedTask(markIndex);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(arguments) - 1;
                taskList.getTask(unmarkIndex).markAsNotDone();
                ui.unmarkedTask(unmarkIndex);
                break;

            case "find":
                if (arguments.isEmpty()) {
                    throw new InputExceptions.MissingFindArgumentException("find");
                }
                ui.printFindingTask();
                int taskFound = 0;
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.getTask(i);
                    if (task.getDescription().toLowerCase().contains(arguments)) {
                        taskFound++;
                        ui.printFoundTask(taskFound, task);
                    }
                }

                if (taskFound == 0) {
                    ui.printNoTaskFound();
                }

                ui.printLine();
                break;

            default:
                throw new InputExceptions.InvalidCommandException();
        }
    }


 }