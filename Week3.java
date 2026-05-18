import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String date;
    String category;
    String description;
    double amount;

    Expense(String date, String category, String description, double amount) {
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    void displayExpense() {
        System.out.println("--------------------------------");
        System.out.println("Date: " + date);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Amount: " + amount);
    }
}

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Search Expense by Category");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    Expense expense = new Expense(date, category, description, amount);

                    expenses.add(expense);

                    System.out.println("Expense Added Successfully!");
                    break;

                case 2:

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {

                        for (Expense e : expenses) {
                            e.displayExpense();
                        }
                    }

                    break;

                case 3:

                    double total = 0;

                    for (Expense e : expenses) {
                        total += e.amount;
                    }

                    System.out.println("Total Expense = " + total);
                    break;

                case 4:

                    System.out.print("Enter category to search: ");
                    String searchCategory = sc.nextLine();

                    boolean found = false;

                    for (Expense e : expenses) {

                        if (e.category.equalsIgnoreCase(searchCategory)) {
                            e.displayExpense();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No expense found in this category.");
                    }

                    break;

                case 5:

                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}