package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToAddNewPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("newName", "newMiddleName", "newLastName", "newNickName", "newTitle", "8888", "qwert@mail.ru", "11", "May", "1993", "TestGroup1"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("modifiedName", "modifiedMiddleName", "modifiedLastName", "modifiedNickName", "modifiedTitle", "333", "qwert@mail.ru", "15", "April", "1993", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
