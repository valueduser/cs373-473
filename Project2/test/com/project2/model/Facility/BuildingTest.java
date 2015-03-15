package com.project2.model.Facility;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.project2.facilityManagmentApp.model.Facility.*;
import com.project2.facilityManagmentApp.DAO.BuildingDAO;
import com.project2.facilityManagmentApp.DAO.HibernatePGSQLHelper;
import com.project2.facilityManagmentApp.model.Maintenance.MaintRequest;

import org.junit.*;

public class BuildingTest {
//    private int numberOfFacilities;
    private ArrayList<FacilityInterface> facilities = new ArrayList<FacilityInterface>();
    private ArrayList<MaintRequest> maintReports = new ArrayList<MaintRequest>();
    FacilityInterface tempFac = new Building();
    BuildingDAO facDAO = new BuildingDAO();

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
        BuildingDAO facDAO = new BuildingDAO();

        FacilityInterface building1 = new Building();
        building1.setFacilitySerialNumber(1);
        building1.setCapacity(2);
        building1.setDownTime(2000);
        building1.setEndDate(9999);
        building1.setParentId(0);
        building1.setScheduledDownTime(1500);
        building1.setStartDate(408);
        building1.setUnscheduledDownTime(500);
        building1.setUsage("Rental");
        building1.setIsVacant(true);
        facDAO.addBuilding(building1);

        FacilityInterface building2 = new Building();
        building2.setFacilitySerialNumber(0);
        building2.setCapacity(2);
        building2.setDownTime(100000);
        building2.setEndDate(9999);
        building2.setParentId(0);
        building2.setScheduledDownTime(50000);
        building2.setStartDate(101);
        building2.setUnscheduledDownTime(50000);
        building2.setUsage("Commercial");
        building2.setIsVacant(true);
        facDAO.addBuilding(building2);
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");

//        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.createQuery("delete from facilities");
//        session.getTransaction().commit();

        /**
        try{
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM facilities").executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/

        /**
        try {
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE facilities").executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Should have torn down.");
        }*/


    }

    @Before
    public void setUp() throws Exception {
        tempFac = facDAO.retrieveBuilding(1);
    }

    @After
    public void tearDown() throws Exception {
        /**
        facDAO.removeBuilding(tempFac);
        tempFac = new Building();
        tempFac = facDAO.retrieveBuilding(1);
         */

        tempFac = new Building();
//        facDAO.removeBuilding(building1);
//        facDAO.removeBuilding(2);
    }

    @Test
    public void testIsInUseDuringInterval() {
        System.out.println("testIsInUseDuringInterval...");

        int time1 = 234;
        int time2 = 235;
        boolean result = tempFac.isInUseDuringInterval(time1, time2);
        assertEquals(result, false);
    }

    @Test
    public void testListActualUsage() {
        System.out.println("testListActualUsage...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = 9999 - 408 - 2000;
        assertEquals(result, tempFac.listActualUsage(tempFac.getFacilitySerialNumber()));
    }

    @Test
    public void testCalcUsageRate() {
        System.out.println("testCalcUsageRate...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int upTime = tempFac.listActualUsage(tempFac.getFacilitySerialNumber());
        int usageRate = upTime / (tempFac.getEndDate() - tempFac.getStartDate());
        int result = tempFac.calcUsageRate(tempFac.getFacilitySerialNumber());
        assertEquals(result, usageRate);
    }

    @Test
    public void testGetFacilityUse() {
        System.out.println("testGetFacilityUse...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        String result = tempFac.getUsage();
        assertEquals(result, "Rental");
    }

    @Test
    public void testGetDownTime() {
        System.out.println("testGetDownTime...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getDownTime();
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

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.requestAvailableCapacity();
        assertEquals(result, 2);
    }

    @Test
    public void testListFacilityInspections() {
        System.out.println("testListFacilityInspections...");

        boolean isNotNull = false;
//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        if(tempFac.listFacilityInspections(maintReports) != null){
            isNotNull = true;
        }
        assertEquals(isNotNull, false);
    }

    @Test
    public void testGetVacancy() {
        System.out.println("testGetVacancy...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        boolean result = tempFac.getIsVacant();
        assertEquals(result, true);
    }

    @Test
    public void testGetParentId() {
        System.out.println("testGetParentId...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getParentId();
        assertEquals(result, 0);
    }

    @Test
    public void testGetCapacity() {
        System.out.println("testGetCapacity...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getCapacity();
        assertEquals(result, 2);
    }

    @Test
    public void testGetChildren() {
        System.out.println("testGetChildren...");

        boolean isNotNull;
//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        ArrayList<FacilityInterface> children = tempFac.getChildren(facilities);
        if(children != null){
            isNotNull = true;
        }
        else{
            isNotNull = false;
        }
        assertEquals(isNotNull, true);
    }

    @Test
    public void testGetFacilitySerialNumber() {
        System.out.println("testGetFacilitySerialNumber...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getFacilitySerialNumber();
        assertEquals(result, 1);
    }

    @Test
    public void testGetEndDate() {
        System.out.println("testGetEndDate...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getEndDate();
        assertEquals(result, 9999);
    }

    @Test
    public void testGetStartDate() {
        System.out.println("testGetStartDate...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getStartDate();
        assertEquals(result, 408);
    }

    @Test
    public void testGetScheduledDownTime() {
        System.out.println("testGetScheduledDownTime...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getScheduledDownTime();
        assertEquals(result, 1500);
    }

    @Test
    public void testGetUnscheduledDownTime() {
        System.out.println("testGetUnscheduledDownTime...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int result = tempFac.getUnscheduledDownTime();
        assertEquals(result, 500);		}

    @Test
    public void testAssignFacilityToUse() {
        System.out.println("testAssignFacilityToUse...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setIsUsed(false);
        tempFac.setUsage("Restaurant");
        assertEquals(tempFac.getUsage(), "Restaurant");
    }

    @Test
    public void testVacateFacility() {
        System.out.println("testVacateFacility...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setIsVacant(true);
        assertEquals(tempFac.getIsVacant(), true);
    }

    @Test
    public void testSetStartDate() {
        System.out.println("testSetStartDate...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setStartDate(20150216);
        assertEquals(tempFac.getStartDate(), 20150216);
    }

    @Test
    public void testSetEndDate() {
        System.out.println("testSetEndDate...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setEndDate(20150216);
        assertEquals(tempFac.getEndDate(), 20150216);
    }

    @Test
    public void testSetDownTime() {
        System.out.println("testSetDownTime...");

        FacilityInterface tempFac = facDAO.retrieveBuilding(0);
        int dt = tempFac.getDownTime() + 56;
        tempFac.setDownTime(dt);
        assertEquals(tempFac.getDownTime(), 100056);
    }

    @Test
    public void testSetCapacity() {
        System.out.println("testSetCapacity...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setCapacity(3);
        assertEquals(tempFac.getCapacity(), 3);
    }

    @Test
    public void testSetScheduledDownTime() {
        System.out.println("testSetScheduledDownTime...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int schDT = tempFac.getScheduledDownTime() + 111;
        tempFac.setScheduledDownTime(schDT);
        assertEquals(tempFac.getScheduledDownTime(), 1611);
    }

    @Test
    public void testSetUnscheduledDownTime() {
        System.out.println("testSetUnscheduledDownTime...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        int unSchDt = tempFac.getUnscheduledDownTime() + 16;
        tempFac.setUnscheduledDownTime(unSchDt);
        assertEquals(tempFac.getUnscheduledDownTime(), 516);
    }

    @Test
    public void testSetParentId() {
        System.out.println("testSetParentId...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setParentId(11);
        assertEquals(tempFac.getParentId(), 11);
    }

    @Test
    public void testSetFacilityId() {
        System.out.println("testSetFacilityId...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setFacilitySerialNumber(42);
        assertEquals(tempFac.getFacilitySerialNumber(), 42);
    }

    @Test
    public void testSetIsUsed() {
        System.out.println("testSetIsUsed...");

//        FacilityInterface tempFac = facDAO.retrieveBuilding(1);
        tempFac.setIsUsed(false);
        assertEquals(tempFac.getIsUsed(), false);
    }
}
