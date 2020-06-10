package com.example.itcompanyfinal.model;

import java.util.StringJoiner;

public class Language {
    public static final String TABLE_NAME = "language";
    public static final String ID = "language_id";
    public static final String NAME = "language_name";

    private int languageId;
    private String languageName;


    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public static String getViewModelColumns() {
        StringJoiner changedColumns = new StringJoiner(", ");
        changedColumns.add(ID).add(NAME);
        return String.valueOf(changedColumns);
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
