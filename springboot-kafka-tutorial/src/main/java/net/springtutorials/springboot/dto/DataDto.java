package net.springtutorials.springboot.dto;

public class DataDto {

    private String name;
    private String description;

    public DataDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
