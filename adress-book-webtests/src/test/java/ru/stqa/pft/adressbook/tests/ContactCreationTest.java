package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().
            withFirstName("newName").withLastName("newLastName").withMiddleName("newMiddleName").withNickName("newNickName").withTitle("newTitle").withMobPhone("8888").withEmail("qwert@mail.ru").withBday("11").withBmonth("May").withByear("1993").withGroup("TestGroup1");
    app.goTo().addNewPage();
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byString = (c1,c2) -> c1.toString().compareTo(c2.toString());
    before.sort(byString);
    after.sort(byString);
    Assert.assertEquals(before, after);
  }


}
