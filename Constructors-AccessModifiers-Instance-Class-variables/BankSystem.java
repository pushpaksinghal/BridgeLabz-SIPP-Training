class BankAccounts {
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccounts(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccounts {
    double interestRate;

    SavingsAccount(long accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void display() {
        System.out.println("Acc No: " + accountNumber + ", Holder: " + accountHolder + ", Balance: ₹" + getBalance() + ", Interest: " + interestRate + "%");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(123456789, "Kiran", 5000, 4.5);
        sa.deposit(2000);
        sa.withdraw(1000);
        sa.display();
    }
}
