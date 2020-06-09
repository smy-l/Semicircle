public class Practice{
	public static void main(String[] args){
		//1.定义7天时间毫秒值
		int  sevenDaysMilliseconds;
		sevenDaysMilliseconds = 7 * 24 * 60 * 60 * 1000;
		System.out.println(sevenDaysMilliseconds);

		//2.定义30天时间毫秒值
		long thirtyDaysMilliseconds;
		thirtyDaysMilliseconds = 30 * 24 * 60 * 60 * 1000L;
		System.out.println(thirtyDaysMilliseconds);

		
		//3.如何验证小数字面量默认值是double数据类型的
		//float a = 3.14E39F;//编译报错
		double b = 3.14E38D;
		//System.out.println(a);
		System.out.println(b);
		//观察编译结果，若float型出错，则表示默认为double，反之亦然
		//结果表明默认类型为double型


		//4.如何证明数组的length是final的，如何证明数组length是int类型

		//对其进行二次赋值，若二次赋值失败，则表明是final
		int[] n = new int [10];
		System.out.println(n.length);
		//n.length = 11;
		//编译报错，证明其是final
		//int [] arr2 = new int[0xFFFFFFFF];//编译报错


		//5.定义二维数组
		char[][] arr = new char [][]{{'你','我','他'},{'金','木','水','火','土'},{'天','地'}};
		//{'你','我','他'};
		//{'金','木','水','火','土'};
		//{'天','地'};

		// char[][] arr1 = new char[3][];
		// char[0] = {'你','我','他'};
		// char[1] = {'金','木','水','火','土'};
		// char[3] = {'天','地'};

		for(char[] tmp: arr){
			System.out.println(tmp);
		}


	}
}