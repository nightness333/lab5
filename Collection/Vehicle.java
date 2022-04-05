package Collection;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle> {

    private Long id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Float enginePower;
    private Long numberOfWheels;
    private VehicleType type;
    private FuelType fuelType;

    public Vehicle ()  {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getEnginePower() {
        return enginePower;
    }

    public Long getNumberOfWheels() {
        return numberOfWheels;
    }

    public VehicleType getType() {
        return type;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnginePower(Float enginePower) {
        this.enginePower = enginePower;
    }

    public void setNumberOfWheels(Long numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate.toString() +
                ", enginePower=" + enginePower +
                ", numberOfWheels=" + numberOfWheels +
                ", type=" + type +
                ", fuelType=" + fuelType +
                '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.getNumberOfWheels() > o.getNumberOfWheels()) {
            return -1;
        } else if (this.getNumberOfWheels() < o.getNumberOfWheels()) {
            return 1;
        } else {
            return 0;
        }
    }
}
