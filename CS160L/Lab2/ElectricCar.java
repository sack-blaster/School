/**
 *  Lab 4
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/16/24
 *  @author  Jacob Archer
  */

  public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar() {
        super();
        this.batteryCapacity = 0.0;
    }

    public ElectricCar(int year, double price, String make, String model, double batteryCapacity) {
        super(year, price, make, model);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void setFuelTankCapacity(double capacity) {
        // Does nothing for ElectricCar
    }
}
