package practice6_28.club.banyuan.anonymous;

public class Main {

    public static void show(Bird bird) {
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {

        show(new Bird() {
            //TODO
            {  //构造代码块   相当于构造方法
                setName("燕子");
//                this.setName("燕子");   //通过子类调用setName方法，寻找子类中有无重写方法，
                                         //如果有，则调用重写的方法，没有去父类
//                super.setName("燕子");  //通过父类调用setName方法
            }

            @Override
            public int fly() {
                return 1000;
            }
        });
    }
}