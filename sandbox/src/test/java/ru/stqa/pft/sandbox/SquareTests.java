package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Square square = new Square(5);
    Assert.assertEquals(square.area(),  25);
  }

  @Test
  public void distanceBetweenPoints() {
    Point pointAC = new Point(3,4,7,1);
    Assert.assertEquals(pointAC.distanceBetweenTwoPoints(), 5);
  }
}
