package saleforce;

import builders.ContactBuilder;
import model.ContactModel;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactTest extends BaseTest{

    ContactModel testContact = ContactModelUtils.getDefaultContactModel();
    ContactModel expectedResult = ContactBuilder.defaultContact().build();

    @Test
    public void addNewContactTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCreds()
                .openContactPage()
                .createNewContact(testContact)
                .validateContactCreated(testContact);
    }

}
