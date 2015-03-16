//package com.project2.model.Maintenance;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import build.tools.javazic.Main;
//import com.project2.facilityManagementApp.model.Maintenance.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.project2.facilityManagementApp.model.Facility.*;
//
//public class MaintRequestTest {
//    private ArrayList<MaintRequest> maintRequests = new ArrayList<MaintRequest>();
//
//    @Before
//    public void setUp() throws Exception {
//
//        MaintRequest maint1 = new MaintRequestImpl();
//        maint1.setFacilitySerialNumber(1);
//        maint1.setIsOpen(true);
//        maint1.setIsScheduled(true);
//        maint1.setMaintType("SEV 1");
//        maint1.setRequestId(1);
//        maint1.setStartDate(208);
//        maint1.setTimeToComplete(20);
//        maintRequests.add(maint1);
//
//        MaintRequest maint2 = new MaintRequestImpl();
//        maint2.setFacilitySerialNumber(1);
//        maint2.setIsOpen(false);
//        maint2.setIsScheduled(true);
//        maint2.setMaintType("SEV 2");
//        maint2.setRequestId(2);
//        maint2.setStartDate(290);
//        maint2.setTimeToComplete(20);
//        maintRequests.add(maint2);
//    }
//
//    @Test
//    public void testScheduleMaintenance() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.ScheduleMaintenance(0, 0, "", 0) == null){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testMakeFacilityMaintRequest() {
//        boolean isNull = false;
//        MaintenanceInterface tempMaint = maintRequests.get(1);
//        if (tempMaint.makeFacilityMaintRequest(0, 0, "", 0, false) == null){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testCalcMaintCostForFacility() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.calcMaintCostForFacility(0) == 0){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testCalcProblemRateForFacility() {
//        boolean isNull = false;
//        Facility fac = new FacilityImpl();
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.calcProblemRateForFacility(fac) == 0){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testCalcDownTimeForFaciliity() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.calcDownTimeForFaciliity(0) == 0){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testListMaintRequestsForFacility() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.listMaintRequestsForFacility(0) == null){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testListMaint() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.listMaint(0, " ") == null){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testListFacilityProblems() {
//        boolean isNull = false;
//        MaintRequest tempMaint = maintRequests.get(1);
//        if (tempMaint.listFacilityProblems(0) == null){
//            isNull = true;
//        }
//        assertEquals(isNull, true);
//    }
//
//    @Test
//    public void testSetRequestID() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setRequestId(3);
//        int id = m.getRequestId();
//        assertEquals(id, 3);
//    }
//
//    @Test
//    public void testSetMaintType() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setMaintType("SEV 3");
//        String type = m.getMaintType();
//        assertEquals(type, "SEV 3");
//    }
//
//    @Test
//    public void testSetTimeToComplete() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setTimeToComplete(10);
//        int time = m.getTimeToComplete();
//        assertEquals(time, 10);
//    }
//
//    @Test
//    public void testSetIsOpen() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setIsOpen(true);
//        boolean open = m.getIsOpen();
//        assertEquals(open, true);
//    }
//
//    @Test
//    public void testSetIsScheduled() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setIsScheduled(true);
//        boolean scheduled = m.getIsScheduled();
//        assertEquals(scheduled, true);
//    }
//
//    @Test
//    public void testSetFacilitySerialNumbe() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setFacilitySerialNumber(3);
//        int num = m.getFacilitySerialNumber();
//        assertEquals(num, 3);
//    }
//
//    @Test
//    public void testSetStartDate() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        m.setStartDate(30);
//        int num = m.getStartDate();
//        assertEquals(num, 30);
//    }
//
//    @Test
//    public void testGetRequestID() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        int num = m.getRequestId();
//        assertEquals(num, 2);
//    }
//
//    @Test
//    public void testGetMaintType() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        String type = m.getMaintType();
//        assertEquals(type, "SEV 2");
//    }
//
//    @Test
//    public void testGetTimeToComplete() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        int time = m.getTimeToComplete();
//        assertEquals(time, 20);
//    }
//
//    @Test
//    public void testGetIsOpen() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        boolean open = m.getIsOpen();
//        assertEquals(open, false);
//    }
//
//    @Test
//    public void testGetIsScheduled() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        boolean scheduled = m.getIsScheduled();
//        assertEquals(scheduled, true);
//    }
//
//    @Test
//    public void testGetFacilitySerialNumbe() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        int num = m.getFacilitySerialNumber();
//        assertEquals(num, 1);
//    }
//
//    @Test
//    public void testGetStartDate() {
//        MaintRequest tempMaint = maintRequests.get(1);
//        MaintRequest m = (MaintRequest) tempMaint;
//        int num = m.getStartDate();
//        assertEquals(num, 290);
//    }
//}