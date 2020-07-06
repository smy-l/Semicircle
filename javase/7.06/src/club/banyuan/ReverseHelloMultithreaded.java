package club.banyuan;

public class ReverseHelloMultithreaded {
    public static void doReverseHello() {
//        Thread thread1 = new Thread();
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

    }
}
