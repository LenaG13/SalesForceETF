package utils;

import model.ContactModel;

public class ContactModelUtils {

    public static ContactModel getDefaultContactModel() {
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

}
