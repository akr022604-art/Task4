import java.io.*;
import java.util.Scanner;

public class Notes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";  // notes will be stored here

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a note");
            System.out.println("2. View notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    try (FileWriter writer = new FileWriter(fileName, true)) {
                        writer.write(note + "\n");
                        System.out.println("Note saved.");
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Your Notes:");
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting Notes Manager.");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
