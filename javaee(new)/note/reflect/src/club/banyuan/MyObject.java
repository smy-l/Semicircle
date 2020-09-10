package club.banyuan;

// @MyAnnotation(other = "in class", value = 1)
public class MyObject {

  // @MyAnnotation(other = "in field", value = -10, test = "666")
  private String field;
  // 补充说明
  public static String staticField;

  // public MyObject() {
  // }

  @MyAnnotation(other = "in method", value = 3)
  public MyObject(@MyAnnotation(other = "123", value = 5) String field) {
    this.field = field;
  }

  @MyAnnotation(other = "in method", value = 3)
  private void method() {

  }

  public static void staticMethod() {
    System.out.println("static method");
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  @Override
  public String toString() {
    return "MyObject{" +
        "field='" + field + '\'' +
        '}';
  }
}
