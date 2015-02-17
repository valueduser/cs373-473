package com.project1.model.Facility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.project1.model.Facility.*;
import com.project1.model.Maintenance.MaintDetails;
import com.project1.model.Maintenance.MaintRequest;
import com.project1.model.Maintenance.MaintenanceInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuildingTest {
	private Building bldg;
	private int numberOfFacilities; 
	private ArrayList<FacilityInterface> facilityInfo = new ArrayList<FacilityInterface>();
	private MaintDetails maintDetails = new MaintDetails();
	private ArrayList<MaintenanceInterface> maintReports = new ArrayList<MaintenanceInterface>();

	
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
		
		MaintRequest maint1 = new MaintRequest();
		maint1.setFacilitySerialNumber(1);
		maintReports.add(maint1);
		
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
	}

	@Test
	public void testListActualUsage() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = 9999 - 101 - 100000; 
		assertEquals(result, tempFac.listActualUsage(tempFac.getFacilitySerialNumber()));
	}

	@Test
	public void testCalcUsageRate() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int upTime = tempFac.listActualUsage(tempFac.getFacilitySerialNumber());
		int usageRate = upTime / (tempFac.getEndDate() - tempFac.getStartDate());
		int result = tempFac.calcUsageRate(tempFac.getFacilitySerialNumber());
		assertEquals(result, usageRate);
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
		assertEquals(result, 100000);
	}

	@Test
	public void testGetFacilityInformation() {
		//This is intentionally left blank
	}

	@Test
	public void testRequestAvailableCapacity() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.requestAvailableCapacity();
		assertEquals(result, 2);
	}

	@Test
	public void testListFacilityInspections() {
		FacilityInterface tempFac = facilityInfo.get(1);
		ArrayList<MaintenanceInterface> inspections = maintDetails.listMaint(tempFac.getFacilitySerialNumber(), "INSPECTIONS");
		int length = inspections.size();
		assertEquals(length, 0);
	}

	@Test
	public void testGetVacancy() {
		FacilityInterface tempFac = facilityInfo.get(1);
		boolean result = tempFac.getVacancy();
		assertEquals(result, true);
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
		FacilityInterface tempFac = facilityInfo.get(1);
		ArrayList<FacilityInterface> childeren = tempFac.getChildren(facilityInfo);
		int length = childeren.size();
		assertEquals(length, 0);
	}

	@Test
	public void testGetFacilitySerialNumber() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getFacilitySerialNumber();
		assertEquals(result, 2);	
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
		assertEquals(result, 101);	
	}

	@Test
	public void testGetScheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getScheduledDownTime();
		assertEquals(result, 50000);	
	}

	@Test
	public void testGetUnscheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int result = tempFac.getUnscheduledDownTime();
		assertEquals(result, 50000);		}

	@Test
	public void testAssignFacilityToUse() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setIsUsed(false);
		tempFac.assignFacilityToUse("Restaurant");
		assertEquals(tempFac.getFacilityUse(), "Restaurant");
	}

	@Test
	public void testVacateFacility() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.vacateFacility(true);
		assertEquals(tempFac.getVacancy(), true);
	}

	@Test
	public void testSetStartDate() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setStartDate(20150216);
		assertEquals(tempFac.getStartDate(), 20150216);
	}

	@Test
	public void testSetEndDate() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setEndDate(20150216);
		assertEquals(tempFac.getEndDate(), 20150216);
	}

	@Test
	public void testSetDownTime() {
		FacilityInterface tempFac = facilityInfo.get(0);
		int dt = tempFac.getDownTime() + 56;
		tempFac.setDownTime(dt);
		assertEquals(tempFac.getDownTime(), 2056);
	}

	@Test
	public void testSetCapacity() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setCapacity(3);
		assertEquals(tempFac.getCapacity(), 3);
	}

	@Test
	public void testSetScheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int schDT = tempFac.getScheduledDownTime() + 111;
		tempFac.setScheduledDownTime(schDT);
		assertEquals(tempFac.getScheduledDownTime(), 50111);
	}

	@Test
	public void testSetUnscheduledDownTime() {
		FacilityInterface tempFac = facilityInfo.get(1);
		int unSchDt = tempFac.getUnscheduledDownTime() + 16;
		tempFac.setUnscheduledDownTime(unSchDt);
		assertEquals(tempFac.getUnscheduledDownTime(), 50016);
	}

	@Test
	public void testSetParentId() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setParentId(11);
		assertEquals(tempFac.getParentId(), 11);
	}

	@Test
	public void testSetFacilityId() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setFacilityId(42); 
		assertEquals(tempFac.getFacilitySerialNumber(), 42);
	}

	@Test
	public void testSetIsUsed() {
		FacilityInterface tempFac = facilityInfo.get(1);
		tempFac.setIsUsed(false);
		assertEquals(tempFac.getIsUsed(), false);
	}

}
