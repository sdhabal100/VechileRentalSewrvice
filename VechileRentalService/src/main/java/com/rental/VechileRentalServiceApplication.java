package com.rental;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rental.entity.Bike;
import com.rental.entity.Car;
import com.rental.entity.VehicleType;
import com.rental.service.RentalService;

@SpringBootApplication
public class VechileRentalServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VechileRentalServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creating the rental service
				RentalService rentalService = new RentalService();
				Scanner scanner = new Scanner(System.in);

				// Display menu options
				System.out.println("Welcome to the Vehicle Rental Service!");
				System.out.println("Select an option:");
				System.out.println("1. Add a branch");
				System.out.println("2. Add vehicles to a branch");
				System.out.println("3. Rent a vehicle");
				System.out.println("4. Exit");

				// Process user input
				int option = scanner.nextInt();
				scanner.nextLine(); // Consume newline character
				switch (option) {
				case 1:
					System.out.println("You selected: Add a branch");
					addBranch(scanner, rentalService);
					break;
				case 2:
					System.out.println("You selected: Add vehicles to a branch");
					addVehicles(scanner, rentalService);
					break;
				case 3:
					System.out.println("You selected: Rent a vehicle");
					rentVehicle(scanner, rentalService);
					break;
				case 4:
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid option. Exiting the program.");
					break;
				}

				// Close scanner
				scanner.close();
			}

			private static void addBranch(Scanner scanner, RentalService rentalService) {
				System.out.println("Enter the name of the branch:");
				String branchName = scanner.nextLine();
				rentalService.addBranch(branchName);
				System.out.println("Branch '" + branchName + "' added successfully.");
			}

			private static void addVehicles(Scanner scanner, RentalService rentalService) {
				System.out.println("Enter the name of the branch to add vehicles to:");
				String branchName = scanner.nextLine();
				System.out.println("Enter the number of vehicles to add:");
				int numVehicles = scanner.nextInt();
				scanner.nextLine(); // Consume newline character
				for (int i = 0; i < numVehicles; i++) {
					System.out.println("Enter the type of vehicle (CAR or BIKE):");
					String vehicleTypeStr = scanner.nextLine().toUpperCase();
					VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
					System.out.println("Enter the name of the vehicle:");
					String vehicleName = scanner.nextLine();
					if (vehicleType == VehicleType.CAR) {
						rentalService.addVehicle(branchName, new Car(vehicleName));
					} else if (vehicleType == VehicleType.BIKE) {
						rentalService.addVehicle(branchName, new Bike(vehicleName));
					}
				}
				System.out.println("Vehicles added to branch '" + branchName + "' successfully.");
			}

			private static void rentVehicle(Scanner scanner, RentalService rentalService) {
				System.out.println("Enter the name of the branch to rent a vehicle from:");
				String branchName = scanner.nextLine();
				System.out.println("Enter the type of vehicle to rent (CAR or BIKE):");
				String vehicleTypeStr = scanner.nextLine().toUpperCase();
				VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
				System.out.println("Enter the number of hours to rent the vehicle:");
				int hours = scanner.nextInt();
				scanner.nextLine(); // Consume newline character
				rentalService.rentVehicle(branchName, vehicleType, hours);
			}
		
		
	}


