package com.stephen.parkinglot.services;

import org.springframework.stereotype.Service;

import com.stephen.parkinglot.model.ParkingLot;

public interface ParkingLotService {

	void createParkingLot(int size);
	
	// @return slotId
	int parkCar(String registrationNumber);
	
	void removeCar(String registrationNumber, int hoursParked);
	
	String getStatus();
}
