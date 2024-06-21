import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Car> carList;

    // Default constructor
    public Inventory() {
        this.carList = new ArrayList<>();
    }

    // Method to add a car to the inventory
    public void addCar(Car car) {
        carList.add(car);
    }

    // Method to apply discount to a specific car type
    public void applyDiscount(double discount, Class<?> carType) {
        for (Car car : carList) {
            if (carType.isInstance(car)) {
                double newPrice = car.getPrice() - discount;
                car.setPrice(newPrice);
            }
        }
    }

    // Method to sort cars by price
    public void sortByPrice() {
        Collections.sort(carList);
    }

    // Method to print the inventory
    public void printInventory() {
        for (Car car : carList) {
            System.out.println("Year: " + car.getYear() +
                               " Make: " + car.getMake() +
                               " Model: " + car.getModel() +
                               " Price: $" + car.getPrice());
        }
    }
}
