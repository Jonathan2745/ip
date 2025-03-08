import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
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