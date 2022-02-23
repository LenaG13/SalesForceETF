package steps;

import components.account.ContactDetailsComponent;
import components.forms.*;
import model.ContactModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactPage;

public class ContactsSteps extends AbstractStep {

    private ContactPage contactPage;

    public ContactsSteps(WebDriver driver) {
        super(driver);
    }

    public ContactsSteps createNewContact(ContactModel contactModel) {
        contactPage = new ContactPage(driver);
        contactPage.openNewContactForm();
        CreateContactFormComponent form = new CreateContactFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillContactForm(contactModel);
        //new Checkbox(driver).clickCheckBox();
        form.save();
        validatePageIsLoaded(contactPage);
        return this;
    }

    private void fillContactForm(ContactModel contactModel) {
        new DropContact(driver, "Salutation").selectOption(contactModel.getSalutation());
        new InputContact(driver, "First Name").insertContact(contactModel.getFirstName());
        new InputContact(driver, "Last Name").insertContact(contactModel.getLastName());
        new InputContact(driver, "Phone").insertContact(contactModel.getPhone());
        new InputContact(driver, "Mobile").insertContact(contactModel.getMobile());
        new DropContactList(driver, "Account Name").selectOption(contactModel.getAccountName());
        new InputContact(driver, "Title").insertContact(contactModel.getTitle());
        new InputContact(driver, "Email").insertContact(contactModel.getEmail());
        new TextArea(driver, "Description").write(contactModel.getDescription());
    }

    public void validateContactCreated(ContactModel expectedModel) {
        contactPage.openDetails();
        ContactModel actualModel = getActualContact();
        Assert.assertEquals(actualModel, expectedModel,
                String.format("Account is not valid: %s", actualModel));
    }

    private ContactModel getActualContact() {
        ContactModel actualModel = new ContactModel();
        actualModel.setName(new ContactDetailsComponent(driver, "Name").getNameLocator());
        //actualModel.setSalutation(new ContactDetailsComponent(driver, "Salutation", "text").getValue());
       // actualModel.setFirstName(new ContactDetailsComponent(driver, "FirstName", "text").getValue());
       // actualModel.setLastName(new ContactDetailsComponent(driver, "LastName", "text").getValue());
        actualModel.setPhone(new ContactDetailsComponent(driver, "Phone").getValue());
        actualModel.setMobile(new ContactDetailsComponent(driver, "Mobile").getValue());
        actualModel.setAccountName(new ContactDetailsComponent(driver, "AccountName").getAccountNameLocator());
        //actualModel.setAccountName(new ContactDetailsComponent(driver, "AccountName").getValue());
        actualModel.setTitle(new ContactDetailsComponent(driver, "Title").getValue());
        actualModel.setEmail(new ContactDetailsComponent(driver, "Email").getValue());
        actualModel.setDescription(new ContactDetailsComponent(driver, "Description").getValue());
        return actualModel;
    }

}
