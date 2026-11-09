import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VolunteerSystem system = new VolunteerSystem();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        System.out.println("Smart Event Volunteer Coordination System");
        while (choice != 0) {
            System.out.println("\nLIST OF ACTIONS THAT CAN BE DONE");
            System.out.println("1-->Register a new volunteer");
            System.out.println("2-->Assign task");
            System.out.println("3-->View all volunteers");
            System.out.println("4-->View all volunteers sorted by priority");
            System.out.println("5-->Search Volunteer");
            System.out.println("6-->Undo last action");
            System.out.println("7-->View volunteers of specific priority group");
            System.out.println("8-->Remove volunteer by ID");
            System.out.println("9-->Display waiting queue");
            System.out.println("10-->Display Undo stack");
            System.out.println("0-->Exit System");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Volunteer ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Volunteer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Priority Level (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    system.registerVolunteer(id, name, priority);
                    break;
                case 2:
                    System.out.print("Enter Task Description: ");
                    String task = scanner.nextLine();
                    system.assignTask(task);
                    break;
                case 3:
                    system.displayVolunteers();
                    break;
                case 4:
                    system.displaySorted();
                    break;
                case 5:
                    System.out.print("Enter ID or Name to search: ");
                    system.searchVolunteer(scanner.nextLine());
                    break;
                case 6:
                    system.undoLastAction();
                    break;

                case 7:
                    System.out.print("Enter which Priority Level Volunteers List needed (High/Medium/Low): ");
                    system.viewPriorityGroup(scanner.nextLine());
                    break;
                case 8:
                    System.out.print("Enter Volunteer ID to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeVolunteer(removeId);
                    break;
                case 9:
                    system.displayWaitingQueue();
                    break;
                case 10:
                    system.displayUndoStack();
                    break;
                case 0:
                    System.out.println("Exiting System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}