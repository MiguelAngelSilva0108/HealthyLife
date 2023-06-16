package com.fpt.fragment;

public class Versions {

    private String codename, version, apiLevel, description;
    private boolean expandable;
    private int image;
    private String version2, apiLevel2, description2;
    private int image2;

    public Versions(String codename, String version, String apiLevel, String description, int image, String version2, String apiLevel2, String description2, int image2) {
        this.codename = codename;
        this.version = version;
        this.apiLevel = apiLevel;
        this.description = description;
        this.image = image;
        this.version2 = version2;
        this.apiLevel2 = apiLevel2;
        this.description2 = description2;
        this.image2 = image2;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
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

    public int getImage() {
        return image;
    }

    public String getVersion2() {
        return version2;
    }

    public String getApiLevel2() {
        return apiLevel2;
    }

    public String getDescription2() {
        return description2;
    }

    public int getImage2() {
        return image2;
    }

    @Override
    public String toString() {
        return "Versions{" +
                "codename='" + codename + '\'' +
                ", version='" + version + '\'' +
                ", apiLevel='" + apiLevel + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", version2='" + version2 + '\'' +
                ", apiLevel2='" + apiLevel2 + '\'' +
                ", description2='" + description2 + '\'' +
                ", image2=" + image2 +
                '}';
    }
}
