import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("1", "2");
    System.out.println(map);
    List<String> list = new ArrayList<>();
    list.add("id");
    list.add("2");
    System.out.println(list);
  }

}
