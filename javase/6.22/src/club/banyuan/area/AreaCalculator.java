package club.banyuan.area;

public class AreaCalculator {
//    public void show(Shape shape) {
//        System.out.println("形状");
//        System.out.println(shape.getShapeName() + "面积是" + String.format("%.1f", shape.area()));
//        System.out.println(shape.getShapeName() + "周长是" + String.format("%.1f", shape.perimeter()));
//    }

    public void show(Circle circle) {
//        System.out.println("圆形");
        System.out.println(circle.getShapeName() + "面积是" + String.format("%.1f", circle.area()));
        System.out.println(circle.getShapeName() + "周长是" + String.format("%.1f", circle.perimeter()));
    }

    public void show(Rectangle rectangle) {
        System.out.println(rectangle.getShapeName() + "面积是" + String.format("%.1f", rectangle.area()));
        System.out.println(rectangle.getShapeName() + "周长是" + String.format("%.1f", rectangle.perimeter()));
    }

}
