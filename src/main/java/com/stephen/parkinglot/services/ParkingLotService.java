package com.stephen.parkinglot.services;

import com.stephen.parkinglot.exceptions.ParkingLotException;
import com.stephen.parkinglot.model.ParkingLot;

public interface ParkingLotService {

	void createParkingLot(int size);
	
	// @return slotId
	int parkCar(String registrationNumber);
	
	// @return cost for parking
	ParkingLot.CarTicket removeCar(String registrationNumber, int hoursParked) throws ParkingLotException;
	
	String getStatus();
}
