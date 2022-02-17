package model;

import java.util.Objects;

public class AccountModel {

    String AccountName;
    String Phone;
    String Fax;
    String Website;
    String Type;
    int Employees;
    String Industry;
    int AnnualRevenue;
    String Description;
    String BillingStreet;
    String BillingCity;
    String BillingCode;
    String BillingCountry;
    String BillingAddress;
    String ShippingAddress;

    public AccountModel() {
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getEmployees() {
        return Employees;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public int getAnnualRevenue() {
        return AnnualRevenue;
    }

    public void setAnnualRevenue(int annualRevenue) {
        AnnualRevenue = annualRevenue;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getBillingStreet() {
        return BillingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        BillingStreet = billingStreet;
    }

    public String getBillingCity() {
        return BillingCity;
    }

    public void setBillingCity(String billingCity) {
        BillingCity = billingCity;
    }

    public String getBillingCode() {
        return BillingCode;
    }

    public void setBillingCode(String billingCode) {
        BillingCode = billingCode;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        BillingCountry = billingCountry;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountModel that = (AccountModel) o;
        return Employees == that.Employees && AnnualRevenue == that.AnnualRevenue && Objects.equals(AccountName, that.AccountName) && Objects.equals(Phone, that.Phone) && Objects.equals(Fax, that.Fax) && Objects.equals(Website, that.Website) && Objects.equals(Type, that.Type) && Objects.equals(Industry, that.Industry) && Objects.equals(Description, that.Description) && Objects.equals(BillingStreet, that.BillingStreet) && Objects.equals(BillingCity, that.BillingCity) && Objects.equals(BillingCode, that.BillingCode) && Objects.equals(BillingCountry, that.BillingCountry) && Objects.equals(BillingAddress, that.BillingAddress) && Objects.equals(ShippingAddress, that.ShippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountName, Phone, Fax, Website, Type, Employees, Industry, AnnualRevenue, Description, BillingStreet, BillingCity, BillingCode, BillingCountry, BillingAddress, ShippingAddress);
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "AccountName='" + AccountName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Fax='" + Fax + '\'' +
                ", Website='" + Website + '\'' +
                ", Type='" + Type + '\'' +
                ", Employees=" + Employees +
                ", Industry='" + Industry + '\'' +
                ", AnnualRevenue=" + AnnualRevenue +
                ", Description='" + Description + '\'' +
                ", BillingStreet='" + BillingStreet + '\'' +
                ", BillingCity='" + BillingCity + '\'' +
                ", BillingCode='" + BillingCode + '\'' +
                ", BillingCountry='" + BillingCountry + '\'' +
                ", BillingAddress='" + BillingAddress + '\'' +
                ", ShippingAddress='" + ShippingAddress + '\'' +
                '}';
    }

}
