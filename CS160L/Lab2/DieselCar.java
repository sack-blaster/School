/**
 *  Lab 2
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/2/24
 *  @author  Jacob Archer
  */

public class DieselCar extends Car {
    private String make;
    private String model;

    public DieselCar() {
        this.year = 0;
        this.make = "";
        this.model = "";
        this.price = 0;
    }

    public DieselCar(int year, double price, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}