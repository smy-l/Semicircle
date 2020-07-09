import javax.swing.*;
import java.io.*;

public class SplitFile {

  /**
   * @param sourceFile   目标文件
   * @param size         拆分文件大小 byte为单位
   * @param targetFolder 生成的拆分文件路径，如果传入的路径不存在，则创建这个路径
   *                     拆分文件的命名规则，原始文件名.编号。
   *                     例如 WIN.mp3 拆分后，变为 WIN.mp3.1  WIN.mp3.2 ....
   */
  public static void split(File sourceFile, int size, File targetFolder) throws IOException {

    InputStream is = new FileInputStream(sourceFile);
//    OutputStream os = new FileOutputStream(targetFolder);
    byte[] buf = new byte[size];
    int count = 0;
    int index = 1;
    while ((count = is.read(buf)) > 0) {
      OutputStream os = new FileOutputStream(new File(targetFolder, sourceFile.getName() + "." + index++));
      os.write(buf, 0, count);
      os.close();
    }
    is.close();
  }

  /**
   * 将制定文件夹下的拆分文件合并为一个文件，将文件保存到指定的路径下
   *
   * @param sourceFolder 拆分文件所处的路径，其下的文件命名规则，同split拆分出来的文件名一致
   * @param targetFolder 合并之后的文件保存的路径，如果路径不存在，则创建这个目录
   */
  public static void combine(File sourceFolder, File targetFolder) throws IOException {
    InputStream is = new FileInputStream(sourceFolder);
    OutputStream os = new FileOutputStream(targetFolder);
    byte[] buf = new byte[(int) sourceFolder.length()];
    int count = 0;
//    int index = (int) sourceFolder.length() * i;
    while ((count = is.read(buf)) > 0) {
      os.write(buf, 0, count);
    }
  }

  public static void main(String[] args) throws IOException {
//    File WIN = new File("/Users/edz/Semicircle/javase/7.09/SplitFile/doc/WIN.mp3");
    File WIN = new File("D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\doc\\WIN.mp3");
//    File WinSplit = new File("/Users/edz/Semicircle/javase/7.09/SplitFile/WinSplit");
    File WinSplit = new File("D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\WinSplit");
    if (!WinSplit.exists()) {
      WinSplit.mkdir();
    }
    split(WIN, 1024 * 9, WinSplit);

//    File winCombineLast = new File("/Users/edz/Semicircle/javase/7.09/SplitFile/WinSplit/WIN.mp3");
    File winCombineLast = new File("D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\WinSplit\\WIN.mp3");
    winCombineLast.createNewFile();
    File[] winCombine = new File[10];
    for (int i = 0; i < winCombine.length; i++) {
//      winCombine[i] = new File("/Users/edz/Semicircle/javase/7.09/SplitFile/WinSplit/WIN.mp3." + i + 1);
      winCombine[i] = new File("D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\WinSplit\\WIN.mp3." + (i + 1));
//      System.out.println(winCombine[i].length());
      combine(winCombine[i], winCombineLast);
    }

  }
}

