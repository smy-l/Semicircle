package club.banyuan;

public class Main {

  public static void main(String[] args) {

    try {
      if (args.length < 1) {
        throw new RuntimeException("参数不合法");
      }

      String cmd = args[0];
      switch (cmd) {
        case "ls":
          ls(args);
          break;
        case "cp":
          cp(args);
          break;
        case "cat":
          cat(args);
          break;
        case "rm":
          rm(args);
          break;
        default:
          throw new RuntimeException("不认识的命令" + cmd);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static void cat(String[] args) {

  }

  private static void rm(String[] args) {

  }

  private static void cp(String[] args) {

  }

  private static void ls(String[] args) {

  }

}
