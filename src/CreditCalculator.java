import java.text.DecimalFormat;

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
        if ( task.length !=3) throw new Exception("throws Exception…");
        credit =  Double.parseDouble(task[0]);
        payment =  Double.parseDouble(task[1]);
        percentage = Double.parseDouble(task[2]) / 100;
        clientType = task[3];
        startSumm = credit;

        if (clientType.equals("human")){
            totalSumPayed = credit + credit * percentage;
            credit = credit + credit * percentage;
        }else if (clientType.equals("business")){   // Тут специально поставил if что-бы было понятно.
            credit = credit - 12 * payment;
            totalSumPayed = ( credit + credit * percentage ) + 12 * payment;
            credit = credit + credit * percentage;
        }
        if ( payment <=0 || credit <=0 ) throw new Exception("throws Exception…");
        if ( payment <= credit * percentage) throw new Exception("throws Exception…");


        while ( credit > 0 ){
            if ( counter / 12 == 1 ) {
                totalSumPayed += totalSumPayed + credit * percentage;
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
