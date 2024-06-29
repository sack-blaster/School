import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.time.LocalDateTime;

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

    public void InventoryPrintToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // write the current date and time to the file
            writer.write(LocalDateTime.now().toString());
            writer.newLine();
            for (Car car : carList) {
                writer.write(car.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void sortByYear() {
        carList.sort((car1, car2) -> Integer.compare(car1.getYear(), car2.getYear()));
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
