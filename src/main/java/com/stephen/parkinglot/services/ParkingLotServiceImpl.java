package com.stephen.parkinglot.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.stephen.parkinglot.model.ParkingLot;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingLotServiceImpl implements ParkingLotService {

	@Lazy
	private ParkingLot parkingLot; 
	
//	public ParkingLotServiceImpl(ParkingLot parkingLot) {
////		this.parkingLot = parkingLot;
//		this.parkingLot = new ParkingLot(0);
//	}

//	public ParkingLotServiceImpl() {
//		this.parkingLot = new ParkingLot(0);
//	}

	
	@Override
	public void createParkingLot(int size) {

	}

	@Override
	public int parkCar(String registrationNumber) {
		return 0;
	}

	@Override
	public void removeCar(String registrationNumber, int hoursParked) {

	}

	@Override
	public String getStatus() {
//		return parkingLot.printStatus();

//		return new ParkingLot().printStatus();
		
		ParkingLot lot = new ParkingLot(10);
		lot.addCar("xyz");
		lot.addCar("abc");
		return lot.printStatus();
	}

}
