package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.services.ParkingLotService;

public class Command_CreateParkingLot extends ParkingChain {

	public Command_CreateParkingLot(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equalsIgnoreCase(
				ParkingCommandEnum.CREATE_PARKING_LOT.getCommandLabel())  ) {

			// TODO : validate input/ handle format exception			
			int size = Integer.valueOf( commandArgs );
			
			parkingLotService.createParkingLot(size);
			return "Created parking lot with " + size + " slots";
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
