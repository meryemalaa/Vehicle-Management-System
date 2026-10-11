public class ElectricCar extends Car {
    private int battery;

    public ElectricCar(String brand, int year, int battery) {
        super(brand, year);
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            brand + " - " + year +
            " - Electric Car - Battery: " + battery + "%"
        );
    }
}
