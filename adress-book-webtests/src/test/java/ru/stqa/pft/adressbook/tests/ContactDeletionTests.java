package ru.stqa.pft.adressbook.tests;

import java.util.List;
import java.util.Set;

import javafx.css.Match;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().
              withFirstName("newName").withLastName("newLastName").withMiddleName("newMiddleName").withNickName("newNickName").withTitle("newTitle").withMobPhone("8888").withEmail("qwert@mail.ru").withBday("11").withBmonth("May").withByear("1993").withGroup("TestGroup1"));
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    String contactDelMessage = app.contact().getSuccessfullDeletionMessage();
    Assert.assertEquals(contactDelMessage, "Record successful deleted");
    app.goTo().goToHomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(),equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
