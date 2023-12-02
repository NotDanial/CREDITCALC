import java.text.DecimalFormat;
import java.util.Objects;

public class CreditCalculator {

    private double credit;
    private double payment;
    private double percentage;
    private String clientType;

    public void Calculate( String[] task ) throws Exception{
        boolean firstScale = false;
        int counter = 1;
        double totalSumPayed = 0;
        double startSumm;
        double overPay;

        if ( task.length !=4) throw new Exception("throws Exception…");

        credit =  Double.parseDouble(task[0]);
        payment =  Double.parseDouble(task[1]);
        percentage = Double.parseDouble(task[2]) / 100;
        clientType = task[3];
        startSumm = credit;

        if ( payment <=0 || credit <=0 ) throw new Exception("throws Exception…");

        if (clientType.equals("human")){
            if (12 * payment <= credit * percentage)  throw new Exception("throws Exception…");
            totalSumPayed = credit + credit * percentage;
            credit = credit + credit * percentage;
        }else if (clientType.equals("business")){
            credit = credit - 12 * payment;
            totalSumPayed = ( credit + credit * percentage ) + 12 * payment;
            if (12 * payment <= credit * percentage)  throw new Exception("throws Exception…");
            credit = credit + credit * percentage;
        } else   throw new Exception("throws Exception…");



        while ( credit > 0 ){
            if ( counter / 13 == 1 ) {
                totalSumPayed +=  credit * percentage;
                credit = credit + credit * percentage;
                counter = 1;
            }

            credit = credit - payment;
            counter += 1;
        }
        overPay = totalSumPayed - startSumm;
        System.out.println( overPay  );
        System.out.printf("// общая сумма к оплате %.0f " ,totalSumPayed);
    };
}
