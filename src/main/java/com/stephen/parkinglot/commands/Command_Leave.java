package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.exceptions.ParkingLotException;
import com.stephen.parkinglot.model.ParkingLot;
import com.stephen.parkinglot.services.ParkingLotService;

public class Command_Leave extends ParkingChain {

	public Command_Leave(ParkingChain chain) {
		super(chain);
	}

	@Override
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (commandName.equalsIgnoreCase(
				ParkingCommandEnum.LEAVE.getCommandLabel() )  ) {

			String[] array = commandArgs.split(" ");
			String registrationNumber = array[0];
// TODO: validate input			
			int hoursParked = Integer.valueOf(array[1]);
			try {
				ParkingLot.CarTicket ticket = parkingLotService.removeCar(registrationNumber, hoursParked);
				
				return "Registration number " + ticket.getRegistrationNumber() +
						" with Slot number " + ticket.getSlotId() +
						" is free with Charge " + ticket.getCost();
			} catch (ParkingLotException e) {
				return e.getMessage();
			}
		} else {
			return super.process(commandName, commandArgs, parkingLotService);
		}
	}


}
