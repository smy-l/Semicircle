package club.banyuan.company;
import club.banyuan.company.Company;
import club.banyuan.company.Employee;

public class Main {
	public static void main(String[] args) {
		Company company = new Company();
		Employee employee1 = new Employee();
		employee1.setName("张三");
		employee1.setWorkHour(205);
		employee1.setBaseSalary(2000);
		Employee employee2 = new Employee();
		employee2.setName("李四");
		employee2.setWorkHour(220);
		employee2.setBaseSalary(2000);
		Employee employee3 = new Employee();
		employee3.setName("王五");
		employee3.setWorkHour(180);
		employee3.setBaseSalary(2000);
		Employee employee4 = new Employee();
		employee4.setName("赵六");
		employee4.setWorkHour(196);
		employee4.setBaseSalary(2000);
		company.add(employee1);
		company.add(employee2);
		company.add(employee3);
		company.add(employee4);

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