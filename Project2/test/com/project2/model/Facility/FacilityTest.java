package com.project2.model.Facility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.project2.facilityManagementApp.Service.ManagementService;
import com.project2.facilityManagementApp.model.Facility.*;

import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;
import com.project2.facilityManagementApp.model.ManagementTools.FacManagerImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacilityTest {
    private ArrayList<Facility> facilities = new ArrayList<Facility>();
    private ArrayList<MaintRequest> maintReports = new ArrayList<MaintRequest>();

    ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");
    ManagementService mgmtServ = (ManagementService) context.getBean("managementService");
    FacilityImpl building1 = (FacilityImpl) context.getBean("facility");
    FacilityImpl building2 = (FacilityImpl) context.getBean("facility");

    FacManagerImpl facMgr = (FacManagerImpl) context.getBean("facManager");

    Boolean setupComplete = false;

    @Before
    public void setUp() throws Exception {
        if (setupComplete) {
            System.out.println("Setup Already Completed.");
            return;
        }
        System.out.println("Adding buildings...");
        //Add the buildings

        building1.setFacilitySerialNumber(1);
        building1.setCapacity(2);
        building1.setDownTime(2000);
        building1.setEndDate(9999);
        building1.setParentId(0);
        building1.setScheduledDownTime(1500);
        building1.setStartDate(408);
        building1.setUnscheduledDownTime(500);
        building1.setAddress("7114 W. 231st St. North Talmadge, OH 44145");
        building1.setUsage("Rental");
        building1.setIsVacant(true);
        mgmtServ.addFacility(building1);
        System.out.println("Building 1 , serial# " + building1.getFacilitySerialNumber() + " added.");

        building2.setFacilitySerialNumber(2);
        building2.setCapacity(2);
        building2.setDownTime(100000);
        building2.setEndDate(9999);
        building2.setParentId(0);
        building2.setScheduledDownTime(50000);
        building2.setStartDate(101);
        building2.setUnscheduledDownTime(50000);
        building2.setUsage("Commercial");
        building2.setAddress("55 E. Darryl Road Route 91 Hudson, OH 50923");
        building2.setIsVacant(true);
        mgmtServ.addFacility(building2);
        System.out.println("Building 2, serial# " + building2.getFacilitySerialNumber() + " added.");

        setupComplete = true;
    }

    @Test
    public void testIsInUseDuringInterval() {
        System.out.println("testIsInUseDuringInterval...");

        int time1 = 234;
        int time2 = 235;
        boolean result = facMgr.isInUseDuringInterval(time1, time2);
        assertEquals(result, false);
    }

    @Test
    public void testListActualUsage() {
        System.out.println("testListActualUsage...");

        int result = 9999 - 408 - 2000;
                    //end - start - downtime
        facMgr.setFacility(building1);
        int upTime = facMgr.listActualUsage(building1.getFacilitySerialNumber());

        assertEquals(result, upTime);
    }

    @Test
    public void testCalcUsageRate() {
        System.out.println("testCalcUsageRate...");

        facMgr.setFacility(building1);
        int upTime = facMgr.listActualUsage(building1.getFacilitySerialNumber());
        int usageRate = upTime / (building1.getEndDate() - building1.getStartDate());
        int result = facMgr.calcUsageRate(building1.getFacilitySerialNumber());

        assertEquals(result, usageRate);
    }

    @Test
    public void testGetFacilityUse() {
        System.out.println("testGetFacilityUse...");

        String result = building1.getUsage();

        assertEquals(result, "Rental");
    }

    @Test
    public void testGetDownTime() {
        System.out.println("testGetDownTime...");

        int result = building1.getDownTime();

        assertEquals(result, 2000);
    }

    @Test
    public void testGetFacilityInformation() {
        System.out.println("testGetFacilityInformation...");

        //This is intentionally left blank
    }

    @Test
    public void testRequestAvailableCapacity() {
        System.out.println("testRequestAvailableCapacity...");

        int result = building1.getCapacity();

        assertEquals(result, 2);
    }

    @Test
    public void testGetVacancy() {
        System.out.println("testGetVacancy...");

        boolean result = building1.getIsVacant();

        assertEquals(result, true);
    }

    @Test
    public void testGetParentId() {
        System.out.println("testGetParentId...");

        int result = building1.getParentId();

        assertEquals(result, 0);
    }

    @Test
    public void testGetCapacity() {
        System.out.println("testGetCapacity...");

        int result = building1.getCapacity();

        assertEquals(result, 2);
    }

    @Test
    public void testGetFacilitySerialNumber() {
        System.out.println("testGetFacilitySerialNumber...");

        int result = building1.getFacilitySerialNumber();

        assertEquals(result, 1);
    }

    @Test
    public void testGetEndDate() {
        System.out.println("testGetEndDate...");

        int result = building1.getEndDate();

        assertEquals(result, 9999);
    }

    @Test
    public void testGetStartDate() {
        System.out.println("testGetStartDate...");

        int result = building1.getStartDate();

        assertEquals(result, 408);
    }

    @Test
    public void testGetScheduledDownTime() {
        System.out.println("testGetScheduledDownTime...");

        int result = building1.getScheduledDownTime();

        assertEquals(result, 1500);
    }

    @Test
    public void testGetUnscheduledDownTime() {
        System.out.println("testGetUnscheduledDownTime...");

        int result = building1.getUnscheduledDownTime();

        assertEquals(result, 500);		}

    @Test
    public void testAssignFacilityToUse() {
        System.out.println("testAssignFacilityToUse...");

        building1.setIsUsed(false);
        building1.setUsage("Restaurant");

        assertEquals(building1.getUsage(), "Restaurant");
    }

    @Test
    public void testVacateFacility() {
        System.out.println("testVacateFacility...");

        building1.setIsVacant(true);

        assertEquals(building1.getIsVacant(), true);
    }

    @Test
    public void testSetStartDate() {
        System.out.println("testSetStartDate...");

        building1.setStartDate(20150216);

        assertEquals(building1.getStartDate(), 20150216);
    }

    @Test
    public void testSetEndDate() {
        System.out.println("testSetEndDate...");

        building1.setEndDate(20150216);

        assertEquals(building1.getEndDate(), 20150216);
    }

    @Test
    public void testSetDownTime() {
        System.out.println("testSetDownTime...");

        int dt = building2.getDownTime() + 56;
        building2.setDownTime(dt);

        assertEquals(building2.getDownTime(), 100056);
    }

    @Test
    public void testSetCapacity() {
        System.out.println("testSetCapacity...");

        building1.setCapacity(3);

        assertEquals(building1.getCapacity(), 3);
    }

    @Test
    public void testSetScheduledDownTime() {
        System.out.println("testSetScheduledDownTime...");

        int schDT = building1.getScheduledDownTime() + 111;
        building1.setScheduledDownTime(schDT);

        assertEquals(building1.getScheduledDownTime(), 1611);
    }

    @Test
    public void testSetUnscheduledDownTime() {
        System.out.println("testSetUnscheduledDownTime...");

        int unSchDt = building1.getUnscheduledDownTime() + 16;
        building1.setUnscheduledDownTime(unSchDt);

        assertEquals(building1.getUnscheduledDownTime(), 516);
    }

    @Test
    public void testSetParentId() {
        System.out.println("testSetParentId...");

        building1.setParentId(11);

        assertEquals(building1.getParentId(), 11);
    }

    @Test
    public void testSetFacilityId() {
        System.out.println("testSetFacilityId...");

        building1.setFacilitySerialNumber(42);

        assertEquals(building1.getFacilitySerialNumber(), 42);
    }

    @Test
    public void testSetIsUsed() {
        System.out.println("testSetIsUsed...");

        building1.setIsUsed(false);

        assertEquals(building1.getIsUsed(), false);
    }
}
