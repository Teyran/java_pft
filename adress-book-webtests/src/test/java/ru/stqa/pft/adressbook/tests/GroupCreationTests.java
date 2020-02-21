package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import javax.management.MBeanRegistration;
import java.util.List;

public class  GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getgroupList();
    app.getGroupHelper().createGroup(new GroupData("TestGroup1","TestGroup2","TestGroup3"));
    List<GroupData> after = app.getGroupHelper().getgroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
