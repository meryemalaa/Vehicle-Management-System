public class Car {
    protected String brand;
    protected int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void displayInfo() {
        System.out.println(brand + " - " + year);
    }
}
