package azamat.bank.services.model.person;

import azamat.bank.common.services.model.JsonResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Azamat on 4/10/2016.
 */
public class PersonDto implements JsonResponse {
    private long id;

    @Size(min = 2, max = 255)
    @NotNull
    private String iin;

    @Size(min = 2, max = 512)
    @NotNull
    private String firstName;

    @Size(min = 2, max = 512)
    @NotNull
    private String lastName;

    @Size(min = 2, max = 512)
    @NotNull
    private String middleName;

    @Size(min = 2, max = 255)
    @NotNull
    private String phoneNumber;

    private String birthDate;
    private String gender;
    private String docNumber;
    private String placeOfIssue;
    private String dateOfIssue;
    private String validDate;
    private String salaryAmount;
    private String expenses;

    public PersonDto() {
    }

    public PersonDto (long id, String iin, String firstName, String lastName, String middleName, String phoneNumber, String birthDate, String gender, String docNumber, String placeOfIssue, String dateOfIssue, String validDate, String salaryAmount, String expenses){
        this.id = id;
        this.iin = iin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.docNumber = docNumber;
        this.placeOfIssue = placeOfIssue;
        this.dateOfIssue = dateOfIssue;
        this.validDate = validDate;
        this.salaryAmount = salaryAmount;
        this.expenses = expenses;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(String salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
}
