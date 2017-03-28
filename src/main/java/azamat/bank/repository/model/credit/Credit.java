package azamat.bank.repository.model.credit;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Azamat on 4/11/2016.
 */
@Entity
@Table(name="credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "iin")
    private String iin;

    @Column(name = "amount")
    private String amount;

    @Column(name = "contract_duration")
    private String contractDuration;

    @Column(name = "rate")
    private String rate;

    @Column(name = "monthly_amount")
    private String monthlyAmount;

    @Column(name = "amount_in_usd")
    private String amountInUsd;

    @Column(name = "total_amount_payments")
    private String totalAmountPayments;

    @Column(name = "over_payment")
    private String overPayment;

    @Transient
    private Date createdAt;

    @Transient
    private Date updatedAt;

    public Credit() {
    }

    public Credit (long id, String iin, String amount, String contractDuration, String rate, String monthlyAmount, String amountInUsd, String totalAmountPayments, String overPayment){
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Credit[id=%d, iin='%s', amount='%s', contractDuration='%s', rate='%s', monthlyAmount='%s', amountInUsd='%s', totalAmountPayments='%s', overPayment='%s'], createdAt='%s', updatedAt='%s'",
                id, iin, amount, contractDuration, rate, monthlyAmount, amountInUsd, totalAmountPayments, overPayment, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Credit other = (Credit) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.iin == null) ? (other.iin != null) : !this.iin.equals(other.iin)) {
            return false;
        }
        if ((this.amount == null) ? (other.amount != null) : !this.amount.equals(other.amount)) {
            return false;
        }
        if ((this.contractDuration == null) ? (other.contractDuration != null) : !this.contractDuration.equals(other.contractDuration)) {
            return false;
        }
        if ((this.rate == null) ? (other.rate != null) : !this.rate.equals(other.rate)) {
            return false;
        }
        if ((this.monthlyAmount == null) ? (other.monthlyAmount != null) : !this.monthlyAmount.equals(other.monthlyAmount)) {
            return false;
        }
        if ((this.amountInUsd == null) ? (other.amountInUsd != null) : !this.amountInUsd.equals(other.amountInUsd)) {
            return false;
        }
        if ((this.totalAmountPayments == null) ? (other.totalAmountPayments != null) : !this.totalAmountPayments.equals(other.totalAmountPayments)) {
            return false;
        }
        if ((this.overPayment == null) ? (other.overPayment != null) : !this.overPayment.equals(other.overPayment)) {
            return false;
        }
        return true;
    }
}
