package ru.stqa.pft.adressbook.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    String contactDelMessage = app.contact().getSuccessfullDeletionMessage();
    Assert.assertEquals(contactDelMessage, "Record successful deleted");
    app.goTo().goToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(after, before);
  }


}
