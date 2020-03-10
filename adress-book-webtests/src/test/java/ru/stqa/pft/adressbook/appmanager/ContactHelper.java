package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void pressSubmitButton() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void submitContactModification () {
    click(By.name("update"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("mobile"), contactData.getMobPhone());
    type(By.name("email"), contactData.getEmail());
    click(By.name("bday"));
    selectFromList(By.name("bday"), contactData.getBday());
    click(By.name("bmonth"));
    selectFromList(By.name("bmonth"), contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());

    if (creation) {
      selectFromList(By.name("new_group"),contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void acceptAllert() {
    wd.switchTo().alert().accept();
  }

  public void pressDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//td/a/img[@src='icons/pencil.png']")).get(index).click();
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    fillContactForm(contact, true);
    pressSubmitButton();
    returnToHomePage();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groups.add(group);
    }
    return groups;
  }

  public List<ContactData> getContactList() {
    List <ContactData> contacts = new ArrayList<>();
    WebElement table = wd.findElement(By.xpath("//table[@id='maintable']"));
    List <WebElement> rows = table.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement row: rows) {
      String firstName = row.findElement(By.xpath("./td[3]")).getText();
      String lastName = row.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData(id, firstName, lastName, null, null, null, null, null, null, null, null, null));
    }
    return contacts;
  }

  public String getSuccessfullDeletionMessage() {
    return readTextFrom(By.className("msgbox"));
  }

}
