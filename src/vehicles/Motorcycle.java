package vehicles;

public class Motorcycle extends Vehicle {

	private final String mtype;

	public Motorcycle(String mtype) {
		this.mtype = mtype;
	}

	@Override
	public String toString() {
		return "Motorcycle -> " + "type: '" + mtype + "'";
	}
}
