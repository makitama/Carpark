public class ParkingSpot {

	private String type;
	private int parkingSpotId;
	private boolean taken;

	public ParkingSpot(int parkingSpotId, String type, boolean taken) {
		this.type = type;
		this.parkingSpotId = parkingSpotId;
		this.taken = taken;
	}

	public Boolean isFree() {
		return !taken;
	}

	public int getParkingSpotId() {
		return parkingSpotId;
	}

	public String getType() {
		return type;
	}

	public boolean leaving() {
		if (taken) {
			taken = false;
			return true;
		}
		//todo Parkplatz war nicht belegt exception
		return false;
	}

	public boolean parking() {
		if (taken) {
			//Todo parkplatz belegt exception
			return false;
		}
		taken = true;
		return true;
	}
}
