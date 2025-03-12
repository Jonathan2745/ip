import java.io.*;
import Errors.*;

/**
 * Represents the Bob chatbot application, handling user input and task management.
 */
class Bob {

    /**
     * Constructs a Bob chatbot instance and initializes necessary components.
     *
     * @throws FileNotFoundException If the task storage file is not found.
     */
    Bob() throws FileNotFoundException {
    }

    /** User interface for interacting with the user. */
    private final UI ui = new UI();

    /** Storage handler for saving and loading tasks from a file. */
    private final Storage storage = new Storage("data/userTasks.txt");

    /** Task list containing all user tasks. */
    private final TaskList taskList = new TaskList(storage.loadTasks());

    /**
     * Starts the chatbot, displaying a welcome message and handling user input continuously.
     */
    public void start() {
        ui.showWelcome();

        while (true) {
            String userInput = Parser.getUserInput();
            try {
                Parser.parseCommand(userInput, taskList, storage, ui);
            } catch (InputExceptions e) {
                System.out.println("Error: " + e.getMessage()); // Prints error but continues running
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

    }
}


/**
 * Entry point for running the Bob chatbot application.
 */
public class BobChat {
    /**
     * Main method that initializes and starts the chatbot.
     *
     * @param args Command-line arguments.
     * @throws InputExceptions If an input-related exception occurs.
     * @throws IOException If an error occurs during file operations.
     */
    public static void main(String[] args) throws InputExceptions, IOException {
        Bob chatbot = new Bob();
        chatbot.start();
    }
}



