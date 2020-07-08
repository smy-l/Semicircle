import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CellularPhone extends Thread {

    private volatile boolean callInProgress = false;
    private volatile boolean keepGoing = true;
    private Set<String> message = new CopyOnWriteArraySet<>();
    private Lock lock = new ReentrantLock();

    public CellularPhone(String name) {
        super(name);
    }

    /**
     * 假设控制台是手机的窗口。
     *
     * @param message 要显示的消息
     */
    void display(String message) {
        System.out.println(message);
    }

    /**
     * 接听电话。在终端显示消息。
     *
     * @param name               调用方的名称
     * @param callDisplayMessage 呼叫正在进行时显示的消息
     * @returns 如果调用被接受，则为true
     */
    public boolean startCall(String name, String callDisplayMessage) {
        if (callInProgress) {
            return false;
        }

//        boolean b = false;
//        try {
//            b = lock.tryLock(200, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if(!b){
//            return false;
//        }

//        if (!lock.tryLock()) {
//            return false;
//        }
        lock.lock();
        callInProgress = true;
        display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
        return true;
    }

    /**
     * 挂断电话。在此方法完成后，电话能够接听其他电话。
     *
     * @param name               调用方的名称
     * @param callDisplayMessage 要显示的消息
     */
    public void endCall(String name, String callDisplayMessage) {
        display("   <" + name + ">: Call (" + callDisplayMessage + ") ends");
        callInProgress = false;
        lock.unlock();
    }

    /**
     * 显示手机正在等待做某事
     */
    private void displayWaiting() {
        display("<" + this.getName() + ">: Waiting...");
    }

    /**
     * 停止电话接听程序
     */
    public void stopPhone() {
        keepGoing = false;
    }

    /**
     * 运行模拟器
     */
    public void run() {
        // 循环直到stopPhone被调用
        while (keepGoing) {
            // 如果没有电话
            if (!callInProgress) {
                displayMessages();
                displayWaiting();
                // 假装手机在做别的事情
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    synchronized public void addMessage(String str) {
        message.add(str);
    }

    synchronized private void displayMessages() {
        for (String str : message) {
            System.out.println(str);
        }
        message.clear();
    }
}
