import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TextDemo {
  public static void main(String[] args) {
    String str = "123\n123\n123\n";
//    BufferedReader reader = new BufferedReader(new InputStreamReader());

    System.out.println(Arrays.toString(str.getBytes()));

    byte[] bytes = str.getBytes();
  }
}
