package pl.jarmuz.starwars.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
public class HomeWorldDto {
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;

    public HomeWorldDto() {
    }

    public HomeWorldDto(String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate, String gravity, String terrain, String surfaceWater, String population) {
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "rotationPeriod", access = JsonProperty.Access.READ_ONLY)
    public String getRotationPeriod() {
        return rotationPeriod;
    }

    @JsonProperty(value = "rotation_period", access = JsonProperty.Access.WRITE_ONLY)
    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    @JsonProperty(value = "orbitalPeriod", access = JsonProperty.Access.READ_ONLY)
    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    @JsonProperty(value = "orbital_period", access = JsonProperty.Access.WRITE_ONLY)
    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @JsonProperty(value = "surfaceWater", access = JsonProperty.Access.READ_ONLY)
    public String getSurfaceWater() {
        return surfaceWater;
    }

    @JsonProperty(value = "surface_water", access = JsonProperty.Access.WRITE_ONLY)
    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "HomeWorldDto{" +
                "name='" + name + '\'' +
                ", rotationPeriod='" + rotationPeriod + '\'' +
                ", orbitalPeriod='" + orbitalPeriod + '\'' +
                ", diameter='" + diameter + '\'' +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surfaceWater='" + surfaceWater + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}