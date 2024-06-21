/**
 *  Lab 4
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/16/24
 *  @author  Jacob Archer
  */

  public abstract class Car implements Comparable<Car>{
    private int year;
    private double price;
    private String make;
    private String model;

    public Car() {
        this.year = 0;
        this.price = 0;
        this.make = "";
        this.model = "";
    }

    public Car(int year, double price, String make, String model) {
        this.year = year;
        this.price = price;
        this.make = make;
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public double computeAgePriceRatio() {
        return (2024 - (double) year) / price;
    }

    public int compareTo(Car other) {
        return Double.compare(this.price, other.price);
    }

    public abstract void setBatteryCapacity(double capacity);

    public abstract void setFuelTankCapacity(double capacity);

    public double getBatteryCapacity() {
        return 0.0;
    }

    public double getFuelTankCapacity() {
        return 0.0;
    }
}
