package club.banyuan.video;

public class VideoStore {
    Video[] videos = new Video[20];
    private int videoCount = 0;

    public void addVideo(String name) {
        Video newVideo = new Video();
        newVideo.setVideoName(name);
//        newVideo.setUserScore(0);
//        newVideo.setRent(false);
        videos[videoCount] = newVideo;
        videoCount++;
    }

    public void checkOut(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (videos[i].getVideoName().equals(name) & !videos[i].isRent()) {
                videos[i].setRent(true);
                videos[i].rentCount++;
            }
        }
    }

    public void returnVideo(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (videos[i].getVideoName().equals(name)) {
                videos[i].setRent(false);
            }
        }
    }

    public void receiveRating(String name, double core) {
        for (int i = 0; i < videoCount; i++) {
            if (videos[i].getVideoName().equals(name)) {
                if (core < 1 || core > 5) {
                    System.out.println("分数输入错误，分数为1～5");
                    return;
                }

                if(videos[i].rentCount == 0){
                    videos[i].setUserScore(0);
                    return;
                }

                if (videos[i].rentCount == 1) {
                    videos[i].setUserScore(core);
                    return;
                }

                videos[i].setUserScore((videos[i].getUserScore() * (videos[i].rentCount - 1) + core) / videos[i].rentCount);
            }
        }
    }

    public void listInventory() {
        for (int i = 0; i < videoCount; i++) {
            System.out.println(videos[i].getVideoName());
            System.out.println(videos[i].getUserScore());
            System.out.println("是否借出：" + videos[i].isRent());
            System.out.println("===============");
        }
    }


}
