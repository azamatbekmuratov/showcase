package azamat.bank.common.services.model;

/**
 * Created by Azamat on 4/10/2016.
 */
public enum ResponseStatus {
    SUCCESS("true"),
    FAILED("false");
    private final String status;

    private ResponseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
