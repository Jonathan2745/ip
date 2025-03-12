import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * The Storage class handles loading and saving tasks to a file.
 * It reads from and writes to a specified file path, ensuring tasks are
 * persisted across program executions.
 */
class Storage {
    private final String filePath;

    /**
     * Constructs a Storage object with a specified file path.
     *
     * @param filePath The path to the file where tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file into an ArrayList.
     *
     * @return An ArrayList of tasks loaded from storage.
     * @throws FileNotFoundException If the file does not exist.
     */
    public ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (!file.exists()) {
            try {
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }
                file.createNewFile();
                System.out.println("File not found. A new file 'userData.txt' has been created in 'data' folder.");
            } catch (IOException e) {
                System.err.println("Error creating new file: " + e.getMessage());
            }
            return tasks;
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            tasks.add(formatTaskFromStorage(scanner.nextLine()));
        }

        scanner.close();
        System.out.println("Tasks loaded successfully.");
        return tasks;
    }


    /**
     * Saves tasks to the file in a structured format.
     *
     * @param tasks The list of tasks to be saved.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            for (Task task : tasks) {
                String taskInStorageFormat = formatTaskToStorage(task);
                writer.println(taskInStorageFormat);
            }

            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Converts a Task object into a storage-friendly string format.
     *
     * @param task The task to be formatted.
     * @return A string representation of the task for storage.
     */
    public String formatTaskToStorage(Task task) {
        String taskInStorageFormat;

        if (task instanceof ToDo) {
            taskInStorageFormat = "todo|" + task.getDoneStatus() + "|" + task.getDescription();
        }
        else if (task instanceof Deadline deadlineTask) {
            taskInStorageFormat = "deadline|" + deadlineTask.getDoneStatus() + "|" + deadlineTask.getDescription() +
                    "|" + deadlineTask.getDeadlineBy();
        }
        else if (task instanceof Event eventTask) {

            taskInStorageFormat = "event|" + eventTask.getDoneStatus() + "|" + eventTask.getDescription() +
                    "|" + eventTask.getEventFrom() + "|" + eventTask.getEventTo();
        } else {
            throw new IllegalArgumentException("Unknown task type: " + task.getClass().getSimpleName());
        }

        assert taskInStorageFormat != null : "taskInStorageFormat should not be null";

        return taskInStorageFormat;
    }

    /**
     * Parses a task from its stored string format.
     *
     * @param savedTask The string representation of the task from storage.
     * @return The reconstructed Task object.
     * @throws IllegalArgumentException If the format is invalid or unknown.
     */
    public Task formatTaskFromStorage(String savedTask) {
        String[] parts = savedTask.split("\\|"); // Split by "|"
        DateTimeFormatter dateTimeLoadFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Ensure the task format is valid
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid task format: " + savedTask);
        }

        String taskType = parts[0];
        String taskDoneFormat = parts[1];
        String description = parts[2];

        boolean taskDone;

        if (Objects.equals(taskDoneFormat, "done")){
            taskDone = true;
        } else if (Objects.equals(taskDoneFormat, "not done")){
            taskDone = false;
        } else {
            throw new IllegalArgumentException("Data corrupted" + savedTask);
        }

        switch (taskType) {
            case "todo":
                assert parts.length == 3 : "Todo task should have 2 arguments";
                return new ToDo(taskDone, description);

            case "deadline":
                assert parts.length == 4 : "Deadline task should have 3 arguments";
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid deadline format: " + savedTask);
                }
                return new Deadline(taskDone, description, LocalDate.parse(parts[3], dateTimeLoadFormat));

            case "event":
                assert parts.length == 5 : "Event task should have 4 arguments";
                if (parts.length != 5) {
                    throw new IllegalArgumentException("Invalid event format: " + savedTask);
                }
                return new Event(taskDone, description, LocalDate.parse(parts[3], dateTimeLoadFormat), LocalDate.parse(parts[4],dateTimeLoadFormat));

            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType);
        }
    }



}