/**
 *  Lab 6
 *  This program is used to create a main method that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/28/24
 *  @author  Jacob Archer
  */

  public class main {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();
        DieselCar dieselCar = new DieselCar();

        gasCar.setYear(2017);
        gasCar.setMake("Toyota");
        gasCar.setModel("Corolla");
        gasCar.setPrice(20000);
        gasCar.setFuelTankCapacity(50);

        electricCar.setYear(2020);
        electricCar.setMake("Tesla");
        electricCar.setModel("Model 3");
        electricCar.setPrice(40000);
        electricCar.setBatteryCapacity(75);

        dieselCar.setYear(2019);
        dieselCar.setMake("Ford");
        dieselCar.setModel("F-150");
        dieselCar.setPrice(30000);
        dieselCar.setFuelTankCapacity(60);

        System.out.println("Gas Car Year: " + gasCar.getYear());
        System.out.println("Gas Car Make: " + gasCar.getMake());
        System.out.println("Gas Car Model: " + gasCar.getModel());
        System.out.println("Gas Car Price: " + gasCar.getPrice());
        System.out.println("Gas Car Fuel Tank Capacity: " + gasCar.getFuelTankCapacity());
        System.out.println("Gas Car Age Price Ratio: " + gasCar.computeAgePriceRatio());
        System.out.println();
        System.out.println("Electric Car Year: " + electricCar.getYear());
        System.out.println("Electric Car Make: " + electricCar.getMake());
        System.out.println("Electric Car Model: " + electricCar.getModel());
        System.out.println("Electric Car Price: " + electricCar.getPrice());
        System.out.println("Electric Car Battery Capacity: " + electricCar.getBatteryCapacity());
        System.out.println("Electric Car Age Price Ratio: " + electricCar.computeAgePriceRatio());
        System.out.println();
        System.out.println("Diesel Car Year: " + dieselCar.getYear());
        System.out.println("Diesel Car Make: " + dieselCar.getMake());
        System.out.println("Diesel Car Model: " + dieselCar.getModel());
        System.out.println("Diesel Car Price: " + dieselCar.getPrice());
        System.out.println("Diesel Car Fuel Tank Capacity: " + dieselCar.getFuelTankCapacity());
        System.out.println("Diesel Car Age Price Ratio: " + dieselCar.computeAgePriceRatio());

        Inventory inventory = new Inventory();
        inventory.addCar(new GasCar(2024, 20000, "Toyota", "Corolla", 50));
        inventory.addCar(new ElectricCar(2022, 40000, "Tesla", "Model 3", 75));
        inventory.addCar(new DieselCar(2021, 30000, "Ford", "F-150", 60));
        inventory.printInventory();
        inventory.sortByPrice();
        inventory.printInventory();
        System.out.println("After discount:");
        inventory.applyDiscount(1000, GasCar.class);
        inventory.printInventory();
        inventory.InventoryPrintToFile("inventory.txt");
        
        // Test CarFactory
        try {
            Car car1 = CarFactory.createCar(2019, "Tesla", "s");
            System.out.println(car1.getClass().getName());
            Car car2 = CarFactory.createCar(2018, "Ford", "F-450&fuel_type=diesel");
            System.out.println(car2.getClass().getName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Test sortByYear lambda
        System.out.println("Sorted by year:");
        inventory.sortByYear();
        inventory.printInventory();
    }
}
