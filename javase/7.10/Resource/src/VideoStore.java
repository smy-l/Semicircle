import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class VideoStore {

  public static final String PATH = PropUtil.getPath();
  List<Video> videos = new ArrayList<>();
  // private static final String PATH =
  // Video[] videos = new Video[10];
  // int videoCount = 0;

  void store() {
    File file = new File(PATH);
    if (!file.exists()) {
      File parentFile = file.getParentFile();
      if (!parentFile.exists()) {
        parentFile.mkdirs();
      }
    }

    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(file))) {

      writer.write(JSONObject.toJSONString(videos));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  Video addVideo(String title) {
    Video video = new Video(title);
    videos.add(video);
    store();
    return video;
  }

  // 根据片名借出电影
  boolean checkOut(String title) {
    Video one = findVideo(title);
    if (one == null) {
      return false;
    }

    return one.setRentStatus(true);
  }

  // 归还电影
  boolean returnVideo(String title) {
    Video one = findVideo(title);
    if (one == null) {
      return false;
    }

    return one.setRentStatus(false);
  }

  // 设置用户对电影的评分(1~5)，收到评分之后，计算该电影的平均评分，然后保存到Video的评分属性中
  boolean receiveRating(String title, int rating) {

    if (rating < 0 || rating > 5) {
      return false;
    }

    Video one = findVideo(title);

    if (one == null) {
      return false;
    }

    one.rating(rating);
    return true;
  }

  public Video findVideo(String title) {
    for (Video video : videos) {
      if (video.title.equals(title)) {
        return video;
      }
    }
    return null;
  }


  void listInventory() {
    for (int i = 0; i < videos.size(); i++) {
      Video video = videos.get(i);
      System.out.printf("片名：%s\t\t评分：%.1f\t是否借出:%s\n", video.title, video.rating,
          video.isRent ? "是" : "否");
    }
  }

  public void load() {
    try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

      StringBuilder stringBuilder = new StringBuilder();
      String line = reader.readLine();
      while (line != null){
        stringBuilder.append(line);
        line = reader.readLine();
      }

      videos = JSONObject.parseArray(stringBuilder.toString(), Video.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}



