import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            CreditCalculator creditCalculator = new CreditCalculator();
            Scanner console   = new Scanner(System.in);
            String task = console.nextLine();
            String[] taskPars = task.split(" ");
            creditCalculator.Calculate( taskPars );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}