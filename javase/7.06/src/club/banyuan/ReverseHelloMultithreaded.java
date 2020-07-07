package club.banyuan;

import java.awt.*;

public class ReverseHelloMultithreaded extends Thread {
    private final int num;

    public ReverseHelloMultithreaded(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            if (num < 50) {
                ReverseHelloMultithreaded r = new ReverseHelloMultithreaded(num + 1);
                r.start();
                r.join();
            }
            System.out.println("Hello from thread " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void doReverseHello() {
        ReverseHelloMultithreaded r1 = new ReverseHelloMultithreaded(1);
        r1.start();
    }
}
