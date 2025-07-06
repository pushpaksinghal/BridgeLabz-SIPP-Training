interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class AbstractBankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    AbstractBankAccount(String acc, String name, double balance) {
        this.accountNumber = acc;
        this.holderName = name;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { if (amount <= balance) balance -= amount; }

    public abstract double calculateInterest();

    public void displayAccount() {
        System.out.println("Account: " + accountNumber + ", Name: " + holderName + ", Balance: $" + balance);
    }
}

class BankSavings extends AbstractBankAccount implements Loanable {
    BankSavings(String acc, String name, double balance) {
        super(acc, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Requested: $" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

class BankCurrent extends AbstractBankAccount implements Loanable {
    BankCurrent(String acc, String name, double balance) {
        super(acc, name, balance);
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Requested: $" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        AbstractBankAccount[] accounts = {
            new BankSavings("SA123", "Alice", 8000),
            new BankCurrent("CA456", "Bob", 12000)
        };

        for (AbstractBankAccount acc : accounts) {
            acc.displayAccount();
            System.out.println("Interest: $" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable l = (Loanable) acc;
                l.applyForLoan(10000);
                System.out.println("Loan Eligible: " + l.calculateLoanEligibility());
            }

            System.out.println();
        }
    }
}
