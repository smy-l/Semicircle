package club.banyuan.ClassPractice6_11.cat;
import club.banyuan.ClassPractice6_11.dog.Dog;

public class Cat {
    private String name;
    private String color;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void print() {
        System.out.println(getColor() + "的" + getName());
    }

    public void playWith(Dog dog){
        print();
        System.out.println("和狗一起玩");
        dog.print();
    }
}
