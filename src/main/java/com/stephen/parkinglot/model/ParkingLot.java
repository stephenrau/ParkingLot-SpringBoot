package com.stephen.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.stephen.parkinglot.exceptions.ParkingLotException;

import lombok.Data;
import lombok.NonNull;

@Data
@Component
public class ParkingLot {

	public static final int PARKING_LOT_FULL_CODE = -1;
	
	@NonNull private Integer capacity;		// total number of parking spaces
	private final Map<Integer, CarTicket> mapUsedSpaces;	 // {key,value} -> {slotId, car info}
	
	// TODO: fix this
	public ParkingLot() {
		this.capacity = 0;
		mapUsedSpaces = new HashMap<Integer, ParkingLot.CarTicket>();
	}

	public ParkingLot(int capacity) {
		this.capacity = capacity;
		mapUsedSpaces = new HashMap<Integer, ParkingLot.CarTicket>();
	}
	
	// Display used slots to console
	public String printStatus() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Slot No.  Registration No.\n");
		mapUsedSpaces.forEach( 
				(slotId, ticket) -> sb.append(slotId)
											.append("\t")
											.append(ticket.getRegistrationNumber())
											.append("\n")
											);
		System.out.println(sb);

System.out.println(mapUsedSpaces);   //debugging

		return sb.toString();

	}

	private int getUsedCapacity() {
		return mapUsedSpaces.size();
	}
	
	private int getFirstFreeSlot() {
		// SlotIds are numbered from 1 to totalCapacity
		for (int slotId = 1; slotId <= capacity; slotId++) {
			if ( !mapUsedSpaces.containsKey(slotId) )
				return slotId;
		}
		return PARKING_LOT_FULL_CODE;
	}
	
	// @return slotId allocated to the car, -1 if no spaces available
	public int addCar(String registrationNumber) {
		if (getUsedCapacity() >= capacity) {
			return PARKING_LOT_FULL_CODE;
		}
		int slotId = getFirstFreeSlot();
		CarTicket ticket = new CarTicket(slotId, registrationNumber);
		mapUsedSpaces.put(slotId, ticket);
		
		return slotId;
	}
	
	// TODO: add different payment models / cost processors
	private static float computeCost(int numberHours) {
		final float first_2hours_cost = 10;
		final float cost_per_hour = 10;
		
		float totalCost = first_2hours_cost;
		if (numberHours > 2) {
			totalCost += Math.ceil(numberHours-2) * cost_per_hour;
		}
		return totalCost;
	}
	
	// @return computed cost of parking
	public CarTicket removeCar(String registrationNumber, int numHours) throws ParkingLotException {
		CarTicket carTicket =  
					mapUsedSpaces.values()
					.stream()
					.filter(ticket -> ticket.getRegistrationNumber().equals(registrationNumber))
					.findFirst()
					.orElseThrow( ()->new ParkingLotException("Registration number not found: " + registrationNumber));
		
		float cost = computeCost(numHours);
		carTicket.setCost(cost);
		
		int slotId = carTicket.getSlotId();
		mapUsedSpaces.remove(slotId);
		
		return carTicket;
	}
	
	@Data
	public static class CarTicket {
		@NonNull private Integer slotId;
		@NonNull private String registrationNumber;
		private float parkingTime_Minutes;	// amount of hours parked, not storing the start time for now
		private float cost; 
		
//		public CarTicket(Integer slotId, String registrationNumber) {
//			this.slotId = slotId;
//			this.registrationNumber = registrationNumber;
//		}
	}
	
	private static void testStuff() {
		CarTicket c1 = new CarTicket(1,"xyz");
	}
	
}
