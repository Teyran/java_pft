package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    app.goTo().goToAddNewPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("newName", "newMiddleName", "newLastName", "newNickName", "newTitle", "8888", "qwert@mail.ru", "11", "May", "1993", "TestGroup1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "modifiedName", "modifiedMiddleName", "modifiedLastName", "modifiedNickName", "modifiedTitle", "333", "qwert@mail.ru", "15", "April", "1993", null);
    app.getContactHelper().fillContactForm( contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
