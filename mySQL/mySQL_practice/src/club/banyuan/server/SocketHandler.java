package club.banyuan.server;

import club.banyuan.dto.Bill;
import club.banyuan.dto.Supplier;
import club.banyuan.dto.User;
import club.banyuan.exception.*;
import club.banyuan.service.BillService;
import club.banyuan.service.SupplierService;
import club.banyuan.service.UserService;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SocketHandler extends Thread {

  private Socket clientSocket = new Socket();
  private UserService userService = new UserService();
  private SupplierService supplierService = new SupplierService();
  private BillService billService = new BillService();

  public SocketHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    //创建接收信息的类
    MbmRequest mbmRequest = new MbmRequest();

    try {
      //获取浏览器发送的信息
      InputStream inputStream = clientSocket.getInputStream();

      //将字节流转换为字符流
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      //开始读取
      String line = bufferedReader.readLine();
      if (line == null) {
        System.err.println("解析失败");
        return;
      }

      //GET / HTTP1.1 (第一行)
      StringTokenizer stringTokenizer = new StringTokenizer(line);
      mbmRequest.setMethod(stringTokenizer.nextToken());
      mbmRequest.setPath(URLDecoder.decode(stringTokenizer.nextToken(), "utf-8"));

      //继续读取数据
      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          String replace = line.replace("Host: ", "");
          mbmRequest.setHost(replace);
        }

        if (line.startsWith("Content-Length:")) {
          String replace = line.replace("Content-Length: ", "");
          mbmRequest.setContentLength(Integer.parseInt(replace));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      if (mbmRequest.getContentLength() > 0) {
        char[] chars = new char[mbmRequest.getContentLength()];
        bufferedReader.read(chars);
        mbmRequest.setPayload(URLDecoder.decode(new String(chars), "utf-8"));
      }

      String resourcePath = mbmRequest.getPath();

      if (resourcePath.startsWith("/server")) {
        process(mbmRequest);
      } else {
        responseResource(mbmRequest);
      }

    } catch (FormPostException e) {
      try {
        responseRedirect(mbmRequest, "/form_post_fail.html?msg=" + e.getMessage());
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

    } catch (BadRequestException e) {
      try {
        responseFailJson(e.getMessage());
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  private void responseFailJson(String data) throws IOException {
    // String data = JSONObject.toJSONString(object);
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

    out.writeBytes("HTTP/1.1 400 Bad request");
    out.writeBytes("\r\n");
    out.writeBytes("Content-Length: " + data.getBytes().length);
    out.writeBytes("\r\n");
    out.writeBytes("Content-Type: application/json;charset=utf-8;");
    out.writeBytes("\r\n");
    out.writeBytes("\r\n");
    out.write(data.getBytes());
  }

  private void responseResource(MbmRequest mbmRequest) throws IOException {
    String resourcePath = mbmRequest.getPath();
    if (resourcePath.startsWith("/")) {
      resourcePath = resourcePath.substring(1);
    }

    if (resourcePath.length() == 0) {
      resourcePath = "pages/login.html";
    } else if (resourcePath.startsWith("css") ||
            resourcePath.startsWith("images") ||
            resourcePath.startsWith("js") ||
            resourcePath.contains(".html")) {
      resourcePath = "pages/" + resourcePath;
    }

    InputStream resourceAsStream = HttpServer.class.getClassLoader().
            getResourceAsStream(resourcePath);

    if (resourceAsStream == null) {
      resourceAsStream = HttpServer.class.getClassLoader().
              getResourceAsStream("404.html");
    }

    // form_post_fail.html?msg=异常信息描述
    if (resourcePath.contains("form_post_fail.html")) {
      // 获取异常信息描述
      InputStream resourceAsStream1 = HttpServer.class.getClassLoader()
              .getResourceAsStream(resourcePath);

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream1));
      StringBuilder builder = new StringBuilder();

      String line = bufferedReader.readLine();
      while (line != null) {
        if (line.contains("${msg}")) {
          line = line.replace("${msg}", mbmRequest.getFormData().get("msg"));
        }
        builder.append(line);
        builder.append(System.lineSeparator());
        line = bufferedReader.readLine();
      }
      byte[] data = builder.toString().getBytes();
      OutputStream outputStream = clientSocket.getOutputStream();
      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
      if (resourcePath.contains(".html")) {
        outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
      }

      String contentLength = "Content-Length: " + data.length;
      outputStream.write(contentLength.getBytes());

      outputStream.write("\r\n".getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write(data);
      bufferedReader.close();
      return;
    }

    //第一行： HTTP/1.1 200 OK\r\n
    //如果包含".html"
    //第二行：Content-Type: text/html; charset=utf-8\r\n
    //将长度换为资源文件长度，使用available获取资源文件长度
    //第三行：Content-Length: 长度\r\n
    //第四行：\r\n
    //读到空行后，开始读取资源文件数据

    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
    if (resourcePath.contains(".html")) {
      outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
    }
    String contentLength = "Content-Length: " + resourceAsStream.available() + "\r\n";
    outputStream.write(contentLength.getBytes());
    outputStream.write("\r\n".getBytes());
    outputStream.write(resourceAsStream.readAllBytes());
    resourceAsStream.close();
  }

  private void process(MbmRequest mbmRequest) throws IOException, FormPostException {
    switch (mbmRequest.getPath()) {
      case "/server/user/login": {
        Map<String, String> formData = mbmRequest.getFormData();
        if (userService.login(formData.get("name"), formData.get("pwd"))) {
          responseRedirect(mbmRequest, "/bill_list.html");
        } else {
          throw new FormPostException("用户名或者密码错误");
        }
      }
      break;
      case "/server/user/modify": {
        Map<String, String> forData = mbmRequest.getFormData();
        String data = JSONObject.toJSONString(forData);
        User user = JSONObject.parseObject(data, User.class);
        if (user.getId() == 0) {
          userService.insertUser(user);
        } else {
          userService.updateUser(user);
        }
        responseRedirect(mbmRequest, "/user_list.html");
      }
      break;
      case "/server/user/list": {
        List<User> userList;
        String payload = mbmRequest.getPayload();
        if (payload == null) {
          userList = userService.getUserList();
        } else {
          User user = JSONObject.parseObject(payload, User.class);
          userList = userService.getUserList(user);
        }
        responseJson(userList);
      }
      break;
      case "/server/user/get": {
        String payload = mbmRequest.getPayload();
        User userId = JSONObject.parseObject(payload, User.class);
        User user = userService.getUserById(userId.getId());
        responseJson(user);
      }
      break;
      case "/server/user/delete": {
        String payload = mbmRequest.getPayload();
        User userId = JSONObject.parseObject(payload, User.class);
        userService.deleteUser(userId);
        responseOK();
      }
      break;
      case "/server/provider/modify": {
        Map<String, String> formData = mbmRequest.getFormData();
        String jsonStr = JSONObject.toJSONString(formData);
        Supplier supplier = JSONObject.parseObject(jsonStr, Supplier.class);
        if (supplier.getId() == 0) {
          supplierService.insertSupplier(supplier);
        } else {
          supplierService.updateSupplier(supplier);
        }
        responseRedirect(mbmRequest, "/provider_list.html");
      }
      break;
      case "/server/provider/list": {
        List<Supplier> supplierList;
        String payload = mbmRequest.getPayload();
        if (payload == null) {
          supplierList = supplierService.getSupplierList();
        } else {
          Supplier supplier = JSONObject.parseObject(payload, Supplier.class);
          supplierList = supplierService.getSupplierList(supplier);
        }
        responseJson(supplierList);
      }
      break;
      case "/server/provider/get": {
        String payload = mbmRequest.getPayload();
        Supplier supplierId = JSONObject.parseObject(payload, Supplier.class);
        Supplier supplier = supplierService.getSupplierById(supplierId.getId());
        responseJson(supplier);
      }
      break;
      case "/server/provider/delete": {
        String payload = mbmRequest.getPayload();
        Supplier supplier = JSONObject.parseObject(payload, Supplier.class);
        supplierService.deleteSupplier(supplier);
        responseOK();
      }
      break;
      case "/server/bill/modify": {
        Map<String, String> formData = mbmRequest.getFormData();
        String data = JSONObject.toJSONString(formData);
        Bill bill;
        try {
          bill = JSONObject.parseObject(data, Bill.class);
        } catch (Exception e) {
          throw new FormPostException("金额错误");
        }
        if (bill.getId() == 0) {
          billService.insertBill(bill);
        } else {
          billService.updateBill(bill);
        }
        responseRedirect(mbmRequest, "/bill_list.html");
      }
      break;
      case "/server/bill/list": {
        List<Bill> billList;
        String payload = mbmRequest.getPayload();
        if (payload == null) {
          billList = billService.getBillList();
        } else {
          Bill bill = JSONObject.parseObject(payload, Bill.class);
          billList = billService.getBillList(bill);
        }
        responseJson(billList);
      }
      break;
      case "/server/bill/get": {
        String payload = mbmRequest.getPayload();
        Bill billId = JSONObject.parseObject(payload, Bill.class);
        Bill bill = billService.getBillById(billId.getId());
        responseJson(bill);
      }
      break;
      case "/server/bill/delete": {
        String payload = mbmRequest.getPayload();
        Bill bill = JSONObject.parseObject(payload, Bill.class);
        billService.deleteBill(bill);
        responseOK();
      }
      break;
    }
  }

  private void responseOK() throws IOException {
    DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
    dataOutputStream.writeBytes("HTTP/1.1 200 OK");
    dataOutputStream.writeBytes("\r\n");
    dataOutputStream.writeBytes("\r\n");
  }

  private void responseJson(Object object) throws IOException {
    //HTTP/1.1 200 OK\r\n
    //"Content-Length: " + data.getBytes().length + "\r\n"
    //Content-Type: application/json;charset=utf-8;\r\n
    //\r\n
    //信息
    String data = JSONObject.toJSONString(object);
    DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
    dataOutputStream.writeBytes("HTTP/1.1 200 OK");
    dataOutputStream.writeBytes("\r\n");
    dataOutputStream.writeBytes("Content-Length: " + data.getBytes().length);
    dataOutputStream.writeBytes("\r\n");
    dataOutputStream.writeBytes("Content-Type: application/json;charset=utf-8;");
    dataOutputStream.writeBytes("\r\n");
    dataOutputStream.writeBytes("\r\n");
    dataOutputStream.write(data.getBytes());
  }

  //重定向
  //"HTTP/1.1 302 Found\r\n"
  //"Location: http://" + request.getHost() + path + \r\n
  private void responseRedirect(MbmRequest mbmRequest, String path) throws IOException {
    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 302 Found\r\n".getBytes());
    String information = "Location: http://" + mbmRequest.getHost() + path + "\r\n";
    outputStream.write(information.getBytes());
  }
}
