package practice6_12.club.banyuan.product;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("手机", 2000);
        System.out.println(p1.getName());
        System.out.println(p1.getScanCode());
        System.out.println(p1.getPrice());
        System.out.println();

        System.out.println("=====修改price=====");
        p1.changePrice(2001.02);
        System.out.println(p1.getPrice());
        System.out.println();

        System.out.println("=====设置数量=====");
        p1.setNum(1234);
        System.out.println("产品数量" + p1.getNum());
        System.out.println();

        System.out.println("=====getInfo=====");
        System.out.println(p1.getInfo());

        System.out.println("=====buy2000个=====");
        System.out.println("库存是否充足：" + p1.buy(2000));

        System.out.println("=====buy1000个=====");
        System.out.println("库存是否充足：" + p1.buy(1000));

        System.out.println("=====buy500=====");
        System.out.println("库存是否充足：" + p1.buy(500));

        Product p2 = new Product("电脑",5000);
        System.out.println(p2.getInfo());

    }
}
