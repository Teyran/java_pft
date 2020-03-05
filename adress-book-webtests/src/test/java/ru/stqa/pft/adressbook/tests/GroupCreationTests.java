package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;



public class  GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("TestGroup1", null, null);
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);
//    1 СПОСОБ СРАВНЕНИЯ.МНОЖЕСТВА И СРАВНЕНИЕ ПО ИДЕНТИФИКАТОРУ (При создании новой группы, у группы максимальный идентификатор)
//    group.setId(after.stream().max((groupData, t1) -> Integer.compare(groupData.getId(), t1.getId())).get().getId());
//    before.add(group);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

//  2 СПОСОБ СРАВНЕНИЯ.СОРТИВКА СПИСКОВ И СРАВНЕНИЕ БЕЗ УЧЕТА ИДЕНТИФИКАТОРА(Так как предварительно списки отсоритированы)
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
