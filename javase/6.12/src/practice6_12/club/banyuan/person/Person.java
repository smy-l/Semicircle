package practice6_12.club.banyuan.person;

public class Person {
    private String name;
    private int age;
    private static int personCount;
    private static int twoCount;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        personCount++;
        twoCount++;
    }

    public Person(String name) {
        this.name = name;
        personCount++;
    }

    public Person() {
        personCount++;
    }

    public static int getTwoCount() {
        return twoCount;
    }

    public static int getPersonCount() {
        return personCount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void speak() {
        System.out.println("姓名：" + getName() + " 年龄：" + getAge());
    }


}
