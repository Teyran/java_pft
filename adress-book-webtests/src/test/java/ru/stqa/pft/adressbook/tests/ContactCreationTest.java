package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().
            withFirstName("newName").withLastName("newLastName").withMiddleName("newMiddleName").withNickName("newNickName").withTitle("newTitle").withMobPhone("8888").withEmail("qwert@mail.ru").withBday("11").withBmonth("May").withByear("1993").withGroup("TestGroup1").withPhoto(photo);
    app.goTo().addNewPage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            after.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
