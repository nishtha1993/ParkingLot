package parking;

public class ParkingLot {
	private Level[] levels;

	public ParkingLot(int totalLevels, int spotsPerLevel) {
		this.levels = new Level[totalLevels];
		for (int i = 0; i < totalLevels; i++) {
			this.levels[i] = new Level(i, spotsPerLevel);
		}
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < this.levels.length; i++) {
			if (this.levels[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}
	
	public void removeVehicleAtSpot(ParkingSpot spot) {
		spot.removeVehicle();
	}
	
	public Level[] getLevels() {
		return levels;
	}

	public void getStatus() {

		
		int levelNumber = 0;
		for (Level level : this.levels) {
			
			if(level.availableSpots() == level.getSpots().length)
				break;
			
			System.out.println("Level: "+levelNumber);
			System.out.println("SpotNumber" + " " + "Reg No." + " " + " "
					+ "Color");
			
			
			ParkingSpot[] spots = level.getSpots();
			int i = 0;
			for (ParkingSpot spot : spots) {
				if (!spot.isAvailable())
					System.out.print(i + " " + spot.getVehicleParked().getLicensePlate() + " "
							+ spot.getVehicleParked().getColor());
				System.out.println();
				i++;
			}
			levelNumber++;
			System.out.println();
		}

	}
}
