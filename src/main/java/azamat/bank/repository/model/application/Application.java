package azamat.bank.repository.model.application;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Azamat on 4/10/2016.
 */

@Entity
@Table(name="application")
public class Application{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "iin")
    private String iin;

    @Transient
    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "amount")
    private String amount;

    @Column(name = "contract_duration")
    private String contractDuration;

    @Column(name = "contract_status")
    private String contractStatus;


    @Transient
    private Date createdAt;

    @Transient
    private Date updatedAt;

    public Application() {
    }

    public Application (long id, String iin, Date requestDate, String amount, String contractDuration, String contractStatus){
        this.id = id;
        this.iin = iin;
        this.requestDate = requestDate;
        this.amount = amount;
        this.contractDuration = contractDuration;
        this.contractStatus = contractStatus;
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
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
                "Application[id=%d, iin='%s', requestDate='%s', amount='%s', contractDuration='%s', contractStatus='%s'], createdAt='%s', updatedAt='%s'",
                id, iin, requestDate, amount, contractDuration, contractStatus, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Application other = (Application) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.iin == null) ? (other.iin != null) : !this.iin.equals(other.iin)) {
            return false;
        }
        if ((this.requestDate == null) ? (other.requestDate != null) : !this.requestDate.equals(other.requestDate)) {
            return false;
        }
        if ((this.amount == null) ? (other.amount != null) : !this.amount.equals(other.amount)) {
            return false;
        }
        if ((this.contractDuration == null) ? (other.contractDuration != null) : !this.contractDuration.equals(other.contractDuration)) {
            return false;
        }
        if ((this.contractStatus == null) ? (other.contractStatus != null) : !this.contractStatus.equals(other.contractStatus)) {
            return false;
        }
        return true;
    }
}
