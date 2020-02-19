package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("TestGroup1","TestGroup2","TestGroup3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
