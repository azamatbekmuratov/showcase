package azamat.bank.repository.model.person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Azamat on 4/10/2016.
 */
@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "iin")
    private String iin;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @Column(name = "date_of_issue")
    private String dateOfIssue;

    @Column(name = "valid_date")
    private String validDate;

    @Column(name = "salary_amount")
    private String salaryAmount;

    @Column(name = "expenses")
    private String expenses;

    @Transient
    private Date createdAt;

    @Transient
    private Date updatedAt;

    public Person() {
    }

    public Person (long id, String iin, String firstName, String lastName, String middleName, String phoneNumber, String birthDate, String gender, String docNumber, String placeOfIssue, String dateOfIssue, String validDate, String salaryAmount, String expenses){
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
                "Person[id=%d, iin='%s', firstName='%s', lastName='%s', middleName='%s', phoneNumber='%s', birthDate='%s', gender='%s', docNumber='%s', placeOfIssue='%s', dateOfIssue='%s', validDate='%s', salaryAmount='%s', expenses='%s'], createdAt='%s', updatedAt='%s'",
                id, iin, firstName, lastName, middleName, phoneNumber, birthDate, gender, docNumber, placeOfIssue, dateOfIssue, validDate, salaryAmount, expenses, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.iin == null) ? (other.iin != null) : !this.iin.equals(other.iin)) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.middleName == null) ? (other.middleName != null) : !this.middleName.equals(other.middleName)) {
            return false;
        }
        if ((this.phoneNumber == null) ? (other.phoneNumber != null) : !this.phoneNumber.equals(other.phoneNumber)) {
            return false;
        }
        if ((this.birthDate == null) ? (other.birthDate != null) : !this.birthDate.equals(other.birthDate)) {
            return false;
        }
        if ((this.gender == null) ? (other.gender != null) : !this.gender.equals(other.gender)) {
            return false;
        }
        if ((this.docNumber == null) ? (other.docNumber != null) : !this.docNumber.equals(other.docNumber)) {
            return false;
        }
        if ((this.placeOfIssue == null) ? (other.placeOfIssue != null) : !this.placeOfIssue.equals(other.placeOfIssue)) {
            return false;
        }
        if ((this.dateOfIssue == null) ? (other.dateOfIssue != null) : !this.dateOfIssue.equals(other.dateOfIssue)) {
            return false;
        }
        if ((this.validDate == null) ? (other.validDate != null) : !this.validDate.equals(other.validDate)) {
            return false;
        }
        if ((this.salaryAmount == null) ? (other.salaryAmount != null) : !this.salaryAmount.equals(other.salaryAmount)) {
            return false;
        }
        if ((this.expenses == null) ? (other.expenses != null) : !this.expenses.equals(other.expenses)) {
            return false;
        }
        return true;
    }
}
