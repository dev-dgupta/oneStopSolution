package oopsConcept.understandingBasicConcepts;

abstract class Vehicle {

    int vehicleId;
    protected String vehicleName;

    public Vehicle() {
        System.out.println("I am in vehicle constructor");
    }

    public Vehicle(int vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        System.out.println("I am in parametrized constructor of Vehicle");
    }

    public abstract void drive();

    public int getVehicleId() {
        return vehicleId;
    }

    void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}

abstract class Car{


    public Car() {
        System.out.println("I am in Car constructor...");
    }

    abstract void isTopModel();

    void drive() {
        System.out.println("Drives only on road");
    }

}


public class Mercedez extends Car{

    public Mercedez() {
        System.out.println("I am in Mercedeez constructor");
    }

    @Override
    void isTopModel() {
        System.out.println("Yes, I am a top model");
    }
}
