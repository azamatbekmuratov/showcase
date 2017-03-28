package azamat.bank.services.model.credit;

import azamat.bank.common.services.model.JsonResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Azamat on 4/11/2016.
 */
public class CreditDto implements JsonResponse {
    private long id;

    @Size(min = 2, max = 255)
    @NotNull
    private String iin;

    @Size(min = 2, max = 512)
    @NotNull
    private String amount;

    @Size(min = 2, max = 512)
    @NotNull
    private String contractDuration;

    @Size(min = 2, max = 255)
    @NotNull
    private String rate;

    @Size(min = 2, max = 512)
    @NotNull
    private String monthlyAmount;

    @Size(min = 2, max = 512)
    @NotNull
    private String amountInUsd;

    @Size(min = 2, max = 512)
    @NotNull
    private String totalAmountPayments;

    @Size(min = 2, max = 512)
    @NotNull
    private String overPayment;

    public CreditDto() {
    }

    public CreditDto (long id, String iin, String amount, String contractDuration, String rate, String monthlyAmount, String amountInUsd, String totalAmountPayments, String overPayment){
        this.id = id;
        this.iin = iin;
        this.amount = amount;
        this.contractDuration = contractDuration;
        this.rate = rate;
        this.monthlyAmount = monthlyAmount;
        this.amountInUsd = amountInUsd;
        this.totalAmountPayments = totalAmountPayments;
        this.overPayment = overPayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(String monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public String getAmountInUsd() {
        return amountInUsd;
    }

    public void setAmountInUsd(String amountInUsd) {
        this.amountInUsd = amountInUsd;
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
