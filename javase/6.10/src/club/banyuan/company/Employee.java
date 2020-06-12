package club.banyuan.company;

public class Employee{
	private int workHour;
	private String name;
	private int baseSalary;
	private static final int defaultBaseSalary = 3000;

	public Employee(int workHour, String name, int baseSalary){
		this.workHour = workHour;
		this.baseSalary = baseSalary;
		this.name = name;
	}

	public Employee(int workHour, String name){
		this(workHour,name,defaultBaseSalary);
	}

	public Employee(){

	}


	public Employee setWorkHour(int hour){
		workHour = hour;
		return this;
	}

	public Employee setName(String aName){
		name = aName;
		return this;
	}

	public Employee setBaseSalary(int salary){
		baseSalary = salary;
		return this;
	}

	public String getName(){
		return name;
	}

	public int getSalary(){
		int rlt = baseSalary;
		if(workHour > 196){
			rlt += (workHour - 196) * 200;
		}
		return rlt;
	}

}











