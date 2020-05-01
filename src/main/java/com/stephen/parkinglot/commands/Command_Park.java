package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.model.ParkingLot;
import com.stephen.parkinglot.services.ParkingLotService;

public class Command_Park extends ParkingChain {

	public Command_Park(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equalsIgnoreCase(
				ParkingCommandEnum.PARK.getCommandLabel() )  ) {
			int slotId = parkingLotService.parkCar( commandArgs);
			
			if (slotId == ParkingLot.PARKING_LOT_FULL_CODE)
				return "Sorry, parking lot is full";
			else
				return "Allocated slot number: " + slotId;
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
