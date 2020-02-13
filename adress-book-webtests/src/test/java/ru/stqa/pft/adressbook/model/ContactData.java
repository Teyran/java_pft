package ru.stqa.pft.adressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String mobPhone;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String mobPhone, String email, String bday, String month, String byear) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.mobPhone = mobPhone;
    this.email = email;
    this.bday = bday;
    this.bmonth = month;
    this.byear = byear;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getMobPhone() {
    return mobPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }
}
