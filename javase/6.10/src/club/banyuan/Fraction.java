package club.banyuan;

public class Fraction {
	int denominator; //分母
	int molecule;	//分子

	//设置分数
	public void setFraction(int mol, int den){
		if(den == 0){
			System.out.println("分母不能为0！");
			return;
		}
		denominator = den;
		molecule  = mol;
	}

	//将分数转换成double型
	public double toDouble(){
		double result = molecule * 1.0 / denominator;
		return result;
	}

	//两个分数相加
	public Fraction plus(Fraction r){
		Fraction newFraction = new Fraction();
		//通分
		newFraction.denominator = r.denominator * denominator;
		newFraction.molecule = r.molecule * denominator + molecule * r.denominator;
		return newFraction;
	}

	//两个分数相乘
	public Fraction multiply(Fraction r){
		Fraction newFraction = new Fraction();
		newFraction.denominator = r.denominator * denominator;
		newFraction.molecule = r.molecule * molecule;
		return newFraction;
	}

	//打印
	public void print(){
		if(molecule == denominator){
			System.out.println("1");
			return;
		}

		int minNum = 0;
		if(denominator > molecule){
			minNum = molecule;
		}else{
			minNum = denominator;
		}

		//找公因数，约分
		for(int i = minNum; i > 1; i--){
			if(denominator % i == 0 & molecule % i == 0){
				denominator /= i;
				molecule /= i;
			}
		}
		System.out.println(molecule + "/" + denominator);
	}

	public static void main(String[] args) {
		Fraction a = new Fraction();
		a.setFraction(10,15);
		Fraction b = new Fraction();
		b.setFraction(10,30);
		a.print();
		System.out.println(a.toDouble());
		b.print();
		System.out.println(b.toDouble());
		System.out.println("====加法====");
		a = a.plus(b);
		a.print();
		System.out.println(a.toDouble());
		System.out.println("====乘法====");
		a = a.multiply(b);
		a.print();
		System.out.println(a.toDouble());
	}
}