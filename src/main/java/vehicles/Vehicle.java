package main.java.vehicles;

public class Vehicle {

	private String color = "";
	private String licenseplate = "";



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	@Override
	public String toString() {
		return "Color: '" + color + "', Licenseplate: '" + licenseplate + "'";
	}
}
