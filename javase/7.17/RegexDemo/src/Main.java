public class Main {
  public static boolean validateQQ(String qq) {
    String str = qq.substring(0, 1);
    try {
      if (str.equals("0") || qq.length() > 10 || qq.length() < 7) {
        return false;
      }
      int num = Integer.parseInt(qq);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(Main.validateQQ("0123123213"));
    System.out.println(Main.validateQQ("231s23213"));
    System.out.println(Main.validateQQ("123213"));
    System.out.println(Main.validateQQ("1232130000000"));
    System.out.println(Main.validateQQ("123123213"));
  }

}
