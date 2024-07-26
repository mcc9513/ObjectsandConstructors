public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500, "Alex");

        account.deposit(100);
        System.out.println(account);

        BankAccount account1 = new BankAccount(5000, "Nathan");
        BankAccount account2 = new BankAccount(300, "Chris");

        account1.withdrawal(100);
        account2.deposit(100);

        System.out.println(account1);
        System.out.println(account2);

    }
}

