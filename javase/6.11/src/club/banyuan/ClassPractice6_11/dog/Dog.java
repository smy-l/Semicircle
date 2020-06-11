package club.banyuan.ClassPractice6_11.dog;
import  club.banyuan.ClassPractice6_11.cat.Cat;

public class Dog {
    private String name;
    private int iq;

    public void setName(String name) { this.name = name; }

    public void setIq(int iq) { this.iq = iq; }

    public int getIq() { return iq; }

    public String getName() {
        return name;
    }

    public void print() {
        if (getIq() < 20) {
            System.out.println(getName() + " 傻");
        } else if (getIq() > 20 & getIq() < 80) {
            System.out.println(getName() + " 还可以");
        } else {
            System.out.println(getName() + " 聪明");
        }
    }

    public void playwith(Cat cat){
        print();
        System.out.println("和猫一起玩");
        cat.print();
    }


}
