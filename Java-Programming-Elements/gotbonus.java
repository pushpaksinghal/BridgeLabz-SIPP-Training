import java.util.Scanner;

public class gotbonus {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Double income = sc.nextDouble();
        Double bonus = sc.nextDouble();
        Double total = income + bonus; 
        System.out.println("the salary is "+income+"and the bonus is "+bonus+" and the total is "+total);
    }
}
