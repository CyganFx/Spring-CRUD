package com.example.itcompanyfinal.model;

import java.util.StringJoiner;

public class Salary {
    public static final String TABLE_NAME = "salaries";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String DEPARTMENT_ID = "department_id";
    public static final String STATUS_ID = "status_id";
    public static final String SALARY = "salary";

    private int employeeId;
    private int departmentId;
    private int status_id;
    private int salary;

    private Department department;
    private Status status;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                ", status_id=" + status_id +
                ", salary=" + salary +
                ", department=" + department +
                ", status=" + status +
                '}';
    }
}
