import java.util.Random;

public class MathTest {
    public static void main(String[] args) {
        //Math
        int abs = Math.abs(-1);
        System.out.println("(-1)abs: " + abs);

        double ceil = Math.ceil(20.4);
        System.out.println("(20.4)ceil: " + ceil);

        double floor = Math.floor(20.6);
        System.out.println("(20.6)floor: " + floor);

        double round1 = Math.round(10.1);
        double round2 = Math.round(20.7);
        System.out.println("(10.1)round1: " + round1 + "\n(20.7)round2: " + round2);

        double randomEx = Math.random();
        System.out.println("randomEx: " + randomEx);

        Random ex = new Random();
        int random = ex.nextInt(20);
        System.out.println("random: " + random);
    }
}
