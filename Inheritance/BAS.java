class BankA {
    String accountNumber;
    double balance;

    BankA(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsA extends BankA {
    double interestRate;

    SavingsA(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankA {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankA {
    int maturityPeriod;

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

public class BAS {
    public static void main(String[] args) {
        SavingsA savings = new SavingsA("SAV123", 5000, 4.5);
        CheckingAccount checking = new CheckingAccount("CHK456", 3000, 1000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 10000, 12);

        savings.displayAccountType();
        savings.displayInfo();
        System.out.println();

        checking.displayAccountType();
        checking.displayInfo();
        System.out.println();

        fixed.displayAccountType();
        fixed.displayInfo();
    }
}
