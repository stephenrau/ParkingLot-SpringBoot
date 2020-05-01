package com.stephen.parkinglot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.stephen.parkinglot.exceptions.ParkingLotException;
import com.stephen.parkinglot.model.ParkingLot;

import lombok.RequiredArgsConstructor;

//https://hellokoding.com/lombok-in-java-and-spring-boot/
//Since Spring 4.3, for classes with only single constructor, you no longer need to specify an explicit injection annotation @Autowired

@Service
// @RequiredArgsConstructor   // constructor is not implicitly autowired it seems 
public class ParkingLotServiceImpl implements ParkingLotService {

	@Lazy
	private ParkingLot parkingLot; 
	
	@Autowired
	public ParkingLotServiceImpl(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
//		this.parkingLot = new ParkingLot(0);
	}

//	public ParkingLotServiceImpl() {
//		this.parkingLot = new ParkingLot(0);
//	}

	
	@Override
	public void createParkingLot(int size) {
		parkingLot.setCapacity(size);
	}

	@Override
	public int parkCar(String registrationNumber) {
		return parkingLot.addCar(registrationNumber);
	}

	@Override
	public ParkingLot.CarTicket removeCar(String registrationNumber, float hoursParked) 
			throws ParkingLotException {
			return parkingLot.removeCar(registrationNumber, hoursParked);
	}

	@Override
	public String getStatus() {
		return parkingLot.printStatus();

//		return new ParkingLot().printStatus();

/*
		ParkingLot lot = new ParkingLot(10);
		lot.addCar("xyz");
		lot.addCar("abc");
		return lot.printStatus();
*/
	}

}
