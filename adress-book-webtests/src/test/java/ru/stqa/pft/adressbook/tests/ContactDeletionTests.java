package ru.stqa.pft.adressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test(enabled = false)
  public void testContactDeletion() throws Exception {
    app.goTo().goToAddNewPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("newName", "newMiddleName", "newLastName", "newNickName", "newTitle", "8888", "qwert@mail.ru", "11", "May", "1993", "TestGroup1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().pressDeleteButton();
    app.getContactHelper().acceptAllert();
    String contactDelMessage = app.getContactHelper().getSuccessfullDeletionMessage();
    Assert.assertEquals(contactDelMessage, "Record successful deleted");
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(after, before);
  }

}
