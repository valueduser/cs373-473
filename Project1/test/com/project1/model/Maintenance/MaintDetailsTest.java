package com.project1.model.Maintenance;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.project1.model.Facility.*;

public class MaintDetailsTest {
	private MaintDetails details = new MaintDetails();
	private FacilityInterface fac = new Building();
	
	@Before
	public void setUp() throws Exception {
		
		fac.setFacilityId(1);
		fac.setCapacity(2);
		fac.setDownTime(2000);
		fac.setEndDate(9999);
		fac.setParentId(0);
		fac.setScheduledDownTime(1500);
		fac.setStartDate(408);
		fac.setUnscheduledDownTime(500);
		fac.assignFacilityToUse("Rental");
		fac.vacateFacility(true);
		
		MaintRequest maint1 = new MaintRequest();
		maint1.setFacilitySerialNumber(1);
		maint1.setIsOpen(true);
		maint1.setIsScheduled(true);
		maint1.setMaintType("SEV 1");
		maint1.setRequestID(1);
		maint1.setStartDate(208);
		maint1.setTimeToComplete(20);
	}

	@Test
	public void testScheduleMaintenance() {
		boolean itWorked = false;
		MaintenanceInterface scheduled = details.scheduleMaintenance(fac.getFacilitySerialNumber(), 1, "SEV 1", 500);
		if (scheduled != null){
			itWorked = true;
		}
		assertEquals(itWorked, true);
	}
	
	@Test
	public void testMakeFacilityMaintRequest() {
		boolean itWorked = false;
		MaintenanceInterface scheduled = details.makeFacilityMaintRequest(fac.getFacilitySerialNumber(), 1, "SEV 1", 500, true);
		if (scheduled != null){
			itWorked = true;
		}
		assertEquals(itWorked, true);
	}
	
	@Test
	public void testCalcMaintCostForFacility() {
		boolean itWorked = false;
		double num = details.calcMaintCostForFacility(fac.getFacilitySerialNumber());
		if (num != 0){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testCalcProblemRateForFacility() {
		boolean itWorked = false;
		double num = details.calcProblemRateForFacility(fac);
		if (num != 0){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testCalcDownTimeForFaciliity() {
		boolean itWorked = false;
		double num = details.calcDownTimeForFaciliity(fac.getFacilitySerialNumber());
		if (num != 0){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testListMaintRequestsForFacility() {
		boolean itWorked = false;
		ArrayList<MaintenanceInterface> requests = details.listMaintRequestsForFacility(fac.getFacilitySerialNumber());
		if (requests != null){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testListMaint() {
		boolean itWorked = false;
		ArrayList<MaintenanceInterface> requests = details.listMaint(fac.getFacilitySerialNumber(), " ");
		if (requests != null){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testListFacilityProblems() {
		boolean itWorked = false;
		ArrayList<MaintenanceInterface> requests = details.listFacilityProblems(fac.getFacilitySerialNumber());
		if (requests != null){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testGetMaintenanceList() {
		boolean itWorked = false;
		if (details.getMaintenanceList() != null){
			itWorked = true;
		}
		assertEquals(itWorked, false);
	}
	
	@Test
	public void testSetMaintenanceList() {
		boolean itWorked = false;
		details.setMaintenanceList(null);
		if (details.getMaintenanceList() == null){
			itWorked = true;
		}
		assertEquals(itWorked, true);
	}

}
