package com.project1.model.Facility;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuildingTest {
	
	private Building bldg;

	@Before
	public void setUp() throws Exception {
		bldg = new Building();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListFacilities() {
		bldg.addNewFacility();
		//TODO add details after each add?
		bldg.addNewFacility();
		bldg.addNewFacility();
		System.out.println(bldg.listFacilities());
	}
//		assert.equals("List Facilities: ", TODO expected, bldg.listFacilities());
//		fail("Not yet implemented");
	

	@Test
	public void testAddNewFacility() {
		bldg.addNewFacility();
		assert.equals("Added new facility: ", TODO expected, bldg.listFacilities());
		fail("Not yet implemented");
	}

	@Test
	public void testAddFacilityDetails() {
		bldg.addNewFacility();
		//TODO somehow get the facilitySerialNumber??
		int facilitySerialNumber = 44;
		bldg.addFacilityDetails(facilitySerialNumber);//TODO what details will this add?
		Building tbldg = new Building();
		tbldg.addFacilityDetails(facilitySerialNumber);
		assert.equals("Added facility details: ", tbldg.getFacilityInformation(facilitySerialNumber), bldg.getFacilityInformation(facilitySerialNumber)); //TODO is toString appropriate here?
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFacility() {
		int facilitySerialNumber = 47;//TODO looks like this will increment
		bldg.addNewFacility();
		//TODO somehow get the facilitySerialNumber??
		bldg.addFacilityDetails(facilitySerialNumber);
		System.out.println("Before removing facility #" + facilitySerialNumber + ": ");
		System.out.println(bldg.listFacilities());
		bldg.removeFacility(facilitySerialNumber);
		fail("Not yet implemented");
	}

	@Test
	public void testIsInUseDuringInterval() {
		int time1 = 20121111; //11-11-2012
		int time2 = 20121212; //12-12-2012
		//TODO somehow get the facilitySerialNumber??
		String useType = "Bakery";
		bldg.assignFacilityToUse(facilitySerialNumber, useType);
		bldg.setStartDate(20121010); //10-10-2012
		bldg.setEndDate(20130101); //1-1-2013
		assert.equals("Is in use: ", true, bldg.isInUseDuringInterval(time1, time2)); //TODO fix return type of isInUseDuringInterval
		fail("Not yet implemented");
	}

	@Test
	public void testListActualUsage() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testCalcUsageRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFacilityUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFacilityInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequestAvailableCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testListFacilityInspections() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVacancy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChildren() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssignFacilityToUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testVacateFacility() {
		//TODO vacate facility
		assert.equals("Vacating Facility: ", true, bldg.getVacancy());
		fail("Not yet implemented");
	}

	@Test
	public void testSetStartDate() {
		int startDate = 20140210;
		bldg.setStartDate(startDate);
		assert.equals("Setting start date: ", 20140210, bldg.getStartDate()); //TODO implement getStartDate
		fail("Not yet implemented");
	}

	@Test
	public void testSetEndDate() {
		int endDate = 20140210;
		bldg.setEndDate(endDate);
		assert.equals("Setting end date: ", 20140210, bldg.getEndDate()); //TODO implement getEndDate
		fail("Not yet implemented");
	}

	@Test
	public void testSetDownTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCapacity() {
		int capacity = 99;
		bldg.setCapacity(capacity);
		assert.equals("Setting Capacity: ", 99, bldg.getCapacity()); //TODO implement getCapacity;
		fail("Not yet implemented");
	}

}
