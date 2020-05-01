package com.stephen.parkinglot.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stephen.parkinglot.commands.FileProcessor;
import com.stephen.parkinglot.exceptions.ParkingLotException;
import com.stephen.parkinglot.model.ParkingLot;
import com.stephen.parkinglot.services.ParkingLotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("parkinglot/api/v1/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ParkingLotController {

	private final ParkingLotService parkingLotService;
	private final FileProcessor fileProcessor;
	
	@GetMapping("status")
	public String getStatus() {
		return parkingLotService.getStatus();
	}

	@GetMapping("create/{size}")
	public void createParkingLot(@PathVariable("size") int size) {
		parkingLotService.createParkingLot(size);
	}

	@GetMapping(path = "parkCar/{registrationNumber}")
	public int parkCar(@PathVariable("registrationNumber") String registrationNumber ) {
		return parkingLotService.parkCar(registrationNumber);
	}
	
	@GetMapping(path = "leave/{registrationNumber}/{hours}")
	public ParkingLot.CarTicket removeCar(@PathVariable("registrationNumber") String registrationNumber,
								@PathVariable("hours") float time) throws ParkingLotException {
		return parkingLotService.removeCar(registrationNumber, time);
	}

//	@GetMapping(path = "readFile/{filePath}")
	@GetMapping(path = "readFile")
	public String readFile(@RequestParam("filePath") String filePath ) throws ParkingLotException {
//		Path path = Paths.get("d:\\parkinglot1.txt");

		return fileProcessor.processParkingLotFile( Paths.get(filePath) );
	}

	
	@RequestMapping(value = { "/", " ", "index" })
	public String index() {
		return " Welcome to the Parking Lot ";
	}

	@GetMapping("hello")
	public String sayHello() {
		return "HELLO! ";
	}
}
