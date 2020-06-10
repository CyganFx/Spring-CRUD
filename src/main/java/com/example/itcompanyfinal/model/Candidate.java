package com.example.itcompanyfinal.model;

import java.util.Date;
import java.util.StringJoiner;

public class Candidate {
    public static final String TABLE_NAME = "candidates";
    public static final String ID = "candidate_id";
    public static final String BIRTH_DATE = "birth_date";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String UNIVERSITY_ID = "university_id";
    public static final String OVERALL_EXPERIENCE = "overall_experience";
    public static final String DEPARTMENT_ID = "department_id";

    private int candidateId;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private int universityId;
    private int overallExperience;
    private int departmentId;

    private University university;
    private Department department;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getOverallExperience() {
        return overallExperience;
    }

    public void setOverallExperience(int overallExperience) {
        this.overallExperience = overallExperience;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static String getViewModelColumns() {
        StringJoiner changedColumns = new StringJoiner(", ");
        changedColumns.add(ID).add(BIRTH_DATE).add(FIRST_NAME)
                .add(LAST_NAME).add(GENDER).add(UNIVERSITY_ID).add(OVERALL_EXPERIENCE).add(DEPARTMENT_ID);
        return String.valueOf(changedColumns);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", universityId=" + universityId +
                ", overallExperience=" + overallExperience +
                ", departmentId=" + departmentId +
                ", university=" + university +
                ", department=" + department +
                '}';
    }
}
