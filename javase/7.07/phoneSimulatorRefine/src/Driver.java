public class Driver {

  public static void main(String[] args) {
    // 创建一个电话
    CellularPhone aPhone = new CellularPhone("Phone");
    aPhone.start();

    // 创建两个呼叫生成器，他们坚持不断地给电话打电话。
    PhoneCallGenerator pcGen1 = new PhoneCallGenerator("Tom", aPhone);
    PhoneCallGenerator pcGen2 = new PhoneCallGenerator("Jerry", aPhone);
    MessageGenerator mGer1 = new MessageGenerator("Mother", aPhone);
    MessageGenerator mGer2 = new MessageGenerator("Father", aPhone);
    pcGen1.start();
    pcGen2.start();
    mGer1.start();
    mGer2.start();

    try {
      // 等待，直到所有的电话都结束
      pcGen1.join();
      pcGen2.join();
      mGer1.join();
      mGer1.join();
      // 停止电话
      aPhone.stopPhone();
    } catch (InterruptedException ie) {
      // 必须要处理的join抛出的异常
      System.exit(1);
    }
  }
}
