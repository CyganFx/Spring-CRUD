package com.example.itcompanyfinal.model;

import java.util.StringJoiner;

public class DepartmentManager {
    public static final String TABLE_NAME = "department_managers";
    public static final String DEPARTMENT_ID = "department_id";
    public static final String  EMPLOYEE_ID = "employee_id";

    private int departmentId;
    private int employeeId;

    private Department department;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static String getViewModelColumns() {
        StringJoiner changedColumns = new StringJoiner(", ");
        changedColumns.add(DEPARTMENT_ID).add(EMPLOYEE_ID);
        return String.valueOf(changedColumns);
    }

    @Override
    public String toString() {
        return "DepartmentManager{" +
                "departmentId=" + departmentId +
                ", employeeId=" + employeeId +
                ", department=" + department +
                '}';
    }
}
