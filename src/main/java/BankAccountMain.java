import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.println("Hello world! Welcome to the Bank of Matt!");
        int choice = 0;

        while (choice != -1) {
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            if (choice == 1) {
                // Handle existing customer
                System.out.print("Enter account holder name: ");
                String name = scanner.nextLine();
                BankAccount account = findAccount(accounts, name);
                if (account != null) {
                    mainMenu(account, accounts);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                // Create a new account
                BankAccount newAccount = new BankAccount();
                accounts.add(newAccount);

                System.out.println("Account created for " + newAccount.getName() +
                        " with balance " + newAccount.getBalance());
                mainMenu(newAccount, accounts);
            }
        }

        System.out.println("Goodbye!");
    }

    // Helper method to find account by name
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String name) {
        for (BankAccount account : accounts) {
            if (account.getName().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null;
    }

    // Main menu method
    private static void mainMenu(BankAccount account, ArrayList<BankAccount> accounts) {
        Scanner scanner = new Scanner(System.in);
        int action = 0;

        System.out.println("Welcome, " + account.getName() + "!");
        while (action != -1) {
            System.out.println("What would you like to do? (-1 to exit)");
            System.out.println("1. Check account balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer to another account");
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Your account balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    listAccounts(accounts);
                    System.out.print("Enter the account number to transfer to: ");
                    int targetAccountNumber = scanner.nextInt();
                    if (targetAccountNumber >= 0 && targetAccountNumber < accounts.size()) {
                        BankAccount targetAccount = accounts.get(targetAccountNumber);
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        account.transfer(targetAccount, transferAmount);
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;
                case -1:
                    System.out.println("Exiting to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to list all accounts with index
    private static void listAccounts(ArrayList<BankAccount> accounts) {
        System.out.println("List of accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount account = accounts.get(i);
            System.out.println(i + ". " + account.getName() + " - Balance: " + account.getBalance());
        }
    }
}
