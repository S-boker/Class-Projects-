import java.time.LocalDate;

abstract class Employee{
	private String name;
	private String  id;
	private LocalDate hireDate;
	
	public Employee() {
		name = null;
		id = null;
		hireDate = null;
	}
    public Employee(String name,String id, int year, int month, int day) {
    	this.name = name;
    	this.id = id;
    	hireDate = LocalDate.of(year, month, day);
    }
    public String getName() {return name;}
    public String getId() {return id;}
    public LocalDate getHireDate() {return hireDate;}
    public void setName(String n) {name = n;}
    public abstract double pay();
    public abstract String toString();
}
class SalariedEmployee extends Employee{
	private double salary;
	
	public SalariedEmployee() {
		super();
		salary = Double.NaN;
	}
    public SalariedEmployee(String name, String id, int year, int month, int day, double sal) {
    	super(name, id, year, month, day);
    	salary = sal;
    }
    public double getSalary() {return salary;}
    public void raiseTheSalary() {salary *= 1.07;};
    public double pay() {return salary;}
    public String toString() {return "Salaried: " + getName() + ", " + getId() + ", " + getHireDate() + ", " + getSalary();}
}
class ParttimeEmployee extends Employee{
    private double payRate;
    private int hoursWorked;
   	public ParttimeEmployee() {
   		super();
   		payRate = Double.NaN;		
   	    hoursWorked = 0; 
   	    
   	}
    public ParttimeEmployee(String name,String id, int year, int month, int day, double pay, int hours){
       	super(name, id, year, month, day);
       	payRate = pay;
       	hoursWorked = hours;
    }
    public double getPayRate() {return payRate;}
    public int getHoursWorked() {return hoursWorked;}
    public void setPayRate(double p) {payRate = p;}
    public void setHoursWorked(int h) {hoursWorked = h;}
    public double pay() {return payRate*hoursWorked;}
    public String toString() {return "Fulltime " + getName() + ", " + getId() + ", " + getHireDate() + ", " + getPayRate() + ", " + getHoursWorked();} 
}  
class FulltimeEmployee extends ParttimeEmployee{
	public FulltimeEmployee() {super();}
	public FulltimeEmployee(String name,String id, int year, int month, int day, double pay, int hours) {
		super(name, id, year, month, day, pay, hours);
	}
    private int overTime() {
    	if(getHoursWorked() > 40) return getHoursWorked() - 40;
    	else return 0;
    }
    public double pay() {return getHoursWorked()*(getHoursWorked() + overTime()*1.5);}
    public String toString() {return "Parttime " + getName() + ", " + getId() + ", " + getHireDate() + ", " + getPayRate() + ", " + getHoursWorked();}
}

public class D23768989 {//Demo Class
	public static void main(String[] args) {
		SalariedEmployee a = new SalariedEmployee("Mary Smith", "23457", 2019, 4, 17, 20000);
		SalariedEmployee b = new SalariedEmployee("Sal Brown", "32137", 2018, 4, 17, 20000);
	    a.setName("Marry Jane"); //Marry got married to Sam Jane
	    b.raiseTheSalary();//Sal's yearly raise
	    System.out.println(a.toString());
	    System.out.println(b.toString());
	    System.out.println("Marry's pay: " +a.pay());
	    System.out.println("Sal's pay: " + b.pay());
	    ParttimeEmployee c = new ParttimeEmployee("Patty Samter", "45678", 2018, 3, 17, 30, 12);
	    ParttimeEmployee d = new ParttimeEmployee("Traivs Rito", "78564", 2019, 3, 24, 30, 10);
	    System.out.println("Patty's pay's pay: " + c.pay());
	    System.out.println("Traivs' pay's pay: " + d.pay());
	    System.out.println(c.toString());
	    System.out.println(d.toString());
	    FulltimeEmployee w = new FulltimeEmployee("Willma Dust", "52134", 2018, 2, 9, 40, 40);
	    FulltimeEmployee z = new FulltimeEmployee("Dan West", "63793", 2018, 1, 13, 40, 35);
	    z.setPayRate(42);//Mr. West got a rise
	    w.setHoursWorked(42);// Willma is working overtime
	    System.out.println("Dan's pay: " + z.pay());
	    System.out.println("Willam's pay: " + w.pay());
	    System.out.println(z.toString());
	    System.out.println(w.toString());
	}

}
