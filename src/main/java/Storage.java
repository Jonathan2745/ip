import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist, starting with an empty list.");
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

    public String formatTaskToStorage(Task task) {
        String taskInStorageFormat;

        if (task instanceof ToDo) {
            taskInStorageFormat = "todo|" + task.getDescription();
        }
        else if (task instanceof Deadline deadlineTask) {
            taskInStorageFormat = "deadline|" + deadlineTask.getDescription() + "|" + deadlineTask.getDeadlineBy();
        }
        else if (task instanceof Event eventTask) {

            taskInStorageFormat = "event|" + eventTask.getDescription() + "|" + eventTask.getEventFrom() + "|" + eventTask.getEventTo();
        } else {
            throw new IllegalArgumentException("Unknown task type: " + task.getClass().getSimpleName());
        }

        assert taskInStorageFormat != null : "taskInStorageFormat should not be null";

        return taskInStorageFormat;
    }

    public Task formatTaskFromStorage(String savedTask) {
        String[] parts = savedTask.split("\\|"); // Split by "|"

        // Ensure the task format is valid
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid task format: " + savedTask);
        }

        String taskType = parts[0];
        String description = parts[1];

        switch (taskType) {
            case "todo":
                assert parts.length == 2 : "Todo task should have 2 arguments";
                return new ToDo(description);

            case "deadline":
                assert parts.length == 3 : "Deadline task should have 3 arguments";
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid deadline format: " + savedTask);
                }
                return new Deadline(description, parts[2]);

            case "event":
                assert parts.length == 4 : "Event task should have 4 arguments";
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid event format: " + savedTask);
                }
                return new Event(description, parts[2], parts[3]);

            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType);
        }
    }



}