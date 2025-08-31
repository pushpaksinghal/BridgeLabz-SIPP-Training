package Lambda_Expressions.Method_References;

import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice{transactionId='" + transactionId + "'}";
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN1001", "TXN1002", "TXN1003"
        );

        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)
                                               .collect(Collectors.toList());

        System.out.println("=== Generated Invoices ===");
        invoices.forEach(System.out::println);
    }
}
