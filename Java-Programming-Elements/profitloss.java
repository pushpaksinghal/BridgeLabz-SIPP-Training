public class profitloss {
    public static void main(String[] args) {
        int costPrice = 129; // Example cost price
        int sellingPrice = 191; // Example selling price
        int profitloss = sellingPrice - costPrice; // Calculate profit or loss
        int profitlossPercentage = (profitloss * 100) / costPrice; // Calculate profit percentage
        if(profitloss<0) { // Check if there is a loss
            System.out.println("Loss of " + (-profitloss) + " units and LossPercentage of " + (-profitlossPercentage) + "%"); // Print loss and loss percentage
        } else {
            System.out.println("Profit of " + profitloss + " units and ProfitPercentage of " + profitlossPercentage + "%"); // Print profit and profit percentage
        }
    }
    
}
