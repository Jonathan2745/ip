import java.io.*;
import Errors.*;


class Bob {

    Bob() throws FileNotFoundException {
    }

    private final UI ui = new UI();
    private final Storage storage = new Storage("data/userTasks.txt");
    private final TaskList taskList = new TaskList(storage.loadTasks());


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

public class BobChat {
    public static void main(String[] args) throws InputExceptions, IOException {
        Bob chatbot = new Bob();
        chatbot.start();
    }
}



