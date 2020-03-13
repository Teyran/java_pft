package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  private Contacts contactsCache;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
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
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobPhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    attach(By.name("photo"), contactData.getPhoto());
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void acceptAllert() {
    wd.switchTo().alert().accept();
  }

  public void pressDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id +"']/img")).click();
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void create(ContactData contact) {
    fillContactForm(contact, true);
    pressSubmitButton();
    contactsCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm( contact, false);
    submitContactModification();
    contactsCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    pressDeleteButton();
    contactsCache = null;
    acceptAllert();
  }

  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    WebElement table = wd.findElement(By.xpath("//table[@id='maintable']"));
    List <WebElement> rows = table.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement row: rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contactsCache.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAllPhones(allPhones)
              .withAllEmails(allEmails));
    }
    return contactsCache;
  }

  public String getSuccessfullDeletionMessage() {
    return readTextFrom(By.className("msgbox"));
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile =  wd. findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstName)
            .withLastName(lastName)
            .withHomePhone(home)
            .withMobPhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }
}
