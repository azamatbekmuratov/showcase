package azamat.bank.services.model.application;

/**
 * Created by Azamat on 4/11/2016.
 */
public class ResponseCalculation {

    private String monthlyAmount;
    private String totalAmountPayments;
    private String overPayment;

    public String getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(String monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public String getTotalAmountPayments() {
        return totalAmountPayments;
    }

    public void setTotalAmountPayments(String totalAmountPayments) {
        this.totalAmountPayments = totalAmountPayments;
    }

    public String getOverPayment() {
        return overPayment;
    }

    public void setOverPayment(String overPayment) {
        this.overPayment = overPayment;
    }
}
