package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class  GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {"test 1", "header 1", "footer 1"});
    list.add(new Object[] {"test 2", "header 2", "header 3"});
    list.add(new Object[] {"test 3", "header 3", "footer 3"});
    list.add(new Object[] {"test 4", "header 4", "footer 4"});
    list.add(new Object[] {"test 5", "header 5", "footer 5"});
    list.add(new Object[] {"test 6", "header 6", "footer 6"});
    list.add(new Object[] {"test 7", "header 7", "footer 7"});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(String name, String header, String footer) {
      GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));

  }

  @Test
  public void testGroupCreationBad() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
