package parking.testing;
import org.junit.jupiter.api.Test;

import parking.Car;
import parking.Level;
import parking.ParkingSpot;
import parking.VehicleSize;

class ParkingSpotTesting {

	@Test
	void testEmptySpot() {
		ParkingSpot spot = new ParkingSpot(new Level(0, 0), 2, 1, VehicleSize.Compact);
		assert(spot.getVehicleParked() == null);
	}
	
	@Test
	void testSpotWithVehicle() {
		ParkingSpot spot = new ParkingSpot(new Level(1, 1), 1, 1, VehicleSize.Compact);
		Car car = new Car("Red", "1234");
		spot.park(car);
		assert(spot.getVehicleParked().getLicensePlate() == car.getLicensePlate());
	}

}
