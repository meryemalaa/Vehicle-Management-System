import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
public class VehicleFileManager {



    public static void saveCars(ArrayList<Car> cars) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter("vehicles.csv"))) {

            writer.write("Type,Brand,Year,Battery");
            writer.newLine();

            for (Car car : cars) {

                String line;

                if (car instanceof ElectricCar) {

                    ElectricCar electricCar = (ElectricCar) car;

                    line = "ElectricCar," + car.getBrand()
                            + "," + car.year
                            + "," + electricCar.getBattery();

                } else if (car instanceof PetrolCar) {

                    line = "PetrolCar," + car.getBrand()
                            + "," + car.year + ",";

                } else {

                    line = "Car," + car.getBrand()
                            + "," + car.year + ",";
                }

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Vehicles saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving vehicles: " + e.getMessage());
        }
    }
    public static ArrayList<Car> loadCars() {
       ArrayList<Car> cars = new ArrayList<>();

    File file = new File("vehicles.csv");
    System.out.println("Reading file: " + file.getAbsolutePath());

    if (!file.exists()) {
        System.out.println("No saved vehicles found.");
        return cars;
    }

    try (BufferedReader reader =
            new BufferedReader(new FileReader(file))) {

        String line = reader.readLine(); // Skip header

        while ((line = reader.readLine()) != null) {

    String[] data = line.split(",", -1);

    if (data.length < 3) {
        continue;
    }

    try {
        String type = data[0];
        String brand = data[1];
        int year = Integer.parseInt(data[2]);
        if (year < 1900 || year > 2026) {
        throw new IllegalArgumentException("Invalid year");
        }

        if (type.equals("ElectricCar") && data.length >= 4) {

            int battery = Integer.parseInt(data[3]);
            cars.add(new ElectricCar(brand, year, battery));

        } else if (type.equals("PetrolCar")) {

            cars.add(new PetrolCar(brand, year));

        } else if (type.equals("Car")) {

            cars.add(new Car(brand, year));
        }

    } catch (IllegalArgumentException e) {

        System.out.println("Invalid data: " + line);
    }
}

System.out.println("Vehicles loaded: " + cars.size());

} catch (IOException e) {

    System.out.println("Error loading vehicles: " + e.getMessage());
}

return cars;
}
}