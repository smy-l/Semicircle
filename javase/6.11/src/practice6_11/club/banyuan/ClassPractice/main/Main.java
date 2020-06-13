package practice6_11.club.banyuan.ClassPractice.main;

import practice6_11.club.banyuan.ClassPractice.cat.Cat;
import practice6_11.club.banyuan.ClassPractice.dog.Dog;

public class Main {
    public static void main(String[] args) {
        Dog hashiqi = new Dog();
        hashiqi.setName("哈士奇");
        hashiqi.setIq(-100);

        Dog jinmao = new Dog();
        jinmao.setName("金毛");
        jinmao.setIq(100);

        Dog keji = new Dog();
        keji.setIq(40);
        keji.setName("柯基");

        Cat bosi = new Cat();
        bosi.setName("波斯");
        bosi.setColor("白色");

        Cat yingduan = new Cat();
        yingduan.setName("英短");
        yingduan.setColor("黑色");

        hashiqi.print();
        jinmao.print();
        keji.print();
        bosi.print();
        yingduan.print();

        bosi.playWith(keji);

    }
}
