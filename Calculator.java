import java.util.*;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Calculator Operations");
            System.out.println("2. Data Structure Operations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = getInt();

            switch (mainChoice) {
                case 1 -> calculatorMenu();
                case 2 -> dataStructureMenu();
                case 3 -> {
                    System.out.print("Are you sure you want to exit? (Y/N): ");
                    sc.nextLine(); // consume newline
                    String confirm = sc.nextLine().trim().toLowerCase();
                    if (confirm.equals("y")) {
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                    } else {
                        System.out.println("Exit canceled. Returning to main menu.");
                    }
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Input helpers
    private static int getInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    private static String getOperator() {
        while (true) {
            String op = sc.next().trim();
            if (op.matches("[+\\-*/]")) {
                return op;
            } else {
                System.out.print("Invalid operator. Enter +, -, *, or /: ");
            }
        }
    }

    // === CALCULATOR MENU ===
    private static void calculatorMenu() {
        while (true) {
            System.out.println("\n--- Advanced Calculator ---");
            System.out.print("Enter how many numbers you want to use (min 2): ");
            int count = getInt();

            if (count < 2) {
                System.out.println("You need at least 2 numbers.");
                continue;
            }

            StringBuilder expression = new StringBuilder();
            System.out.print("Enter number 1: ");
            double result = getDouble();
            expression.append(result);

            for (int i = 2; i <= count; i++) {
                System.out.print("Enter operation (+, -, *, /): ");
                String op = getOperator();
                System.out.print("Enter number " + i + ": ");
                double nextNum = getDouble();

                expression.append(" ").append(op).append(" ").append(nextNum);

                result = switch (op) {
                    case "+" -> result + nextNum;
                    case "-" -> result - nextNum;
                    case "*" -> result * nextNum;
                    case "/" -> {
                        if (nextNum == 0) {
                            System.out.println("Error: Division by zero.");
                            yield result;
                        }
                        yield result / nextNum;
                    }
                    default -> result;
                };
            }

            System.out.println("Expression: " + expression);
            System.out.println("Result: " + result);

            System.out.print("Do you want to continue with calculator? (Y/N): ");
            sc.nextLine(); // consume newline
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Returning to Main Menu...");
                return;
            }
        }
    }

    // === DATA STRUCTURE MENU ===
    private static void dataStructureMenu() {
        while (true) {
            System.out.println("\n===== Data Structure Menu =====");
            System.out.println("1. ArrayList Operations");
            System.out.println("2. LinkedList Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose data structure: ");
            int dsChoice = getInt();

            switch (dsChoice) {
                case 1 -> arrayListMenu();
                case 2 -> linkedListMenu();
                case 3 -> queueMenu();
                case 4 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // === ARRAYLIST MENU ===
    private static void arrayListMenu() {
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("\n--- ArrayList Operations ---");
            System.out.println("1. Add element at end");
            System.out.println("2. Remove last element");
            System.out.println("3. Get element by index");
            System.out.println("4. Update element by index");
            System.out.println("5. Get size");
            System.out.println("6. Clear all elements");
            System.out.println("7. Display all elements");
            System.out.println("8. Back to Data Structure Menu");
            System.out.print("Choose operation: ");
            int op = getInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter element to add: ");
                    sc.nextLine();
                    String val = sc.nextLine();
                    list.add(val);
                    System.out.println("Added: " + val);
                }
                case 2 -> {
                    if (!list.isEmpty()) {
                        String removed = list.remove(list.size() - 1);
                        System.out.println("Removed: " + removed);
                    } else System.out.println("List is empty.");
                }
                case 3 -> {
                    if (!list.isEmpty()) {
                        System.out.print("Enter index: ");
                        int idx = getInt();
                        if (idx >= 0 && idx < list.size())
                            System.out.println("Element: " + list.get(idx));
                        else System.out.println("Invalid index.");
                    } else System.out.println("List is empty.");
                }
                case 4 -> {
                    if (!list.isEmpty()) {
                        System.out.print("Enter index: ");
                        int idx = getInt();
                        if (idx >= 0 && idx < list.size()) {
                            System.out.print("Enter new value: ");
                            sc.nextLine();
                            String val = sc.nextLine();
                            list.set(idx, val);
                            System.out.println("Updated.");
                        } else System.out.println("Invalid index.");
                    } else System.out.println("List is empty.");
                }
                case 5 -> System.out.println("Size: " + list.size());
                case 6 -> {
                    list.clear();
                    System.out.println("Cleared.");
                }
                case 7 -> System.out.println("Contents: " + list);
                case 8 -> {
                    System.out.println("Returning...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // === LINKEDLIST MENU ===
    private static void linkedListMenu() {
        LinkedList<String> list = new LinkedList<>();
        while (true) {
            System.out.println("\n--- LinkedList Operations ---");
            System.out.println("1. Add at front");
            System.out.println("2. Add at end");
            System.out.println("3. Remove from front");
            System.out.println("4. Remove from end");
            System.out.println("5. View first");
            System.out.println("6. View last");
            System.out.println("7. Get size");
            System.out.println("8. Clear all");
            System.out.println("9. Display all");
            System.out.println("10. Back to Menu");
            System.out.print("Choose operation: ");
            int op = getInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    sc.nextLine();
                    list.addFirst(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter element: ");
                    sc.nextLine();
                    list.addLast(sc.nextLine());
                }
                case 3 -> {
                    if (!list.isEmpty())
                        System.out.println("Removed: " + list.removeFirst());
                    else System.out.println("Empty.");
                }
                case 4 -> {
                    if (!list.isEmpty())
                        System.out.println("Removed: " + list.removeLast());
                    else System.out.println("Empty.");
                }
                case 5 -> System.out.println("First: " + (list.isEmpty() ? "Empty" : list.getFirst()));
                case 6 -> System.out.println("Last: " + (list.isEmpty() ? "Empty" : list.getLast()));
                case 7 -> System.out.println("Size: " + list.size());
                case 8 -> {
                    list.clear();
                    System.out.println("Cleared.");
                }
                case 9 -> System.out.println("Contents: " + list);
                case 10 -> {
                    System.out.println("Returning...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // === QUEUE MENU ===
    private static void queueMenu() {
        Queue<String> queue = new LinkedList<>();
        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Add (offer)");
            System.out.println("2. Remove (poll)");
            System.out.println("3. View front (peek)");
            System.out.println("4. Get size");
            System.out.println("5. Clear");
            System.out.println("6. Display");
            System.out.println("7. Back to Menu");
            System.out.print("Choose operation: ");
            int op = getInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    sc.nextLine();
                    queue.offer(sc.nextLine());
                }
                case 2 -> System.out.println("Removed: " + (queue.isEmpty() ? "Queue is empty" : queue.poll()));
                case 3 -> System.out.println("Front: " + (queue.isEmpty() ? "Queue is empty" : queue.peek()));
                case 4 -> System.out.println("Size: " + queue.size());
                case 5 -> {
                    queue.clear();
                    System.out.println("Cleared.");
                }
                case 6 -> System.out.println("Contents: " + queue);
                case 7 -> {
                    System.out.println("Returning...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
