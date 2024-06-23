package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Employee> employeeList = new ArrayList<>();

    protected Department(){

    }

    public Department(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        employee.setDept(this);
        this.employeeList.add(employee);
    }

    public Collection<Employee> getEmployeeList() {
        return employeeList;
    }
}
