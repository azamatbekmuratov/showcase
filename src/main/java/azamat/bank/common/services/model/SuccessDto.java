package azamat.bank.common.services.model;

/**
 *
 */
public class SuccessDto implements JsonResponse {
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success = true;
}
