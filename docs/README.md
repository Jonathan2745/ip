# BobChungus - User Guide

## Overview

BobChungus is a command-line based application intended as a Task Management System. It aims to help users manage their active tasks in the form of **todos**, **deadlines** and **events**.

---

## Commands



<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">

<strong> Notes about the Command Format </strong>

- Words in UPPER_CASE are the parameters to be supplied by the user.
  e.g. in TASK_DESCRIPTION is a parameter which can be replaced with the description of the task to be added
  <br>


- Parameters <strong> must </strong> be in the specified order.
  e.g. if the command specifies TASK_DESCRIPTION followed by TASK_DATE,
  TASK_DATE followed by TASK_DESCRIPTION is <strong> NOT </strong> acceptable and will cause issues.
  <br>


- Extraneous parameters for commands that do not take in parameters (such as list and bye) will cause errors.
  e.g. if the command specifies bye 123, it will be create an error.
  <br>


- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

</div>

---

### List of Commnads

---

### **Exiting the program:** `bye`

**Description:** Exits the program. Saves all Tasks within `TaskList` before exitting.

- **Use Case:** When the user is done, they can type `bye` to exit the program.
- **Format:** `bye`

### **Display all Tasks:** `list`

**Description:** Displays the list of tasks.

- **Use Case:** When the user wants to view all tasks in their list.
- **Format:** `list`

### **Create new `Todo` task:** `todo`

**Description:** Adds a new to-do task.

- **Use Case:** The user provides a description for the to-do task.
- **Arguments:** Task description (e.g., `todo Buy groceries`)
- **Format:** `todo TASK_DESCRIPTION`

### **Create new `deadline` task:** `deadline`

**Description:** Adds a new deadline task.

- **Use Case:** The user provides a task description and a deadline date.
- **Arguments:** Task description followed by `/by` and the deadline date (e.g., `deadline Finish assignment /by 15-03-2025`).
- **Format:** `deadline TASK_DESCRIPTION /by DD-MM-YYYY`

### **Create new `event` task:** `event`

**Description:** Adds a new event task.

- **Use Case:** The user provides an event description and start and end date.
- **Arguments:** Event description followed by `/from` (start date) and `/to` (end date) (e.g., `event Conference /from 20-03-2025 /to 22-03-2025`).
- **Format:** `event TASK_DESCRIPTION /from TASK_START_DATE(dd-MM-yyyy) /to TASK_END_DATE(dd-MM-yyyy)`

---

<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">
  <strong>Note:</strong> Tasks are stored within the program 0-indexed, but are displayed and interacted with by users 1-indexed.
</div>

---

### **Delete a Task:** `delete`

**Description:** Deletes a task by index.

- **Use Case:** The user provides the index of the task to be deleted.
- **Arguments:** Task index (e.g., `delete 2` to delete the second task in the list).
- **Format:** `delete TASK_INDEX`

### **Mark a task as complete:** `mark`

**Description:** Marks a task as completed.

- **Use Case:** The user provides the index of the task to mark as done.
- **Arguments:** Task index (e.g., `mark 3` to mark the third task as done).
- **Format:** `mark TASK_INDEX`

### **Mark a task as not complete:** `unmark`

**Description:** Marks a task as not completed.

- **Use Case:** The user provides the index of the task to mark as not done.
- **Arguments:** Task index (e.g., `unmark 1` to unmark the first task).
- **Format:** `unmark TASK_INDEX`

### **Find a task:** `find`

**Description:** Finds tasks with a specific keyword in their description.

- **Use Case:** The user provides a keyword to search for in the task descriptions.
- **Arguments:** Keyword to search for (e.g., `find meeting`).
- **Format:** `find TASK_DESCRIPTION`

### **Saving your data**

BobChungus' `TaskList` data is saved in the hard disk automatically after exiting with the `bye` command.
There is no need to save manually.

### **Editing Saved data**

BobChungus' `TaskList` Data is automatically saved as a `.txt` file at `[JAR file location]/data/userTasks.txt`. Advanced users are welcome to update data directly by editing that data file.

<div style="border: 1px solid #FF9800; background-color: #FFEB3B; padding: 10px; border-radius: 5px;">
  <strong>Caution:</strong>  If your changes to the data file makes its format invalid, BobChungus will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.

Furthermore, certain edits can cause BobChungus to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</div>

---

## Command Summary

| Command    | Description                               | Arguments                             | Format                                             |
| ---------- | ----------------------------------------- | ------------------------------------- | -------------------------------------------------- |
| `bye`      | Exits the program                         | None                                  | `bye`                                              |
| `list`     | Lists all tasks                           | None                                  | `list`                                             |
| `todo`     | Adds a to-do task                         | Task description                      | `todo Buy groceries`                               |
| `deadline` | Adds a deadline task                      | Task description /by date             | `deadline Submit report /by 18-03-2025`            |
| `event`    | Adds an event task                        | Event description /from date /to date | `event Conference /from 20-03-2025 /to 22-03-2025` |
| `delete`   | Deletes a task by index                   | Task index                            | `delete 2`                                         |
| `mark`     | Marks a task as completed                 | Task index                            | `mark 3`                                           |
| `unmark`   | Marks a task as not completed             | Task index                            | `unmark 1`                                         |
| `find`     | Finds tasks by keyword in the description | Search keyword                        | `find meeting`                                     |

---

## FAQs

### 1. **What happens if I enter an invalid command?**

- If you enter a command that is not recognized, the program will throw an exception and display an error message indicating that the command is invalid.

### 2. **What if I forget to include the arguments for a command like `todo` or `deadline`?**

- The program will throw an exception (`MissingTodoArgumentException`, `MissingDeadlineArgumentException`, etc.) and inform you that you are missing required arguments.

### 3. **What format should the dates be in?**

- All dates should be in the format `dd-MM-yyyy`, for Format, example `15-03-2025`.

---

## Notes on Editing Data

- The commands are case-insensitive, meaning you can type commands in any letter case (e.g., `todo`, `TODO`, `ToDo`).
- Ensure that the date format for commands like `deadline` and `event` is strictly followed (`dd-MM-yyyy`).
- You can modify the task list and storage handling by editing the `TaskList` and `Storage` classes.

---

## Known Issues

- **Date parsing errors**: If a date is not in the correct format (`dd-MM-yyyy`), a `DateTimeParseException` will be thrown.
- **Index errors**: Deleting or marking tasks by index requires the index to be valid; otherwise, an exception may occur if the user enters an invalid index.
