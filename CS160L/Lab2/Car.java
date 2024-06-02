/**
 *  Lab 2
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/2/24
 *  @author  Jacob Archer
  */

public class Car {
    protected int year;
    protected double price;

    public double computeAgePriceRatio() {
        return (2024 - (double) year) / price;
    }
}