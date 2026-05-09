import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Expense {
    String date;
    double amount;
    String category;
    String description;

    Expense(String date, double amount, String category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    void display(int index) {
        System.out.println("Expense No: " + index);
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("---------------------------");
    }

    String toFileString() {
        return date + "," + amount + "," + category + "," + description;
    }
}

public class Main {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "expenses.txt";

    public static void addExpense() {
        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        expenses.add(new Expense(date, amount, category, description));
        System.out.println("Expense added successfully.");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        int i = 1;
        for (Expense e : expenses) {
            e.display(i);
            i++;
        }
    }

    public static void searchCategory() {
        System.out.print("Enter Category: ");
}