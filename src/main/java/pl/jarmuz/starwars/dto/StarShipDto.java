package pl.jarmuz.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
public class StarShipDto {
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmosphericSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String mglt;
    private String starshipClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty(value = "costInCredits", access = JsonProperty.Access.READ_ONLY)
    public String getCostInCredits() {
        return costInCredits;
    }

    @JsonProperty(value = "cost_in_credits", access = JsonProperty.Access.WRITE_ONLY)
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @JsonProperty(value = "maxAtmosphericSpeed", access = JsonProperty.Access.READ_ONLY)
    public String getMaxAtmosphericSpeed() {
        return maxAtmosphericSpeed;
    }

    @JsonProperty(value = "max_atmosphering_speed", access = JsonProperty.Access.WRITE_ONLY)
    public void setMaxAtmosphericSpeed(String maxAtmosphericSpeed) {
        this.maxAtmosphericSpeed = maxAtmosphericSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    @JsonProperty(value = "cargoCapacity", access = JsonProperty.Access.READ_ONLY)
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    @JsonProperty(value = "cargo_capacity", access = JsonProperty.Access.WRITE_ONLY)
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    @JsonProperty(value = "hyperdriveRating", access = JsonProperty.Access.READ_ONLY)
    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    @JsonProperty(value = "hyperdrive_rating", access = JsonProperty.Access.WRITE_ONLY)
    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    @JsonProperty(value = "mglt", access = JsonProperty.Access.READ_ONLY)
    public String getMglt() {
        return mglt;
    }

    @JsonProperty(value = "MGLT", access = JsonProperty.Access.WRITE_ONLY)
    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    @JsonProperty(value = "starshipClass", access = JsonProperty.Access.READ_ONLY)
    public String getStarshipClass() {
        return starshipClass;
    }

    @JsonProperty(value = "starship_class", access = JsonProperty.Access.WRITE_ONLY)
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public StarShipDto() {
    }

    public StarShipDto(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmosphericSpeed, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String mglt, String starshipClass) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmosphericSpeed = maxAtmosphericSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.mglt = mglt;
        this.starshipClass = starshipClass;
    }

    @Override
    public String toString() {
        return "StarShipDto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits='" + costInCredits + '\'' +
                ", length='" + length + '\'' +
                ", maxAtmosphericSpeed='" + maxAtmosphericSpeed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", hyperdriveRating='" + hyperdriveRating + '\'' +
                ", mglt='" + mglt + '\'' +
                ", starshipClass='" + starshipClass + '\'' +
                '}';
    }
}