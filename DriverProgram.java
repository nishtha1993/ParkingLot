package parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverProgram {

	public static void main(String[] args) {
	 	
		try {
			String fileName=null;
			Scanner sc = null;
//			sc = new Scanner(new File("C:\\Users\\D K Malhotra\\eclipse-workspace\\ParkingLotProject\\src\\parking\\commands.txt"));
			
			if(args.length > 1) {
				fileName = args[0];
				 sc = new Scanner(new File(fileName));
			}
			else
			{
				 sc = new Scanner(System.in);
			}
			ParkingLot parkingLot = null;
			
			

			do {
				String cmd = sc.next();
				
				switch(cmd) {
				
				case "create_parking_lot" : int spotsPerLevel = sc.nextInt();
											parkingLot = new ParkingLot(5, spotsPerLevel);
											System.out.println("Created a parking lot of " + spotsPerLevel + " spots per level.");
											break;
			    
				case "park" : String carNumber = sc.next();
							  String color = sc.next();
							  Car car = new Car(color, carNumber);
							  if(parkingLot.parkVehicle(car))
								  System.out.print("Allocated Spot" + car.getSpot().getSpotNumber());
							  else
								  System.out.print("Sorry, parking lot is full");
							  System.out.println();
							  break;
				case "leave" : int spotNumber = sc.nextInt();
								Level[] levels = parkingLot.getLevels();
								for(Level level : levels) {
									for(ParkingSpot spot : level.getSpots())
										if(spot.getSpotNumber() == spotNumber && !spot.isAvailable()) {
											spot.removeVehicle();
											System.out.print("Spot "+spotNumber+" Freed");
											break;
										}
								}
								System.out.println();
								break;
				
				case "status" : parkingLot.getStatus();
								break;
				
				case "registration_numbers_for_cars_with_colour" : String colorOfCar = sc.next();
																	levels = parkingLot.getLevels();
																	for(Level level : levels) {
																		for(ParkingSpot spot : level.getSpots())
																			if(!spot.isAvailable() && spot.getVehicleParked().getColor().equals(colorOfCar)) 
																				System.out.print(spot.getVehicleParked().getLicensePlate()+",");
																	}
																	System.out.println();
																	break;
				case "slot_number_for_registration_number" : String regNo = sc.next();
																	levels = parkingLot.getLevels();
																	for(Level level : levels) {
																		for(ParkingSpot spot : level.getSpots())
																			if(!spot.isAvailable() && spot.getVehicleParked().getLicensePlate().equals(regNo)) {
																				System.out.println(spot.getSpotNumber());
																				break;
																			}
																	}			
																	System.out.println();
																	break;
																	
				case "slot_numbers_for_cars_with_colour" : String colorName = sc.next();															
															levels = parkingLot.getLevels();
															for(Level level : levels) {
																for(ParkingSpot spot : level.getSpots())
																	if(!spot.isAvailable() && spot.getVehicleParked().getColor().equals(colorName)) {
																		System.out.println(spot.getSpotNumber());
																		break;
																	}
															}				
															System.out.println();
															break;
				case "end" : break;
				default : System.out.println("End Of Execution");
						break;
				
				}
				 
			}while (sc.hasNext() && !sc.nextLine().equals("End"));
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Please enter a valid file address");
			e.printStackTrace();
		}
		
	}
}
