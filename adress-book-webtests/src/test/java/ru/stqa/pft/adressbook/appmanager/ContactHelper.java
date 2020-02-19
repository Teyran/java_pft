package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.model.ContactData;

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

  public void  fillContactForm(ContactData contactData, boolean creation) {

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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void acceptAllert() {
    wd.switchTo().alert().accept();
  }

  public void pressDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification() {
    click(By.xpath("//tr[last()]//img[@alt='Edit']"));
  }




}
