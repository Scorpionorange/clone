import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Created by ScorpionOrange on 2016/08/07.
 */
public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s){
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{
        //call Object.clone()
        Employee cloned = (Employee) super.clone();

        //clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hireDay o a given date.
     * @param year the year of the hire day.
     * @param month the month of the hire day.
     * @param day the of the hire day.
     */
    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        //Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        salary = salary *( 1 + byPercent / 100);
    }

    public String toString(){
        return "Employee[name = " + name + ", salary = " + salary + ", hireDay = " + hireDay + "]";
    }

}
