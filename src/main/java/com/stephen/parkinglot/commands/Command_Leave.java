package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.services.ParkingLotService;

public class Command_Leave extends ParkingChain {

	public Command_Leave(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equals(ParkingCommand.PARK)  ) {
//			parkingLotService.createParkingLot(size);
			return "created!";
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
