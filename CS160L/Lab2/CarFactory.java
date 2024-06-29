/**
 *  Lab 6
 *  This class is used to create a CarFactory class that creates instances of the GasCar, ElectricCar, and DieselCar classes and prints out their information.
 *  CS160L
 *  6/28/24
 *  @author  Jacob Archer
  */

public class CarFactory {
    public static Car createCar(int year, String make, String model) {
        String carType = CarAPI.getCarType(year, make, model);
        
        switch (carType) {
            case "diesel":
                return new DieselCar(year, Car.API.getCarPrice(year, make, model), make, model, Car.API.getFuelTankCapacity(year, make, model));
            case "gas":
                return new GasCar(year, Car.API.getCarPrice(year, make, model), make, model, Car.API.getFuelTankCapacity(year, make, model));
            case "electric":
                return new ElectricCar(year, Car.API.getCarPrice(year, make, model), make, model, Car.API.getBatteryCapacity(year, make, model));
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);
        }
    }
}
