package streamAPI;
import java.util.*;

public class StockLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(101.5, 102.8, 99.3, 105.2);
        stockPrices.forEach(price -> System.out.println("Stock Price: " + price));
    }
}