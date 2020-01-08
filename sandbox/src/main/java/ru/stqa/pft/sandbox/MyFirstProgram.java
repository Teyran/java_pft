package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Teyran");

    Square square = new Square(5);
    System.out.println("Площадь квадрата со стороной " + square.l + " = " + area(square));

    Rectangle rectangle = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + rectangle.a + " и " + rectangle.b + " = " + area(rectangle));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  public static double area (Square s) {
    return s.l * s.l;
  }
  public static double area(Rectangle r) {
    return r.a * r.b;
  }


}
