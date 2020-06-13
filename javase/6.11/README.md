# 6.11
## practice
1. 定义Time class

    包含属性

    int hour<br>
    int minute<br>
    int second<br>

    包含方法<br>

    // 设置属性值 setTime(int aHour,int aMinute,int second)

    // 返回 12:22:40 格式的字符串 String toString()

    // 调用此方法会使得 second + 1，如果second达到了60 则分钟+1，如果分钟达到了60则小时+1，小时为24小时格式 nextSecond()

链接：https://github.com/smy-l/Semicircle/tree/master/javase/6.11/src/practice6_11/club/banyuan/time

2. 为一个小型录象带出租店设计一个简单的库存控制系统。

    定义两个类:Video和VideoStore。

    Video对象至少具有以下属性（其他属性可以按需扩展）:

    片名<br>
    是否被出租的标识<br>
    用户的平均评分<br>
    此外，需要定义一些方法操作这些属性。<br>

    VideoStore类 将包含一个Video数组。

    VideoStore中定义方法    <br>
    addVideo(String): 添加一个新的电影<br> 
    checkOut(String): 根据片名借出电影 <br>
    returnVideo(String): 归还电影 <br>
    receiveRating(String, int) : 设置用户对电影的评分(1~5)，收到评分之后，计算该电影的平均评分，然后保存到Video的评分属性中<br>
    listInventory(): 列出整个库存的电影。

    创建VideoStoreLauncher类，作为程序入口，main方法将测试其他两个类的功能。

    新增《黑客帝国》、《教父》、《星球大战》3部影片。 给每个视频打分。 每个视频出租一次，然后归还。 列出《教父》租出去后的库存。

    打印商店的库存，列出每个影片的:

    片名<br>
    平均评分    
    是否借出

链接：https://github.com/smy-l/Semicircle/tree/master/javase/6.11/src/practice6_11/club/banyuan/video

