package ru.stqa.pft.adressbook.model;

import ru.stqa.pft.adressbook.tests.ContactPhoneTests;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String mobPhone;
  private String workPhone;
  private String homePhone;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String bday;
  private String bmonth;
  private String byear;
  private String group;
  private String allPhones;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }


  public String getAllPhones() {
    return allPhones;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData() {

  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
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

  public String getHomePhone () {
    return homePhone;
  }
  public String getMobPhone() {
    return mobPhone;
  }
  public String getWorkPhone() {
    return workPhone;
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
  public String getGroup() { return group; }
  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobPhone(String mobPhone) {
    this.mobPhone = mobPhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

}
