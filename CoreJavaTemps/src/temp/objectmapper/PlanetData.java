package temp.objectmapper;

import java.math.BigDecimal;

public class PlanetData {

    String planetId;
    String planetName;

    Boolean isLifePossible;

    Double distanceFromSun;

    Integer civilizationLevel;

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Boolean getLifePossible() {
        return isLifePossible;
    }

    public void setLifePossible(Boolean lifePossible) {
        isLifePossible = lifePossible;
    }

    public Double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public Integer getCivilizationLevel() {
        return civilizationLevel;
    }

    public void setCivilizationLevel(Integer civilizationLevel) {
        this.civilizationLevel = civilizationLevel;
    }

    public BigDecimal getMass() {
        return mass;
    }

    public void setMass(BigDecimal mass) {
        this.mass = mass;
    }

    public String getSunType() {
        return sunType;
    }

    public void setSunType(String sunType) {
        this.sunType = sunType;
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public String getSunName() {
        return sunName;
    }

    public void setSunName(String sunName) {
        this.sunName = sunName;
    }

    public String getMoonName() {
        return moonName;
    }

    public void setMoonName(String moonName) {
        this.moonName = moonName;
    }

    BigDecimal mass;

    String sunType;

    String galaxyName;

    String sunName;

    String moonName;

    @Override
    public String toString() {
        return "PlanetData{" +
                "planetId='" + planetId + '\n' +
                ", planetName='" + planetName + '\n' +
                ", isLifePossible=" + isLifePossible +
                ", distanceFromSun=" + distanceFromSun +
                ", civilizationLevel=" + civilizationLevel +
                ", mass=" + mass +
                ", sunType='" + sunType + '\n' +
                ", galaxyName='" + galaxyName + '\n' +
                ", sunName='" + sunName + '\n' +
                ", moonName='" + moonName + '\n' +
                '}';
    }
}
