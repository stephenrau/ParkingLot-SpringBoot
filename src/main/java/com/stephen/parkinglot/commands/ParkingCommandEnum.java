package com.stephen.parkinglot.commands;

/*
Commands
● Create parking lot of size n : create_parking_lot {capacity}
● Park a car : park {car_number}
● Remove(Unpark) car from : leave {car_number} {hours}
● Print status of parking slot : status
*/

public enum ParkingCommandEnum {
	CREATE_PARKING_LOT("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status");
	
	private final String commandLabel;
	
	private ParkingCommandEnum(String commandLabel) {
		this.commandLabel = commandLabel;
	}
	
	public String getCommandLabel() {
		return commandLabel;
	}
}
