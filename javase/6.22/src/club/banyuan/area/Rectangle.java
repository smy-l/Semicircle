package club.banyuan.area;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public String getShapeName(){
        return "矩形";
    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return (length + width) * 2;
    }
}
