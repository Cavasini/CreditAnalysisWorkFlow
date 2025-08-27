package tech.buildrun.lambda.model.request.vehicle;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Vehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private String vin;
    private String condition;

    public Vehicle() {
    }

    public Vehicle(String make, String model, int yearOfManufacture, String vin, String condition) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.vin = vin;
        this.condition = condition;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
