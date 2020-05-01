package com.stephen.parkinglot.commands;

import org.springframework.stereotype.Component;

import com.stephen.parkinglot.services.ParkingLotService;

// why doesn't @Bean work?
@Component
public class CommandProcessor {

	ParkingChain chain;

	public CommandProcessor() {
		buildChain();
	}
	
	private void buildChain() {
		chain = new Command_CreateParkingLot(
						new Command_Park(
							new Command_Leave(
								new Command_Status(null) ) ) );
				
	}
	
	public String process(String commandName, String commandArgs, ParkingLotService parkingLotService) {
		return chain.process(commandName, commandArgs, parkingLotService);
	}
}

