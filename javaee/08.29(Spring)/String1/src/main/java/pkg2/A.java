package pkg2;

public class A {
  private Parent p ;

  public void setB(Parent p) {
    this.p = p;
  }

  public void invokeClassB() {
    System.out.println("Class pkg1.A invoke Class B method1");
    p.method();
  }

  public void invokeClassB2() {
    System.out.println("Class pkg1.A invoke Class B method1");
    p.method();
  }
}
