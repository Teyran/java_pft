package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("TestGroup1", "TestGroup2", "TestGroup3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }
}
