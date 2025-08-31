package BankingSystem;

import java.util.*;

public class BankingSystem {
    private final HashMap<Integer, Double> accounts = new HashMap<>();
    private final TreeMap<Double, List<Integer>> balanceMap = new TreeMap<>(Collections.reverseOrder());
    private final Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double initialBalance) {
        System.out.println();
        if (initialBalance >= 1000) {
            accounts.put(accountNumber, initialBalance);
            balanceMap.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
            System.out.println("✅ Account added: " + accountNumber + " with ₹" + initialBalance);
        }else {
            System.out.println("\u001b[31m❌ Initial balance must be at least ₹1000\u001b[0m");
        }
    }

    public void requestWithdrawal(int accountNumber) {
        System.out.println();
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("Withdrawal requested by account: " + accountNumber);
        } else {
            System.out.println("\u001b[31m❌ Account not found: " + accountNumber + "\u001b[0m");
        }
    }

    public void processWithdrawals(double amount) {
        System.out.println("\nProcessing Withdrawals...");
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double currentBalance = accounts.get(accountNumber);

            if (currentBalance >= amount) {
                double updatedBalance = currentBalance - amount;
                accounts.put(accountNumber, updatedBalance);

                // Updating TreeMap
                balanceMap.get(currentBalance).remove((Integer) accountNumber);
                if (balanceMap.get(currentBalance).isEmpty()) {
                    balanceMap.remove(currentBalance);
                }
                balanceMap.computeIfAbsent(updatedBalance, k -> new ArrayList<>()).add(accountNumber);

                System.out.println("✅ ₹" + amount + " withdrawn from Account " + accountNumber);
            } else {
                System.out.println("⚠️ Insufficient funds in Account " + accountNumber);
            }
        }
    }

    public void displayAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " → ₹" + entry.getValue());
        }
    }

    public void displaySortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : balanceMap.entrySet()) {
            for (int acc : entry.getValue()) {
                System.out.println("Account " + acc + " → ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(101, 5000.0);
        bank.addAccount(102, 7500.0);
        bank.addAccount(103, 3000.0);
        bank.addAccount(104, 100.50);

        bank.requestWithdrawal(101);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(104); // Invalid account

        bank.displayAccounts();
        bank.displaySortedByBalance();

        bank.processWithdrawals(2000.0);

        bank.displayAccounts();
        bank.displaySortedByBalance();
    }
}
