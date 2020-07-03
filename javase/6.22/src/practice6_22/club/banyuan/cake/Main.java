package practice6_22.club.banyuan.cake;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Cake[] cakes = new Cake[10];

        Random random = new Random(10);
        for (int i = 0; i < cakes.length; i++) {
            if (i % 2 == 0) {
                cakes[i] = new ReadyMadeCake(i, random.nextDouble() * 20, random.nextInt(20));
            } else {
                cakes[i] = new OrderCake(i, random.nextDouble() * 20, random.nextInt(20));
            }
        }

        for (Cake cake : cakes) {
            cake.price = cake.calcPrice();
            System.out.println(cake.toString());
        }
        System.out.println();


        double total = 0.0;
        for (Cake cake : cakes) {
//            total += cake.calcPrice();
            total += cake.price;
        }
        System.out.printf("总价为：%.2f\n", total);
        System.out.println();


        double readMadeCakePriceTotal = 0.0;
        double readMadeCakeQuantityTotal = 0.0;

        for (Cake cake : cakes) {
            if (cake instanceof ReadyMadeCake) {
                ReadyMadeCake readyMadeCake = (ReadyMadeCake) cake;
                readMadeCakeQuantityTotal += readyMadeCake.getQuantity();
                readMadeCakePriceTotal += readyMadeCake.price;
            }
        }
        System.out.printf("ReadyMadeCake蛋糕的总价: %.2f\n",readMadeCakePriceTotal);
        System.out.println("ReadyMadeCake蛋糕的数量" + readMadeCakeQuantityTotal);
        System.out.println();

        double maxPrice = 0.0;
        int maxPriceIndex = 0;
        for (int i = 0; i < cakes.length; i++) {
            if (maxPrice < cakes[i].price) {
                maxPriceIndex = i;
                maxPrice = cakes[i].price;
            }
        }

        if (cakes[maxPriceIndex] instanceof ReadyMadeCake) {
            ReadyMadeCake r = (ReadyMadeCake) cakes[maxPriceIndex];
            System.out.printf("价格最高的蛋糕种类：ReadyMadeCake  id: %d  price: %.2f  quantity: %d\n", r.id, r.price, r.getQuantity());
        } else {
            OrderCake r = (OrderCake) cakes[maxPriceIndex];
            System.out.printf("价格最高的蛋糕种类：OrderCake  id: %d  price: %.2f  weightInKG: %d\n", r.id, r.price, r.getWeightInKG());
        }
    }
}
