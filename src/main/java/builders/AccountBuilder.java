package builders;

import model.AccountModel;

public class AccountBuilder {

    AccountModel accountModel = new AccountModel();

    public static AccountBuilder newValues() {
        return new AccountBuilder();
    }

    public static AccountModel buildDefault() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USER1");
        accountModel.setPhone("+48534032897");
        accountModel.setFax("+48534033654");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setType("Integrator");
        accountModel.setEmployees(13);
        accountModel.setIndustry("Energy");
        //accountModel.setAnnualRevenue(13000);
        accountModel.setDescription("Identifying and working with element objects in the DOM");
        accountModel.setBillingStreet("Magiczna");
        accountModel.setBillingCity("Warszawa");
        accountModel.setBillingCode("12-345");
        accountModel.setBillingCountry("Polska");
        return accountModel;
    }

    public static AccountBuilder defaultAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USER1");
        accountModel.setPhone("+48534032897");
        accountModel.setFax("+48534033654");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setType("Integrator");
        accountModel.setEmployees(13);
        accountModel.setIndustry("Energy");
        //accountModel.setAnnualRevenue(13000);
        accountModel.setDescription("Identifying and working with element objects in the DOM");
        //accountModel.setBillingStreet("Magiczna");
        //accountModel.setBillingCity("Warszawa");
        //accountModel.setBillingCode("12-345");
        //accountModel.setBillingCountry("Polska");
        return new AccountBuilder(accountModel);
    }

    public AccountBuilder() {
    }

    public AccountBuilder(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    public AccountBuilder setAccountName(String accountName) {
        this.accountModel.setAccountName(accountName);
        return this;
    }

    public AccountBuilder setPhone(String phone) {
        this.accountModel.setPhone(phone);
        return this;
    }

    public AccountBuilder setFax(String fax) {
        this.accountModel.setFax(fax);
        return this;
    }

    public AccountBuilder setWebsite(String website) {
        this.accountModel.setWebsite(website);
        return this;
    }

    public AccountBuilder setType(String type) {
        this.accountModel.setType(type);
        return this;
    }

    public AccountBuilder setEmployees(int employees) {
        this.accountModel.setEmployees(employees);
        return this;
    }

    public AccountBuilder setIndustry(String industry) {
        this.accountModel.setIndustry(industry);
        return this;
    }

    public AccountBuilder setAnnualRevenue(int annualRevenue) {
        this.accountModel.setAnnualRevenue(annualRevenue);
        return this;
    }

    public AccountBuilder setDescription(String description) {
        this.accountModel.setDescription(description);
        return this;
    }

    public AccountBuilder setBillingStreet(String billingStreet) {
        this.accountModel.setBillingStreet(billingStreet);
        return this;
    }

    public AccountBuilder setBillingCity(String billingCity) {
        this.accountModel.setBillingCity(billingCity);
        return this;
    }

    public AccountBuilder setBillingCode(String billingCode) {
        this.accountModel.setBillingCode(billingCode);
        return this;
    }

    public AccountBuilder setBillingCountry(String billingCountry) {
        this.accountModel.setBillingCountry(billingCountry);
        return this;
    }

    public AccountModel build() {
        return accountModel;
    }

}
