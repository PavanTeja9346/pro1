import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class ReportGenerator {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private double totalExpense = 0;

    public void addExpense(String description, double amount) {
        expenses.add(new Expense(description, amount));
        totalExpense += amount;
    }

    public void generateReport() {
        System.out.println("Expense Report:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription() + ", Amount: " + expense.getAmount());
        }
        System.out.println("Total Expense: $" + totalExpense);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println("Enter the number of expenses: ");
        int numberOfExpenses = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 0; i < numberOfExpenses; i++) {
            System.out.println("Enter description of expense " + (i + 1) + ": ");
            String description = scanner.nextLine();
            System.out.println("Enter amount for " + description + ": ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume the newline

            reportGenerator.addExpense(description, amount);
        }
        reportGenerator.generateReport();}
}