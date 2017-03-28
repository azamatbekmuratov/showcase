package azamat.bank.services.model.application;

import azamat.bank.common.services.model.JsonResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Azamat on 4/10/2016.
 */
public class ApplicationDto implements JsonResponse {

    private long id;

    @Size(min = 2, max = 512)
    @NotNull
    private String iin;

    private Date requestDate;

    private String amount;


    private String contractDuration;

    private String contractStatus;

    public ApplicationDto() {
    }

    public ApplicationDto (long id, String iin, Date requestDate, String amount, String contractDuration, String contractStatus){
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
}
