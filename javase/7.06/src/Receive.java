import java.util.Scanner;

public class Receive extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            try {
                for (char c : input.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Receive receive = new Receive();
        receive.start();
    }
}
