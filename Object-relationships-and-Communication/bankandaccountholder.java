import java.util.*;

class Bank {
    private String name;
    private List<Customer> customers;
    private Map<Customer, List<Account>> accounts;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new HashMap<>();
    }

    public void openAccount(Customer customer, double initialBalance) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            accounts.put(customer, new ArrayList<>());
        }
        Account newAccount = new Account(this, initialBalance);
        accounts.get(customer).add(newAccount);
        customer.addAccount(newAccount);
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

public class bankandaccountholder {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer customer = new Customer("John Doe");

        bank.openAccount(customer, 1000.0);
        bank.openAccount(customer, 5000.0);

        customer.viewBalance();
    }
}
