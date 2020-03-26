package vehicles;

public class Car extends Vehicle {

	private String brand;
	private double height;

	public Car(String brand, double height) {
		this.brand = brand;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Car -> " + "brand: '" + brand + "', height: '" + height + "'";
	}
}
