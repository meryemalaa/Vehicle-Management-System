public class PetrolCar extends Car {

    public PetrolCar(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void displayInfo() {
        System.out.println(
            brand + " - " + year + " - Petrol Car"
        );
    }
}
