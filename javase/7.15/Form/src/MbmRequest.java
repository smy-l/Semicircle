public class MbmRequest {

  private String method;
  private String path;
  private String host;
  private int contentLength;
  private String payload = "name=u1&pwd=123456";
//  private String payload = "name=u1&pwd=123";

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public int getContentLength() {
    return contentLength;
  }

  public void setContentLength(int contentLength) {
    this.contentLength = contentLength;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  @Override
  public String toString() {
    return "MbmRequest{" +
            "method='" + method + '\'' +
            ", path='" + path + '\'' +
            ", host='" + host + '\'' +
            '}';
  }
}
