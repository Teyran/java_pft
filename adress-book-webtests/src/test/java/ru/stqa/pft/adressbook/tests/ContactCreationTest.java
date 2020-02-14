package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.appmanager.ContactHelper;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.tests.TestBase;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().fillContactForm(new ContactData("newName", "newMiddleName", "newLastName", "newNickName", "newTitle", "8888", "qwert@mail.ru", "11", "May", "1993", "TestGroup1"), true);
    app.getContactHelper().pressSubmitButton();
    app.getNavigationHelper().returnToHomePage();
  }


}
