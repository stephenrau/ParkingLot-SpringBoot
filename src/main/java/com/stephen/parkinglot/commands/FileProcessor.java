package com.stephen.parkinglot.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stephen.parkinglot.exceptions.ParkingLotException;
import com.stephen.parkinglot.services.ParkingLotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileProcessor {

	private final CommandProcessor processor;
	private final ParkingLotService parkingLotService;
	
	// @return output of processing the file
	public String processParkingLotFile(Path filePath) throws ParkingLotException {
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			
			StringBuilder output = new StringBuilder();
			
			for(String line: lines) {
				String[] array = line.split(" ", 2);
				String args = array.length > 1 ? array[1] : "";
				output.append(  processor.process(array[0], args, parkingLotService) );
				output.append( '\n' );
			}
			
System.out.println(output);	 // DEBUG
			return output.toString();
			
		} catch (IOException e) {
			throw new ParkingLotException("IOException while reading file " + filePath.toString(), e);
		}
	}
}
