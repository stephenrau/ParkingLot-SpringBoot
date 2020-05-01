package com.stephen.parkinglot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephen.parkinglot.services.ParkingLotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("parkinglot/api/v1/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ParkingLotController {

	private final ParkingLotService parkingLotService;
	
	@GetMapping("status")
	public String getStatus() {
		return parkingLotService.getStatus();
	}
	
//	@GetMapping("/")
//	public String index() {
//		return " Welcome to the Parking Lot ";
//	}

	@GetMapping("hello")
	public String sayHello() {
		return "HELLO! ";
	}
}
