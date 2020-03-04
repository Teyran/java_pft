package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.appmanager.ContactHelper;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("newName", "newLastName", "newMiddleName", "newNickName", "newTitle", "8888", "qwert@mail.ru", "11", "May", "1993", "TestGroup1");
    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byString = (c1,c2) -> c1.toString().compareTo(c2.toString());
    before.sort(byString);
    after.sort(byString);
    Assert.assertEquals(before, after);
  }


}
