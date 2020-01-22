package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Teyran");

    Square square = new Square(5);
    System.out.println("Площадь квадрата со стороной " + square.l + " = " + square.area());

    Rectangle rectangle = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + rectangle.a + " и " + rectangle.b + " = " + rectangle.area());

    Point pointAB = new Point(3.f, 4.f, 7.f, 1.f);
    System.out.println("Расстояние между двумя заданными точками равно " + pointAB.distanceBetweenTwoPoints());
  }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}
