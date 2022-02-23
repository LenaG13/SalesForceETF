package builders;

import model.ContactModel;

public class ContactBuilder {

    ContactModel contactModel = new ContactModel();

    public static ContactBuilder newValues() {
        return new ContactBuilder();
    }

    public static ContactModel buildDefault() {
        ContactModel contactModel = new ContactModel();
        contactModel.setSalutation("Mrs.");
        contactModel.setFirstName("Elena");
        contactModel.setLastName("Nikitina");
        contactModel.setPhone("+375295549408");
        contactModel.setMobile("+375335687832");
        contactModel.setAccountName("USER1");
        contactModel.setTitle("Manager");
        contactModel.setEmail("len@gmail.com");
        contactModel.setDescription("Identifying and working with element objects");
        return contactModel;
    }

    public static ContactBuilder defaultContact() {
        ContactModel contactModel = new ContactModel();
        contactModel.setSalutation("Mrs.");
        contactModel.setFirstName("Elena");
        contactModel.setLastName("Nikitina");
        contactModel.setPhone("+375295549408");
        contactModel.setMobile("+375335687832");
        contactModel.setAccountName("USER1");
        contactModel.setTitle("Manager");
        contactModel.setEmail("len@gmail.com");
        contactModel.setDescription("Identifying and working with element objects");
        return new ContactBuilder(contactModel);
    }

    public ContactBuilder() {
    }

    public ContactBuilder(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public ContactBuilder setSalutation(String salutation) {
        this.contactModel.setSalutation(salutation);
        return this;
    }

    public ContactBuilder setFirstName(String firstName) {
        this.contactModel.setFirstName(firstName);
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        this.contactModel.setLastName(lastName);
        return this;
    }

    public ContactBuilder setPhone(String phone) {
        this.contactModel.setPhone(phone);
        return this;
    }

    public ContactBuilder setMobile(String mobile) {
        this.contactModel.setMobile(mobile);
        return this;
    }

    public ContactBuilder setTitle(String title) {
        this.contactModel.setTitle(title);
        return this;
    }

    public ContactBuilder setEmail(String email) {
        this.contactModel.setEmail(email);
        return this;
    }

    public ContactBuilder setName(String name) {
        this.contactModel.setName(name);
        return this;
    }

    public ContactBuilder setDescription(String description) {
        this.contactModel.setDescription(description);
        return this;
    }

    public ContactModel build() {
        return contactModel;
    }

}
