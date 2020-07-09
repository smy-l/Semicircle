package timed;

import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;

public class Philosophy implements Callable<String> {

    private static final Random rand = new Random();

    private int eatTimes;
    private int thinkTimes;
    private int hungryTimes;
    String name;

    public int getEatTimes() {
        return eatTimes;
    }

    public int getThinkTimes() {
        return thinkTimes;
    }

    public int getHungryTimes() {
        return hungryTimes;
    }

    public String getName() {
        return name;
    }

    public Philosophy(String name, Chopsticks left, Chopsticks right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    private Chopsticks left;
    private Chopsticks right;


    // @Override
    public void run() {
        while (true) {
            try {
                if (rand.nextBoolean()) {
                    eat();
                } else {
                    think();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private void think() {
        System.out.println(getName() + "准备思考");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
//            e.printStackTrace();
        }
        System.out.println(getName() + "思考完成");
        thinkTimes++;
    }

    private void eat() throws InterruptedException {
        System.out.println(getName() + "准备吃饭");
        if (!this.left.take(this)) {
            System.out.println(getName() + "饿肚子");
            hungryTimes++;
            return;
        }
        Thread.sleep(500);
        if (!this.right.take(this)) {
            this.left.put(this);
            System.out.println(getName() + "饿肚子");
            hungryTimes++;
            return;
        }
        Thread.sleep(500);
        System.out.println(getName() + "吃饭完成");
        eatTimes++;
        this.right.put(this);
        this.left.put(this);
    }

    @Override
    public String call() throws Exception {
        while (!interrupted()) {
            try {
                if (rand.nextBoolean()) {
                    eat();
                } else {
                    think();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                if (left.isToken()) {
                    left.put(this);
                }
                if (right.isToken()) {
                    right.put(this);
                }
//                e.printStackTrace();
            }
        }
        return this.toString();
    }

    @Override
    public String toString() {
        return getName() + "{" +
                "eatTimes=" + eatTimes +
                ", thinkTimes=" + thinkTimes +
                ", hungryTimes=" + hungryTimes +
                '}';
    }
}
