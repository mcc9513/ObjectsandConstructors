
public class BankAccount {
    private double balance;
    private String name;

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void deposit(double addCash) {
        if (addCash > 0) {
            this.balance += addCash;
        } else {
            System.out.println("Deposit amount must be positive.");
        }

    }

    public void withdrawal(double loseCash) {
        if (loseCash > 0 && loseCash <= this.balance) {
            this.balance -= loseCash;
        } else if (loseCash > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    @Override
    public String toString() {
        return "Account Holder: " + this.name + ", Balance: $" + this.balance;
    }
}

