import java.util.Scanner;

class Shape {
  protected String shapeName;

  Shape(String shapeName) {
    this.shapeName = shapeName;
}

  Double calculateArea() {
    return Double.valueOf(0);
}  
}

class Square extends Shape {
  private Integer side;
  
  Square(Integer side) {
    super("Square");
    this.side = side;
}
  public Integer getSide() {
    return side;
}

public void setSide(Integer side) {
   this.side = side;
}
  
  Double calculateArea() {
    return Double.valueOf(side * side);
} 
}

class Rectangle extends Shape {
  private Integer length;
  private Integer breadth;
  
  Rectangle(Integer length, Integer breadth) {
    super("Rectangle");
    this.length = length;
    this.breadth = breadth;
}
  
public Integer getLength() {
    return length;
}

public void setLength(Integer length) {
   this.length = length;
}

public Integer getbreadth() {
    return breadth;
}

public void setBreadth(Integer breadth) {
   this.breadth = breadth;
}

  Double calculateArea() {
    return Double.valueOf(length * breadth);
} 
}

class Circle extends Shape {
  private Integer radius;
  
  Circle(Integer radius) {
    super("Circle");
    this.radius = radius;
}

public Integer getRadius() {
    return radius;
}

public void setRadius(Integer radius) {
   this.radius = radius;
}
  
  Double calculateArea() {
    return Double.valueOf(Math.PI * radius * radius);
} 
}


class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("\n1. Rectangle\n\n" + "2. Square\n\n" + "3. Circle\n\n" + "Area Calculator --- Choose your shape\n");
  Integer choice = sc.nextInt();
  sc.nextLine();

  switch(choice) {
    case 1:
    System.out.println("\nEnter length and breadth:\n");
    Integer length = sc.nextInt();
    System.out.println();
    Integer breadth = sc.nextInt();
    Rectangle rectangle = new Rectangle(length, breadth);
    System.out.printf("\nArea of Rectangle is: %.2f", rectangle.calculateArea());
    break;
   case 2:
    System.out.println("\nEnter side:\n");
    Integer side = sc.nextInt();
    Square square = new Square(side);
    System.out.printf("\nArea of Square is: %.2f", square.calculateArea());
    break;
   case 3:
    System.out.println("\nEnter Radius:\n");
    Integer radius = sc.nextInt();
    Circle circle = new Circle(radius);
    System.out.printf("\nArea of Circle is: %.2f", circle.calculateArea());;
    break;
}
}
}