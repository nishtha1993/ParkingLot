package parking;

public class Car extends Vehicle{
	public Car(String color, String licensePlate){
		this.spotsNeeded = 1;
		this.size = VehicleSize.Compact;
		this.color = color; 
		this.licensePlate = licensePlate;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is a compact or a large
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
}