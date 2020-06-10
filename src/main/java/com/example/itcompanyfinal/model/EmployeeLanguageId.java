package com.example.itcompanyfinal.model;

public class EmployeeLanguageId {
    public static final String TABLE_NAME = "employee_language_id";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String LANGUAGE_ID = "language_id";

    private int employeeId;
    private int languageId;

    private Language language;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
