package practice6_12.club.banyuan.circle;

public class Circle {

  private double r;
//  double cir;
//  double Area;

  public Circle(double r) {
    this.r = r;
  }

  public Circle(Circle circle){
    r = circle.r;
  }

  public void setRadius(double r) {
    this.r = r;
  }

  double calPerimeter() {
    return 2 * Math.PI * r;
  }

  public double calArea() {
    return Math.PI * r * r;
  }

  public double getR() {
    return r;
  }
}
