import java.util.ArrayList;

abstract class Employee{
	private String name;
	private int id;
	public Employee(String name,int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	 public abstract double calculateSalary();
	 
	 @Override
	 public String toString() {
		 return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
	 }
}

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id,double monthlySalary) {
		super(name,id);
		this.monthlySalary = monthlySalary;
	}
	@Override
		public double calculateSalary() {
			return monthlySalary;
		}
	}


class PartTimeEmployee extends Employee{
	private int hourWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id,int hourWorked,double hourlyRate) {
		super(name,id);
		this.hourWorked = hourWorked;
		this.hourlyRate = hourlyRate;
	}
	@Override
		public double calculateSalary() {
			return  hourWorked * hourlyRate;
		}
	}

class PayrollSystem{
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	} 
	
	public void removeEmployee(int id) {
		Employee employeeToRemove  = null;
		for(Employee employee : employeeList)
		{
			if(employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		if(employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
		}
	public void displayEmployee() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
}

public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayrollSystem ps = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Avinash",1,7000);
		PartTimeEmployee emp2 = new PartTimeEmployee("Vikas",2,20,100);
		
		ps.addEmployee(emp1);
		ps.addEmployee(emp2);
		System.out.println("Initial Employee Details: ");
	    ps.displayEmployee();
	    
	    System.out.println("Remove Employee");
	    ps.removeEmployee(2);
	    
	    System.out.println("Remaining Employee Details: ");
	    ps.displayEmployee();
	}

}