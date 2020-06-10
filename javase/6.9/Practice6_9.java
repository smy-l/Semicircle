public class Practice6_9 {
    /**
     * 1.
     * 根据传入的参数来将数组升序或降序排列
     *
     * @param isAsc true 升序， false 降序
     */
    static void sort(int arr[], boolean isAsc) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (isAsc) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
    }



    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 2.
     * 重载方法，将数组升序
     *
     * @param arr 目标数组
     */
    static void sort(int arr[]) {
        boolean a = true;
        sort(arr, a);
    }

    /**
     * 3.
     * 编写一个main方法用来测试上述两个方法，
     * 定义一个数组，内容 {13,26,-3,4,54,26,37,18,69,-10}，
     * 编写一个print方法，使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行
     */
    static void print(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i + "]" + "=" + arr[i] + " ");
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 4.不用*完成乘法
     */
    static int multiply(int n1, int n2) {
        int result = 0;//分情况讨论
        if (n1 > 0 && n2 > 0) {
            for (int i = 1; i <= n2; i++) {
                result = result + n1;
            }

        } else if (n1 < 0 && n2 < 0) {
            n1 = -n1;
            n2 = -n2;
            for (int i = 1; i <= n2; i++) {
                result = result + n1;
            }

        } else if (n1 == 0 || n2 == 0) {

        } else if (n1 < 0 && n2 > 0) {
            n1 = -n1;
            for (int i = 1; i <= n2; i++) {
                result = result + n1;
            }
            result = -result;

        } else if (n1 > 0 && n2 < 0) {
            n2 = -n2;
            for (int i = 1; i <= n2; i++) {
                result = result + n1;
            }
            result = -result;
        }
        return result;
    }

    /**
     * 5.
     * 编写一个方法输入分钟时间，向控制台输出多少年，多少天
     */
    static void convert(long minute) {
        long years;
        long days;
        years = minute / (60 * 24 * 365);
        days = (minute / (60 * 24)) % 365;
        System.out.println(years + "年" + days + "天");
    }

    /**
     * 6.
     * 有1.5元钱兑换1分，2分，5分硬币100枚，
     * 每种面值至少一个，请输出所有的兑换方案，并统计方案的总数
     * 在main方法中
     */


    /**
     * 7.
     * 编写一个方法用于int数组去重，将数组中重复的元素只保留一个
     */
    static int[] filtArray(int[] arr) {
        int n = arr.length;//数组有效长度
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    for (int k = j; k < n - 1; k++) {//将之后的数组元素往前移
                        arr[k] = arr[k + 1];
                    }
                    n--;
                    j--;
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = arr[i];
        }

//        for (int one : result) {
//            System.out.print(" " + one + " ");
//        }

        return result;
    }

    public static void main(String[] args) {
        //上午1.
        float a = 1.2E38F;
        int b = (int) a;
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        //a打印为1.2E38
        //b打印为2147483647

        //上午2.
        int c = 10;
        int d = 10;
        boolean temp = true || (++c > 20);
        boolean temp2 = true | (++d > 20);
        System.out.println(c);//c未进行运算，短路
        System.out.println(d);//d进行运算，未短路
        System.out.println();

        //3.编写一个main方法用来测试上述两个方法，
        // 定义一个数组，内容 {13,26,-3,4,54,26,37,18,69,-10}，
        // 编写一个print方法，使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行

        //3.1
        // 测试上述2种方法
        System.out.println("-----1.sort(int arr[], boolean isAsc)-----");
        int[] arr3_1_1 = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
        sort(arr3_1_1, false);
        for (int one : arr3_1_1) {
            System.out.print(" " + one + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("-----2.sort(int arr[])-----");
        int[] arr3_1_2 = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
        sort(arr3_1_2);
        for (int one : arr3_1_2) {
            System.out.print(" " + one + " ");
        }
        System.out.println();
        System.out.println();


        //3.2
        // 定义print函数
        System.out.println("-----3.print(int arr[])------");
        int[] arr3_2 = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
        print(arr3_2);
        System.out.println();

        //4.
        // 编写一个方法不使用*完成两个数相乘
        System.out.println("-----4.除法-----");
        int Num1 = -9;
        int Num2 = -10;
        int result = multiply(Num1, Num2);
        System.out.println(result);
        System.out.println();


        //5.
        // 编写一个方法输入分钟时间，向控制台输出多少年，多少天
        System.out.println("-----5.计算年数天数-----");
        long minute = 3456789;
        convert(minute);
        System.out.println();


        //6.
        // 有1.5元钱兑换1分，2分，5分硬币100枚，
        // 每种面值至少一个，请输出所有的兑换方案，并统计方案的总数
        System.out.println("-----6.硬币方案-----");
        int countMoney = 150;
        int countNum = 100;
        int count = 0;
        for (int i = 1; i <= countMoney; i++) {
            for (int j = 1; j <= countMoney / 2; j++) {
                for (int k = 1; k <= countMoney / 5; k++) {
                    if ((i + j * 2 + k * 5) == countMoney && (i + j + k) == countNum) {
                        System.out.printf("兑换方案为：1分有 %2d 个，2分有%2d个，5分有%2d个\n", i, j, k);
                        count++;
                    }
                }
            }
        }
        System.out.printf("共有%d个方案\n", count);
        System.out.println();

        //7.
        //编写一个方法用于int数组去重，将数组中重复的元素只保留一个
        System.out.println("-----7.数组去重-----");
        int[] arr7 = new int[]{1, 1, 1, 22, 22, 3, 44, 5, 66, 22, 1};
//        filtArray(new int[]{1, 1, 1, 22, 22, 3, 44, 5, 66, 22, 1});
        arr7 = filtArray(arr7);
        for (int one : arr7){
            System.out.print(" " + one + " ");
        }
        System.out.println();
    }
}