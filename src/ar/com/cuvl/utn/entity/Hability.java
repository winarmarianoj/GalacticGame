package ar.com.cuvl.utn.entity;

public class Hability {


    private String name;
    private int levelRequired;
    private int pointsLevels;
    private String type;

    public Hability(String name, int levelRequired, int pointsLevels, String type) {
        this.name = name;
        this.levelRequired = levelRequired;
        this.pointsLevels = pointsLevels;
        this.type = type;
    }

    public Hability () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }

    public int getPointsLevels() {
        return pointsLevels;
    }

    public void setPointsLevels(int pointsLevels) {
        this.pointsLevels = pointsLevels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
