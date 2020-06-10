package com.example.itcompanyfinal.model;

import java.util.StringJoiner;

public class University {
    public static final String TABLE_NAME = "university";
    public static final String ID = "university_id";
    public static final String NAME = "university_name";
    public static final String RANK_WORLD = "university_rank_world";
    public static final String RANK_KZ = "university_rank_kz";

    private int universityId;
    private String universityName;
    private int universityRankWorld;
    private int universityRankKZ;

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getUniversityRankWorld() {
        return universityRankWorld;
    }

    public void setUniversityRankWorld(int universityRankWorld) {
        this.universityRankWorld = universityRankWorld;
    }

    public int getUniversityRankKZ() {
        return universityRankKZ;
    }

    public void setUniversityRankKZ(int universityRankKZ) {
        this.universityRankKZ = universityRankKZ;
    }

    public static String getViewModelColumns() {
        StringJoiner changedColumns = new StringJoiner(", ");
        changedColumns.add(ID).add(NAME).add(RANK_WORLD)
                .add(RANK_KZ);
        return String.valueOf(changedColumns);
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", universityRankWorld=" + universityRankWorld +
                ", universityRankKZ=" + universityRankKZ +
                '}';
    }
}
