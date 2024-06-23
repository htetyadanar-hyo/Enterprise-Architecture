package domain;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long employeeNumber;
    private String name;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;

    protected Employee(){
    }

    public Employee(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }
}
