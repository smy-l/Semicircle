public class IntAndByte {
  public static int byteToInt(byte[] bytes) {
    int rlt = 0;
    //  00000000 00000000 00000000 00000000
    //  11111111 00000000 00000000 00000000
    for (int i = 0; i < bytes.length; i++) {
      rlt |= ((int) bytes[i]) << 8 * (3 - i);
    }
    return rlt;
  }

  public static byte[] intToByte(int target) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (target >> 8 * (3 - i));
    }
    return bytes;
  }
}
