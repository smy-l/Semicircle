package practice7_01.club.banyuan.practice.dataSet;

public class StringMeasurer<T> implements Measurer<T> {

  @Override
  public double measure(T anObject) {
    if (anObject == null) {
      return 0;
    }
    if (anObject instanceof String) {
      String string = (String) anObject;
      return string.length();
    }
    throw new IllegalArgumentException("不是字符串类");
  }
}
