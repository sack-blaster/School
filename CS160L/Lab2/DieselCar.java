/**
 *  Lab 4
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/16/24
 *  @author  Jacob Archer
  */

  public class DieselCar extends Car {
    private double fuelTankCapacity;

    public DieselCar() {
        super();
        this.fuelTankCapacity = 0.0;
    }

    public DieselCar(int year, double price, String make, String model, double fuelTankCapacity) {
        super(year, price, make, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void setBatteryCapacity(double capacity) {
        // Does nothing for DieselCar
    }
}
