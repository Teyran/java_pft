package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
  private final int id;
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
  private final String group;

  public ContactData(int id, String firstName, String lastName, String middleName, String nickName, String title, String mobPhone, String email, String bday, String month, String byear, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.nickName = nickName;
    this.title = title;
    this.mobPhone = mobPhone;
    this.email = email;
    this.bday = bday;
    this.bmonth = month;
    this.byear = byear;
    this.group = group;
  }

  public ContactData( String firstName, String lastName, String middleName, String nickName, String title, String mobPhone, String email, String bday, String month, String byear, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.nickName = nickName;
    this.title = title;
    this.mobPhone = mobPhone;
    this.email = email;
    this.bday = bday;
    this.bmonth = month;
    this.byear = byear;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() { return group; }

  public int getId() {
    return id;
  }
}
