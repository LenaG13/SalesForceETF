package model;

import java.util.Objects;

public class ContactModel {

    String Name;
    String Salutation;
    String FirstName;
    String LastName;
    String Phone;
    String Mobile;
    String AccountName;
    String Title;
    String Email;
    String Description;

    public ContactModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactModel that = (ContactModel) o;
        return Objects.equals(Name, that.Name) && Objects.equals(Salutation, that.Salutation) && Objects.equals(FirstName, that.FirstName) && Objects.equals(LastName, that.LastName) && Objects.equals(Phone, that.Phone) && Objects.equals(Mobile, that.Mobile) && Objects.equals(AccountName, that.AccountName) && Objects.equals(Title, that.Title) && Objects.equals(Email, that.Email) && Objects.equals(Description, that.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Salutation, FirstName, LastName, Phone, Mobile, AccountName, Title, Email, Description);
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "Name='" + Name + '\'' +
                ", Salutation='" + Salutation + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", Title='" + Title + '\'' +
                ", Email='" + Email + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
