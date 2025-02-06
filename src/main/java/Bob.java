import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        // Prints Initial Greeting
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Bob");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        // Scans for input and repeats it back
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println("____________________________________________________________");
            System.out.println(input);
            System.out.println("____________________________________________________________");
        }


        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");

    }
}
