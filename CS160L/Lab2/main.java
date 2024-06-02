/**
 *  Lab 2
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/2/24
 *  @author  Jacob Archer
  */

public class main {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();
        DieselCar dieselCar = new DieselCar();

        gasCar.setYear(2024);
        gasCar.setMake("Toyota");
        gasCar.setModel("Corolla");
        gasCar.setPrice(20000);

        electricCar.setYear(2024);
        electricCar.setMake("Tesla");
        electricCar.setModel("Model 3");
        electricCar.setPrice(40000);

        dieselCar.setYear(2024);
        dieselCar.setMake("Ford");
        dieselCar.setModel("F-150");
        dieselCar.setPrice(30000);

        System.out.println("Gas Car Year: " + gasCar.getYear());
        System.out.println("Gas Car Make: " + gasCar.getMake());
        System.out.println("Gas Car Model: " + gasCar.getModel());
        System.out.println("Gas Car Price: " + gasCar.getPrice());
        System.out.println("Gas Car Age Price Ratio: " + gasCar.computeAgePriceRatio());
        System.out.println();
        System.out.println("Electric Car Year: " + electricCar.getYear());
        System.out.println("Electric Car Make: " + electricCar.getMake());
        System.out.println("Electric Car Model: " + electricCar.getModel());
        System.out.println("Electric Car Price: " + electricCar.getPrice());
        System.out.println("Electric Car Age Price Ratio: " + electricCar.computeAgePriceRatio());
        System.out.println();
        System.out.println("Diesel Car Year: " + dieselCar.getYear());
        System.out.println("Diesel Car Make: " + dieselCar.getMake());
        System.out.println("Diesel Car Model: " + dieselCar.getModel());
        System.out.println("Diesel Car Price: " + dieselCar.getPrice());
        System.out.println("Diesel Car Age Price Ratio: " + dieselCar.computeAgePriceRatio());
    }
}