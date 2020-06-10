package club.banyuan.company;

public class Employee{
	private int workHour;
	private String name;
	private int baseSalary;

	public void setWorkHour(int hour){
		workHour = hour;
	}

	public void setName(String aName){
		name = aName;
	}

	public void setBaseSalary(int salary){
		baseSalary = salary;
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











