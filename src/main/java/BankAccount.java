import java.util.Scanner;

public class BankAccount {
    private String name;
    private double balance;

    // Existing constructor
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // New no-parameter constructor
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's make a new account!");
        System.out.print("What is the name for the account? ");
        this.name = scanner.nextLine();

        System.out.print("What is the beginning balance for the account? ");
        this.balance = scanner.nextDouble();
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance is " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance is " + balance);
        } else {
            System.out.println("Invalid withdrawal amount. Either amount is negative or exceeds balance.");
        }
    }

    // Transfer method
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + targetAccount.getName());
        } else {
            System.out.println("Invalid transfer amount. Either amount is negative or exceeds balance.");
        }
    }

}
