package practice7_01.club.banyuan.practice.dataSet;

public interface Measurer<T> {

  /**
   * 计算对象的数量.
   */
  double measure(T anObject);
}