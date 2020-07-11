import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class SplitFile {

  /**
   * @param sourceFile   目标文件
   * @param size         拆分文件大小 byte为单位
   * @param targetFolder 生成的拆分文件路径，如果传入的路径不存在，则创建这个路径
   *                     拆分文件的命名规则，原始文件名.编号。
   *                     例如 WIN.mp3 拆分后，变为 WIN.mp3.1  WIN.mp3.2 ....
   */
  public static void split(File sourceFile, int size, File targetFolder) {

    if (targetFolder == null) {
      throw new RuntimeException("目标路径不合法");
    }

    if (sourceFile == null) {
      throw new RuntimeException("源文件不合法");
    }

    if (!targetFolder.exists()) {
      targetFolder.exists();
    }

    int splitNum = (int) Math.ceil(sourceFile.length() / (double) size);
    String name = sourceFile.getName();
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;

    try {
      fileInputStream = new FileInputStream(sourceFile);
      byte[] buf = new byte[1024];
      int count = 0;
      for (int i = 0; i < splitNum; i++) {
        File file = new File(targetFolder.getCanonicalFile(), name + "." + (i + 1));
        fileOutputStream = new FileOutputStream(file);
        int finish = 0;
        while ((count = fileInputStream.read(buf, 0, Math.min(buf.length, size - finish))) > 0) {
          fileOutputStream.write(buf, 0, count);
          finish += count;
        }

        fileOutputStream.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fileInputStream);
      closeStream(fileOutputStream);
    }
//    InputStream is = new FileInputStream(sourceFile);
//    byte[] buf = new byte[size];
//    int count = 0;
//    int index = 1;
//    while ((count = is.read(buf)) > 0) {
//      OutputStream os = new FileOutputStream(new File(targetFolder, sourceFile.getName() + "." + index++));
//      os.write(buf, 0, count);
//      os.close();
//    }
//    is.close();
  }

  private static void closeStream(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


  /**
   * 将制定文件夹下的拆分文件合并为一个文件，将文件保存到指定的路径下
   *
   * @param sourceFolder 拆分文件所处的路径，其下的文件命名规则，同split拆分出来的文件名一致
   * @param targetFolder 合并之后的文件保存的路径，如果路径不存在，则创建这个目录
   */
  public static void combine(File sourceFolder, File targetFolder) {
    if (targetFolder == null) {
      throw new RuntimeException("目标文件不合法");
    }

    if (!targetFolder.exists() || !targetFolder.isDirectory()) {
      targetFolder.mkdirs();
    }

    File[] files = sourceFolder.listFiles();

    if (files == null || files.length == 0) {
      throw new RuntimeException("源文件不合法");
    }

    String name = files[0].getName();
    String targetName = name.substring(0, name.lastIndexOf("."));

    Arrays.sort(files, (o1, o2) -> {
      String o1Name = o1.getName();
      String o2Name = o2.getName();
      String o1Num = o1Name.substring(o1Name.lastIndexOf(".") + 1);
      String o2Num = o2Name.substring(o2Name.lastIndexOf(".") + 1);
      return Integer.parseInt(o1Num) - Integer.parseInt(o2Num);
    });

    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;

    try {
      File targetFile = new File(targetFolder.getCanonicalFile(), targetName);
      fileOutputStream = new FileOutputStream(targetFile);
      byte[] buf = new byte[1024];
      int count;
      for (File file : files) {
        fileInputStream = new FileInputStream(file);
        while ((count = fileInputStream.read(buf)) > 0) {
          fileOutputStream.write(buf, 0, count);
        }
        fileInputStream.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fileInputStream);
      closeStream(fileOutputStream);
    }


//    OutputStream os = new FileOutputStream(targetFolder);
//    int len = sourceFolder.length;
//    for (File file : sourceFolder) {
//      InputStream is = new FileInputStream(file);
//      byte[] buf = new byte[(int) file.length()];
//      int count = 0;
//      while ((count = is.read(buf)) > 0) {
//        os.write(buf, 0, count);
//      }
//      is.close();
//    }
//    os.close();
  }

  public static void main(String[] args) {
    final String winPATH = "D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\doc\\WIN.mp3";
    final String macPATH = "/Users/edz/Semicircle/javase/7.09/SplitFile/doc/WIN.mp3";
    final String winSplitPATH = "D:\\banyuan\\Semicircle\\javase\\7.09\\SplitFile\\WinSplit";
    final String macSplitPATH = "/Users/edz/Semicircle/javase/7.09/SplitFile/WinSplit";


    File WIN = new File(macPATH);
//    File WIN = new File(winPATH);
    File WinSplit = new File(macSplitPATH);
//    File WinSplit = new File(winSplitPATH);
    if (!WinSplit.exists()) {
      WinSplit.mkdir();
    }
    split(WIN, 1024 * 9, WinSplit);

    File targetFolder = new File("/Users/edz/Semicircle/javase/7.09/SplitFile/WinCombine");
    File sourceFolder = new File(macSplitPATH);
    combine(sourceFolder, targetFolder);
  }


}

