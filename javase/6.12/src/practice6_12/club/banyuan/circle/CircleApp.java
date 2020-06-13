package practice6_12.club.banyuan.circle;

public class CircleApp {

  public static void main(String[] args) {
    double rd = 12.3;
    System.out.println("半径 = " + rd);

    System.out.println("circle1");
    Circle circle1 = new Circle(rd);
    double cir1 = circle1.calPerimeter();
    double area1 = circle1.calArea();
    System.out.println("c1半径：" + circle1.getR());
    System.out.println("c1周长：" + cir1);
    System.out.println("c1面积：" + area1);
    System.out.println();

    System.out.println("circle2");
    Circle circle2 = new Circle(circle1);
    double cir2 = circle2.calPerimeter();
    double area2 = circle2.calArea();
    System.out.println("c2半径：" + circle2.getR());
    System.out.println("c2周长：" + cir2);
    System.out.println("c2面积：" + area2);
    System.out.println();

    //修改circle1的半径，不会修改circle2的半径
    System.out.println("修改circle1的半径-10");
    circle1.setRadius(10);
    System.out.println("circle1的半径：" + circle1.getR());
    System.out.println("circle2的半径：" + circle2.getR());
    System.out.println();

    //声明 Circle circle3 = circle2，当修改circle2的半径之后，
    // circle3的周长和面积是否发生变化。
    //不会发生变化
    System.out.println("声明 Circle circle3 = circle2");
    Circle  circle3 = circle2;
    double cir3 = circle3.calPerimeter();
    double area3 = circle3.calArea();
    System.out.println("c3周长：" + cir3);
    System.out.println("c3面积：" + area3);
    System.out.println();

    System.out.println("修改circle2半径后-8");
    circle2.setRadius(8);
    System.out.println("c3周长：" + cir3);
    System.out.println("c3面积：" + area3);
    System.out.println();

    System.out.println("执行circle2 = null");
    circle2 = null;
    System.out.println(circle2);
    System.out.println(circle3);


  }
}
