package parking;

 

public abstract class Vehicle{
	//protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected ParkingSpot parkingSpot = null;
	protected String licensePlate;	

	protected int spotsNeeded;
	protected VehicleSize size;
	protected String color;
	
	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	public VehicleSize getSize(){
		return size;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public String getColor() {
		return color;
	}
	
	public ParkingSpot getSpot() {
		return parkingSpot;
	}
	
	public void parkInSpot(ParkingSpot s){
		//parkingSpots.add(s);
		parkingSpot = s;
	}

	public void clearSpots(){
		//remove car from spot, and notify spot that it's gone
		/*for (int i = 0; i < parkingSpots.size(); i++){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();*/
		if(parkingSpot != null)
			parkingSpot.removeVehicle();
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);
}