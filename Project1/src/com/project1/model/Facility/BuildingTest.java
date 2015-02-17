package com.project1.model.Facility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.project1.model.Facility.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuildingTest {
	private Building bldg;
	private int numberOfFacilities; 
	private ArrayList<FacilityInterface> facilityInfo = new ArrayList<FacilityInterface>();
	
	@Before
	public void setUp() throws Exception {
		
		FacilityInterface building1 = new Building();
		building1.setFacilityId(1);
		building1.setCapacity(2);
		building1.setDownTime(2000);
		building1.setEndDate(9999);
		building1.setParentId(0);
		building1.setScheduledDownTime(1500);
		building1.setStartDate(408);
		building1.setUnscheduledDownTime(500);
		building1.assignFacilityToUse("Rental");
		building1.vacateFacility(true);
		facilityInfo.add(building1);
		
		FacilityInterface building2 = new Building();
		building2.setFacilityId(2);
		building2.setCapacity(2);
		building2.setDownTime(100000);
		building2.setEndDate(9999);
		building2.setParentId(0);
		building2.setScheduledDownTime(50000);
		building2.setStartDate(101);
		building2.setUnscheduledDownTime(50000);
		building2.assignFacilityToUse("Rental");
		building2.vacateFacility(true);
		facilityInfo.add(building2);
		bldg = new Building();
		
		numberOfFacilities = 2;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsInUseDuringInterval() {
		int time1 = 234;
		int time2 = 235;
		FacilityInterface tempFac = facilityInfo.get(1);
		boolean result = tempFac.isInUseDuringInterval(time1, time2);
		assertEquals(result, false);
		//assert.equals(result, false);
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
		FacilityInterface tempFac = facilityInfo.get(1);
		String result = tempFac.getFacilityUse();
		assertEquals(result, "Rental");
	}

	@Test
	public void testGetDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getDownTime();
		assertEquals(result, 2000);
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
	public void testGetParentId() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getParentId();
		assertEquals(result, 0);
	}

	@Test
	public void testGetCapacity() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getCapacity();
		assertEquals(result, 2);	
	}

	@Test
	public void testGetChildren() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFacilitySerialNumber() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getFacilitySerialNumber();
		assertEquals(result, 1);	
	}

	@Test
	public void testGetEndDate() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getEndDate();
		assertEquals(result, 9999);
	}

	@Test
	public void testGetStartDate() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getStartDate();
		assertEquals(result, 408);	
	}

	@Test
	public void testGetScheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getScheduledDownTime();
		assertEquals(result, 1500);	
	}

	@Test
	public void testGetUnscheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getUnscheduledDownTime();
		assertEquals(result, 500);		}

	@Test
	public void testAssignFacilityToUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testVacateFacility() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStartDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEndDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDownTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetScheduledDownTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUnscheduledDownTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetParentId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFacilityId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIsUsed() {
		fail("Not yet implemented");
	}

}
