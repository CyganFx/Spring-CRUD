package com.example.itcompanyfinal.model;

import java.util.StringJoiner;

public class Department {
    public static final String TABLE_NAME = "departments";
    public static final String ID = "department_id";
    public static final String NAME = "department_name";

    private int departmentId;
    private String departmentName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public static String getViewModelColumns() {
        StringJoiner changedColumns = new StringJoiner(", ");
        changedColumns.add(ID).add(NAME);
        return String.valueOf(changedColumns);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
