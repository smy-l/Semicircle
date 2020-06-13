package practice6_11.club.banyuan.video;

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore Store = new VideoStore();

//        Video theMatrix = new Video();
//        theMatrix.setVideoName("黑客帝国");
        Store.addVideo("黑客帝国");


//        Video godfather = new Video();
//        godfather.setVideoName("教父");
        Store.addVideo("教父");

//        Video starWars = new Video();
//        starWars.setVideoName("星球大战");
        Store.addVideo("星球大战");

        Store.receiveRating("黑客帝国", 3);
        Store.receiveRating("教父", 4);
        Store.receiveRating("星球大战", 4.5);

        Store.checkOut("黑客帝国");
        Store.checkOut("教父");
        Store.listInventory();
        Store.checkOut("星球大战");


        Store.returnVideo("黑客帝国");
        Store.returnVideo("教父");
        Store.returnVideo("星球大战");

//        Store.checkOut("黑客帝国");
//        Store.receiveRating("黑客帝国", 2);
//        Store.returnVideo("黑客帝国");

//        Store.listInventory();




    }

}
