package com.example.itcompanyfinal.model;

public class Office {
    public static final String TABLE_NAME = "office";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String STATUS_ID = "status_id";
    public static final String OFFICE_ROOM = "office_room";

    private int employeeId;
    private int statusId;
    private int officeRoom;

    private Status status;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(int officeRoom) {
        this.officeRoom = officeRoom;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Office{" +
                "employeeId=" + employeeId +
                ", statusId=" + statusId +
                ", officeRoom=" + officeRoom +
                ", status=" + status +
                '}';
    }
}
