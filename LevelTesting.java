package parking.testing;

import org.junit.jupiter.api.Test;

import parking.Car;
import parking.Level;

public class LevelTesting {
	@Test
	void testEmptyLevel() {
		Level level = new Level(0, 0);
		assert(level.getSpots().length ==  0);
	}
	
	@Test
	void testSpotsEmpty() {
		//1 level with 1 spot
		Level level = new Level(1, 1);
		Car car = new Car("Red", "1234");
		level.parkVehicle(car);
		assert(level.availableSpots() == 0);
	}
	
	
	//Testcase to park a vehicle when Level is full
	@Test
	void testLevelFull() {
		//1 level with 1 spot
		Level level = new Level(1, 1);
		Car car1 = new Car("Red", "1234");
		level.parkVehicle(car1);
		Car car2 = new Car("Green", "2345");
		assert(!level.parkVehicle(car2));
	}
	
}
