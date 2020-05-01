package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.services.ParkingLotService;

public class Command_CreateParkingLot extends ParkingChain {

	public Command_CreateParkingLot(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equals(ParkingCommand.CREATE_PARKING_LOT)  ) {
//			parkingLotService.createParkingLot(size);
			return "created!";
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
