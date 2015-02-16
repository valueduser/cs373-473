package com.project1.view;

import com.project1.dal.BuildingDAO;
import com.project1.dal.MaintenanceDAO;
import com.project1.model.Facility.*;
import com.project1.model.Maintenance.*;

import java.util.ArrayList;
import java.util.Iterator;

public class FacilityManagementClient {
	
	public static void main (String args[]) throws Exception {
		BuildingDAO facDAO = new BuildingDAO();
		MaintenanceDAO maintDAO = new MaintenanceDAO();
		
		ArrayList<FacilityInterface> facilityBaseLine = new ArrayList<FacilityInterface>();
		ArrayList<FacilityInterface> facilityInfo = new ArrayList<FacilityInterface>();
		ArrayList<MaintenanceInterface> maintenanceBaseLine = new ArrayList<MaintenanceInterface>();
		ArrayList<MaintenanceInterface> maintenanceInfo = new ArrayList<MaintenanceInterface>();
		
		MaintenanceInterface maintDetailProcessor = new MaintDetails();

		
		
		System.out.println("*********** Searching for existing Facilities objects in Database ****************");
		System.out.println("/n");
		//we need to add the logic check here. Just connect and check the db table length
		int facilityTableLength = 0;
		if(facilityTableLength <1){
			System.out.println("*************************** No Facilites Found ***********************************");
			System.out.println("/n");
			System.out.println("ADDING FACILITIES");
			System.out.println("BUILDINGS:");
			System.out.println("FACILITYID: 1, CAPACITY: 2, ISUSED: true, HASVACANCY: true, USAGE: Rental, STARTDATE: 408, ENDDATE: 9999, SCHEDULEDDOWNTIME: 1500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 2000 , PARENTID: 0");
			System.out.println("FACILITYID: 2, CAPACITY: 2, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 50000, UNSCHEDULEDDOWNTIME: 50000, DOWNTIME: 100000 , PARENTID: 0");
			System.out.println("FACILITYID: 3, CAPACITY: 2, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 80000, UNSCHEDULEDDOWNTIME: 10000, DOWNTIME: 90000 , PARENTID: 0");
			
		
		//add BUILDINGS
			FacilityInterface building1 = new Building();
			building1.setFacilityId(1);
			building1.setCapacity(2000);
			building1.setDownTime(2000);
			building1.setEndDate(9999);
			building1.setParentID(0);
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
			building2.setParentID(0);
			building2.setScheduledDownTime(50000);
			building2.setStartDate(101);
			building2.setUnscheduledDownTime(50000);
			building2.assignFacilityToUse("Rental");
			building2.vacateFacility(true);
			facilityInfo.add(building2);

			
			FacilityInterface building3 = new Building();
			building3.setFacilityId(3);
			building3.setCapacity(2);
			building3.setDownTime(90000);
			building3.setEndDate(9999);
			building3.setParentID(0);
			building3.setScheduledDownTime(80000);
			building3.setStartDate(101);
			building3.setUnscheduledDownTime(10000);
			building3.assignFacilityToUse("Rental");
			building3.vacateFacility(false);
			facilityInfo.add(building3);

			
			System.out.println("ROOMS: ");
			System.out.println("FACILITYID: 4, CAPACITY: 2, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 408, ENDDATE: 9999, SCHEDULEDDOWNTIME: 500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 1000 , PARENTID: 1");
			System.out.println("FACILITYID: 5, CAPACITY: 3, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 408, ENDDATE: 9999, SCHEDULEDDOWNTIME: 500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 1000 , PARENTID: 1");
			System.out.println("FACILITYID: 6, CAPACITY: 2, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 250000, UNSCHEDULEDDOWNTIME: 250000, DOWNTIME: 500000 , PARENTID: 2");
			System.out.println("FACILITYID: 7, CAPACITY: 3, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 250000, UNSCHEDULEDDOWNTIME: 250000, DOWNTIME: 500000 , PARENTID: 2");
			System.out.println("FACILITYID: 8, CAPACITY: 2, ISUSED: true, HASVACANCY: true, USAGE: Rental, STARTDATE: 408, ENDDATE: 9999, SCHEDULEDDOWNTIME: 15000, UNSCHEDULEDDOWNTIME: 15000, DOWNTIME: 30000 , PARENTID: 3");
			System.out.println("FACILITYID: 9, CAPACITY: 3, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 30000, UNSCHEDULEDDOWNTIME: 30000, DOWNTIME: 60000 , PARENTID: 3");
			
			//adding Rooms
			FacilityInterface room1 = new Room();
			room1.setFacilityId(4);
			room1.setCapacity(2);
			room1.setDownTime(1000);
			room1.setEndDate(9999);
			room1.setParentID(1);
			room1.setScheduledDownTime(500);
			room1.setStartDate(408);
			room1.setUnscheduledDownTime(500);
			room1.assignFacilityToUse("Rental");
			room1.vacateFacility(false);
			facilityInfo.add(room1);
			
			FacilityInterface room2 = new Room();
			room2.setFacilityId(5);
			room2.setCapacity(2);
			room2.setDownTime(1000);
			room2.setEndDate(9999);
			room2.setParentID(1);
			room2.setScheduledDownTime(500);
			room2.setStartDate(408);
			room2.setUnscheduledDownTime(500);
			room2.assignFacilityToUse("Rental");
			room2.vacateFacility(false);
			facilityInfo.add(room2);
			
			FacilityInterface room3 = new Room();
			room3.setFacilityId(6);
			room3.setCapacity(2);
			room3.setIsUsed(false);
			room3.setDownTime(500000);
			room3.setEndDate(9999);
			room3.setParentID(2);
			room3.setScheduledDownTime(250000);
			room3.setStartDate(101);
			room3.setUnscheduledDownTime(250000);
			room3.vacateFacility(false);
			facilityInfo.add(room3);

			FacilityInterface room4 = new Room();
			room4.setFacilityId(7);
			room4.setCapacity(3);
			room4.setIsUsed(false);
			room4.setDownTime(500000);
			room4.setEndDate(9999);
			room4.setParentID(2);
			room4.setScheduledDownTime(250000);
			room4.setStartDate(101);
			room4.setUnscheduledDownTime(250000);
			room4.vacateFacility(false);
			facilityInfo.add(room4);
			
			FacilityInterface room5 = new Room();
			room5.setFacilityId(8);
			room5.setCapacity(2);
			room5.setDownTime(30000);
			room5.setEndDate(9999);
			room5.setParentID(1);
			room5.setScheduledDownTime(15000);
			room5.setStartDate(408);
			room5.setUnscheduledDownTime(15000);
			room5.assignFacilityToUse("Rental");
			room5.vacateFacility(false);
			facilityInfo.add(room5);

			FacilityInterface room6 = new Room();
			room6.setFacilityId(9);
			room6.setCapacity(3);
			room6.setDownTime(60000);
			room6.setEndDate(9999);
			room6.setParentID(1);
			room6.setScheduledDownTime(30000);
			room6.setStartDate(101);
			room6.setUnscheduledDownTime(30000);
			room6.assignFacilityToUse("Rental");
			room6.vacateFacility(false);
			facilityInfo.add(room6);
		
			//adding to db
			Iterator<FacilityInterface> it = facilityInfo.iterator();
			while(it.hasNext())
			{
				FacilityInterface obj = it.next();
				facDAO.addNewFacility(obj);
			}
			
		}
		else {
		System.out.println("************ Searching for existing Facilities objects in Database *****************");
		//print facilities from Database
		
		
		System.out.println("************ Searching for existing Maintenance objects in Database *****************");
		
		//print out Maintenance reports for each facility
		
		//facility
		//room
		//room

		
		}
	}
}