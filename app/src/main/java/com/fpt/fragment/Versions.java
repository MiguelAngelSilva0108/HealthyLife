package com.fpt.fragment;

public class Versions {

    private String codename, version, apiLevel, description;
    private boolean expandable;


    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Versions(String codename, String version, String apiLevel, String description) {
        this.codename = codename;
        this.version = version;
        this.apiLevel = apiLevel;
        this.description = description;
        this.expandable = false;
    }

    public String getCodename() {
        return codename;
    }

    public String getVersion() {
        return version;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "versions{" +
                "codename='" + codename + '\'' +
                ", version='" + version + '\'' +
                ", apiLevel='" + apiLevel + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
