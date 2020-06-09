class Practice6_9{
    public static void main(String[] args) {
        float a =1.2E38F;
        int b = (int)a;
        System.out.println(a);
        System.out.println(b);
        //a打印为1.2E38
        //b打印为2147483647

        int c = 10;
        int d = 10;
        boolean temp = true || (++c > 20);
        boolean temp2 = true | (++d > 20);
        System.out.println(c);//c未进行运算，短路
        System.out.println(d);//d进行运算，未短路
    }
}