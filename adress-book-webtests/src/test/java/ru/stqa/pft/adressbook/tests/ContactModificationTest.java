package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("modifiedName", "modifiedMiddleName", "modifiedLastName", "modifiedNickName", "modifiedTitle", "333", "qwert@mail.ru", "15", "April", "1993"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }

}
