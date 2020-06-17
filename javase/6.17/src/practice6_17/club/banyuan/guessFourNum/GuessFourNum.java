package practice6_17.club.banyuan.guessFourNum;

public class GuessFourNum {
    public static void main(String[] args) {
        Number answer = new Number();
        Number userInput = new Number();

        answer.fillAnswer();
        for (int i = 0; i < answer.getValue().length; i++) {
            System.out.print(answer.getValue()[i]);
        }
        System.out.println("猜一猜4个不重复的数字，请输入4个数字：  ");
        while (true) {
            userInput.fillUserInput();
            boolean isSuccess = answer.checkUserInput(userInput);
            if (isSuccess) {
                System.out.println("回答正确");
                return;
            } else {
                System.out.println("请输入4个数字：");
            }
        }
    }
}
