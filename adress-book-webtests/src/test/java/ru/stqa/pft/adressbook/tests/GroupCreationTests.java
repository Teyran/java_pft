package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;



public class  GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getgroupList();
    GroupData group = new GroupData("TestGroup2", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getgroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

//    int max = 0;
//    for (GroupData g: after) {
//      if(g.getId() > max) {
//        max = g.getId();
//      }
//    }
    group.setId(after.stream().max((groupData, t1) -> Integer.compare(groupData.getId(), t1.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
