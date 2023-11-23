package temp.objectmapper;

public class SimpleData {

    String galaxyName;
    String sunType;

    String sunName;
    String moonName;

    @Override
    public String toString() {
        return "SimpleData{" +
                "galaxyName='" + galaxyName + '\'' +
                ", sunType='" + sunType + '\'' +
                ", sunName='" + sunName + '\'' +
                ", moonName='" + moonName + '\'' +
                '}';
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public String getSunType() {
        return sunType;
    }

    public void setSunType(String sunType) {
        this.sunType = sunType;
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
}
