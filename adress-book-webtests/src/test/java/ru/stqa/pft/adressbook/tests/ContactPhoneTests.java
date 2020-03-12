package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones () {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditFrom)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobPhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
