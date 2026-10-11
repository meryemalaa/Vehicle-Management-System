import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static final int MIN_YEAR = 1900;
    static final int MAX_YEAR = 2026;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Vehicle Management System ===");
            System.out.println("1. Add a car");
            System.out.println("2. Add an electric car");
            System.out.println("3. Add a petrol car");
            System.out.println("4. Display all cars");
            System.out.println("5. Search for a car");
            System.out.println("6. Remove a car");
            System.out.println("7. Display petrol cars");
            System.out.println("8. Display petrol cars after a year");
            System.out.println("9. Exit");
          System.out.print("Choose an option: ");

            int choice = readInt(input);

            switch (choice) {
                case 1:
                    addCar(cars, input);
                    break;
                case 2:
                    addElectricCar(cars, input);
                    break;
                case 3:
                    addPetrolCar(cars, input);
                    break;
                case 4:
                    displayCars(cars);
                    break;
                case 5:
                    searchCar(cars, input);
                    break;
                case 6:
                    removeCar(cars, input);
                    break;
                case 7:
                    displayPetrolCars(cars);
                    break;
                
                case 8:
                    displayPetrolCarsAfterYear(cars, input);
                    break;
                case 9:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Choose 1 to 9.");
            }
        }

        input.close();
    }

    static int readInt(Scanner input) {
        while (true) {
            try {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch
              (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                System.out.print("Try again: ");
            }
        }
    }

    static String readBrand(Scanner input) {
        while (true) {
            System.out.print("Brand: ");
            String brand = input.nextLine().trim();

            if (!brand.isEmpty()) {
                return brand;
            }

            System.out.println("Brand cannot be empty.");
        }
    }
  static int readYear(Scanner input) {
        while (true) {
            System.out.print("Year (" + MIN_YEAR + "-" + MAX_YEAR + "): ");
            int year = readInt(input);

            if (year >= MIN_YEAR && year <= MAX_YEAR) {
                return year;
            }

            System.out.println("Invalid year.");
        }
    }

    static int readBattery(Scanner input) {
        while (true) {
            System.out.print("Battery percentage (0-100): ");
            int battery = readInt(input);

            if (battery >= 0 && battery <= 100) {
                return battery;
            }

            System.out.println("Battery must be between 0 and 100.");
        }
    }

    static void addCar(ArrayList<Car> cars, Scanner input) {
        String brand = readBrand(input);
       int year = readYear(input);

        cars.add(new Car(brand, year));
        System.out.println("Car added successfully.");
    }

    static void addElectricCar(
            ArrayList<Car> cars, Scanner input) {
        String brand = readBrand(input);
        int year = readYear(input);
        int battery = readBattery(input);

        cars.add(new ElectricCar(brand, year, battery));
        System.out.println("Electric car added successfully.");
    }
  static void addPetrolCar(
            ArrayList<Car> cars, Scanner input) {
        String brand = readBrand(input);
        int year = readYear(input);

        cars.add(new PetrolCar(brand, year));
        System.out.println("Petrol car added successfully.");
    }

    static void displayCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (Car car : cars) {
            car.displayInfo();
        }
    }
  static void searchCar(
            ArrayList<Car> cars, Scanner input) {
        String brand = readBrand(input);
        boolean found = false;

        for (Car car : cars) {
            if (brand.equalsIgnoreCase(car.getBrand())) {
                car.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Car not found.");
        }
    }

    static void removeCar(
            ArrayList<Car> cars, Scanner input) {
        String brand = readBrand(input);
        Iterator<Car> iterator = cars.iterator();

        while (iterator.hasNext()) {
            Car car = iterator.next();

            if (brand.equalsIgnoreCase(car.getBrand())) {
                iterator.remove();
                System.out.println("Car removed successfully.");
              return;
            }
        }

        System.out.println("Car not found.");
    }

    static void displayPetrolCars(ArrayList<Car> cars) {
        int count = 0;

        for (Car car : cars) {
            if (car instanceof PetrolCar) {
                car.displayInfo();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No petrol car found.");
        }

        System.out.println("Number of petrol cars: " + count);
    }
  
static void displayPetrolCarsAfterYear(
            ArrayList<Car> cars, Scanner input) {
        System.out.print("Enter the minimum year: ");
        int year = readYear(input);
        int count = 0;

        for (Car car : cars) {
            if (car instanceof PetrolCar && car.year >= year) {
                car.displayInfo();
                count++;
            }
        }

        if (count == 0) {
            System.out.println(
                "No petrol cars found from that year."
            );
        }

        System.out.println("Number of petrol cars: " + count);
    }
}
