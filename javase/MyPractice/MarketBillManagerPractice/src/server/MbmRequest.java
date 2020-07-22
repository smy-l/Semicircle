package server;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MbmRequest {

  private String method;
  private String path;
  private String host;
  private int contentLength;
  private String payload;

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
    if (method.equals("GET") && path.contains("\\?")) {
      String[] split = path.split("\\?");
      this.path = split[0];
      payload = split[1];
    } else {
      this.path = path;
    }
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getContentLength() {
    return contentLength;
  }

  public void setContentLength(int contentLength) {
    this.contentLength = contentLength;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public Map<String, String> getFormData() {
    Map<String, String> formData = new HashMap<>();
    StringTokenizer stringTokenizer = new StringTokenizer(getPayload(), "&|=");
    while (stringTokenizer.hasMoreTokens()) {
      formData.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }
    return formData;
  }
}
