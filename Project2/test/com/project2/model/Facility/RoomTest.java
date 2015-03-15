//package com.project2.model.Facility;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.project2.facilityManagmentApp.model.Facility.*;
//import com.project2.facilityManagmentApp.model.Maintenance.MaintDetails;
//import com.project2.facilityManagmentApp.model.Maintenance.MaintRequest;
//import com.project2.facilityManagmentApp.model.Maintenance.MaintenanceInterface;
//
//public class RoomTest {
//    private Room room;
//    private ArrayList<FacilityInterface> facilityInfo = new ArrayList<FacilityInterface>();
//    private MaintDetails maintDetails = new MaintDetails();
//    private ArrayList<MaintenanceInterface> maintReports = new ArrayList<MaintenanceInterface>();
//
//    @Before
//    public void setUp() throws Exception {
//        FacilityInterface room1 = new Room();
//        room1.setFacilitySerialNumber(4);
//        room1.setCapacity(2);
//        room1.setDownTime(1000);
//        room1.setEndDate(9999);
//        room1.setParentId(1);
//        room1.setScheduledDownTime(500);
//        room1.setStartDate(408);
//        room1.setUnscheduledDownTime(500);
//        room1.setUsage("Rental");
//        room1.setIsVacant(false);
//        facilityInfo.add(room1);
//
//        FacilityInterface room2 = new Room();
//        room2.setFacilitySerialNumber(5);
//        room2.setCapacity(2);
//        room2.setDownTime(1000);
//        room2.setEndDate(9999);
//        room2.setParentId(1);
//        room2.setScheduledDownTime(500);
//        room2.setStartDate(408);
//        room2.setUnscheduledDownTime(500);
//        room2.setUsage("Rental");
//        room2.setIsVacant(false);
//        facilityInfo.add(room2);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void testIsInUseDuringInterval() {
//        int time1 = 234;
//        int time2 = 235;
//        FacilityInterface tempFac = facilityInfo.get(1);
//        boolean result = tempFac.isInUseDuringInterval(time1, time2);
//        assertEquals(result, false);
//    }
//
//    @Test
//    public void testListActualUsage() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = 9999 - 408 - 1000;
//        assertEquals(result, tempFac.listActualUsage(tempFac.getFacilitySerialNumber()));
//    }
//
//    @Test
//    public void testCalcUsageRate() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int upTime = tempFac.listActualUsage(tempFac.getFacilitySerialNumber());
//        int usageRate = upTime / (tempFac.getEndDate() - tempFac.getStartDate());
//        int result = tempFac.calcUsageRate(tempFac.getFacilitySerialNumber());
//        assertEquals(result, usageRate);
//    }
//
//    @Test
//    public void testGetFacilityUse() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        String result = tempFac.getUsage();
//        assertEquals(result, "Rental");
//    }
//
//    @Test
//    public void testGetDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getDownTime();
//        assertEquals(result, 1000);
//    }
//
//    @Test
//    public void testGetScheduledDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getScheduledDownTime();
//        assertEquals(result, 500);
//    }
//
//    @Test
//    public void testGetUnscheduledDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getScheduledDownTime();
//        assertEquals(result, 500);
//    }
//
//    @Test
//    public void testRequestAvailableCapacity() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.requestAvailableCapacity();
//        assertEquals(result, 2);
//    }
//
//    @Test
//    public void testListFacilityInspections() {
//        boolean isNotNull = false;
//        FacilityInterface tempFac = facilityInfo.get(1);
//        if(tempFac.listFacilityInspections(maintReports) != null){
//            isNotNull = true;
//        }
//        assertEquals(isNotNull, false);
//    }
//
//    @Test
//    public void testGetVacancy() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        boolean result = tempFac.getIsVacant();
//        assertEquals(result, false);
//    }
//
//    @Test
//    public void testGetParentId() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getParentId();
//        assertEquals(result, 1);
//    }
//
//    @Test
//    public void testGetFacilityInformation() {
//        //This is intentionally left blank
//    }
//
//    @Test
//    public void testGetChildren() {
//        //This is intentionally left blank
//    }
//
//    @Test
//    public void testGetFacilitySerialNumber() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getFacilitySerialNumber();
//        assertEquals(result, 5);
//    }
//
//    @Test
//    public void testGetEndDate() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getEndDate();
//        assertEquals(result, 9999);
//    }
//
//    @Test
//    public void testGetStartDate() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getStartDate();
//        assertEquals(result, 408);
//    }
//
//    @Test
//    public void testGetCapacity() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int result = tempFac.getCapacity();
//        assertEquals(result, 2);	}
//
//    @Test
//    public void testAssignFacilityToUse() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setIsUsed(false);
//        tempFac.setUsage("Restaurant");
//        assertEquals(tempFac.getUsage(), "Restaurant");
//    }
//
//    @Test
//    public void testVacateFacility() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setIsVacant(true);
//        assertEquals(tempFac.getIsVacant(), true);
//    }
//
//    @Test
//    public void testSetStartDate() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setStartDate(20150216);
//        assertEquals(tempFac.getStartDate(), 20150216);
//    }
//
//    @Test
//    public void testSetEndDate() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setEndDate(20150216);
//        assertEquals(tempFac.getEndDate(), 20150216);
//    }
//
//    @Test
//    public void testSetDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(0);
//        int dt = tempFac.getDownTime() + 56;
//        tempFac.setDownTime(dt);
//        assertEquals(tempFac.getDownTime(), 1056);
//    }
//
//    @Test
//    public void testSetCapacity() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setCapacity(3);
//        assertEquals(tempFac.getCapacity(), 3);
//    }
//
//    @Test
//    public void testSetScheduledDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int schDT = tempFac.getScheduledDownTime() + 111;
//        tempFac.setScheduledDownTime(schDT);
//        assertEquals(tempFac.getScheduledDownTime(), 611);
//    }
//
//    @Test
//    public void testSetUnscheduledDownTime() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        int unSchDt = tempFac.getUnscheduledDownTime() + 16;
//        tempFac.setUnscheduledDownTime(unSchDt);
//        assertEquals(tempFac.getUnscheduledDownTime(), 516);
//    }
//
//    @Test
//    public void testSetParentId() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setParentId(11);
//        assertEquals(tempFac.getParentId(), 11);
//    }
//
//    @Test
//    public void testSetFacilityId() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setFacilitySerialNumber(42);
//        assertEquals(tempFac.getFacilitySerialNumber(), 42);
//    }
//
//    @Test
//    public void testSetIsUsed() {
//        FacilityInterface tempFac = facilityInfo.get(1);
//        tempFac.setIsUsed(false);
//        assertEquals(tempFac.getIsUsed(), false);
//    }
//
//}
