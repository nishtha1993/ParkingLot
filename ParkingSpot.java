package parking;

//implemented by having just a variable which represents the size of the spot
public class ParkingSpot{
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
		this.level = lvl;
		this.row = r;
		this.spotNumber = n;
		this.spotSize = s;
		this.vehicle = null;
	}

	public boolean isAvailable(){
		return this.vehicle == null;
	}
	
	public Vehicle getVehicleParked() {
		return vehicle;
	}
	

	public boolean canFitVehicle(Vehicle vehicle){
		//check if the spot is big enough and is available
		return isAvailable() && vehicle.canFitInSpot(this);
	}

	public boolean park(Vehicle v){
		if (!canFitVehicle(v))
			return false;

		this.vehicle = v;
		this.vehicle.parkInSpot(this);
		return true;
	}

	public int getRow(){
		return this.row;
	}
	public int getSpotNumber(){
		return this.spotNumber;
	}
	public VehicleSize getSize(){
		return this.spotSize;
	}

	public void removeVehicle(){
		this.level.spotFreed();
		this.vehicle = null;
	}
}