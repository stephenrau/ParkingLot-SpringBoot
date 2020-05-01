package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.services.ParkingLotService;

public class Command_Status extends ParkingChain {

	public Command_Status(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equalsIgnoreCase(
				ParkingCommandEnum.STATUS.getCommandLabel())  ) {
			return parkingLotService.getStatus();
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
