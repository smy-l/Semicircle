package practice6_10.club.banyuan.company;

public class Company {

    private Employee [] employeeArr = new Employee[100];
    private int employeeTotal = 0;

    //1.添加
    public void add(Employee employee) {
        if (employee == null) {
            System.out.println("不合法");
            return;
        }

        employeeArr[employeeTotal++] = employee;
    }


    //2.删除
    public Employee remove(String name) {
        int index = -1;

        for (int i = 0; i < employeeTotal ; i++ ) {
            if (employeeArr[i].getName().equals(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        Employee rlt = employeeArr[index];

        employeeArr[index] = employeeArr[employeeTotal - 1];
        employeeArr[employeeTotal--] = null;

        return rlt;

    }

    //3.通过名字显示工资
    public void printAll() {
    	System.out.println("=============");
        for (int i = 0; i < employeeTotal; i++ ) {
            Employee employee = employeeArr[i];
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }

    }

    //4.输出所有员工工资总和
    public int printSalarySum(){
    	System.out.println();
    	int sum = 0;
    	for(int i = 0; i < employeeTotal; i++){
    		sum += employeeArr[i].getSalary();
    	}
    	System.out.println("员工工资总和为: " + sum);
    	return sum;
    }




}




