package com.stephen.parkinglot.commands;

import com.stephen.parkinglot.services.ParkingLotService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//     use Chain of Responsibility Design Pattern
// https://www.geeksforgeeks.org/chain-responsibility-design-pattern/

//@Getter
//@RequiredArgsConstructor
//@FunctionalInterface
abstract class ParkingChain {
	
	// TODO: make exception?
	public static final String UNKNOWN_COMMAND = "Command not recognized";
	
	private ParkingChain chain;
	
	public ParkingChain(ParkingChain chain) {
		this.chain = chain;
	}
	
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		if (chain != null)
			return chain.process(commandName, commandArgs, parkingLotService);
		
		return UNKNOWN_COMMAND;
	}
/*
	private final ParkingCommand parkingCommand;
	private final String parameters;
	
//	private final ParkingLotService parkingLotService;
	
	public abstract String performAction(String commandArgs);
	
	public String processCommand(String commandName, String commandArgs) {
//		if (this.parkingCommand.getCommandLabel().equals( commandName  ) ) {
//			return performAction(commandArgs);
//		} else {
//			
//		}
		
		return null;
	}
	*/
}
