package club.banyuan.company;
import club.banyuan.company.Company;
import club.banyuan.company.Employee;

public class Main {
	public static void main(String[] args) {
		Company company = new Company();
//		Employee employee1 = new Employee();
//		employee1.setName("张三");
//		employee1.setWorkHour(205);
//		employee1.setBaseSalary(2000);
//		Employee employee2 = new Employee();
//		employee2.setName("李四");
//		employee2.setWorkHour(220);
//		employee2.setBaseSalary(2000);
//		Employee employee3 = new Employee();
//		employee3.setName("王五");
//		employee3.setWorkHour(180);
//		employee3.setBaseSalary(2000);
//		Employee employee4 = new Employee();
//		employee4.setName("赵六");
//		employee4.setWorkHour(196);
//		employee4.setBaseSalary(2000);

		Employee employee = new Employee(196, "金三");
		Employee employee1 = new Employee(205,"张三",2000);
		Employee employee2 = new Employee(220,"李四",2000);
		Employee employee3 = new Employee(180,"王五",2000);
		Employee employee4 = new Employee(194,"赵六",2000);
		Employee employee5 = new Employee();
		employee5.setName("和二").setWorkHour(196).setBaseSalary(3000);

		company.add(employee1);
		company.add(employee2);
		company.add(employee3);
		company.add(employee4);
		company.add(employee);
		company.add(employee5);

		company.printAll();

		// company.remove("赵六");
		// company.printAll();

		// company.remove("李四");
		// company.printAll();

		// company.remove("王五");
		// company.printAll();

		company.printSalarySum();

	}
}