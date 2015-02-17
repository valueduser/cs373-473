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
		
		MaintDetails maintDetailProcessor = new MaintDetails();
		
		
		System.out.println("*********** Searching for existing Facilities objects in Database ****************");
		System.out.println("\n");
		
		
		//we need to add the logic check here. Just connect and check the db table length
		int facilityTableLength = 0;
		if(facilityTableLength <1){
			System.out.println("*************************** No Facilites Found ***********************************");
			System.out.println("\n");
			System.out.println("ADDING FACILITIES");
			System.out.println("BUILDINGS:");
			System.out.println("FACILITYID: 1, CAPACITY: 2, ISUSED: true, HASVACANCY: true, USAGE: Rental, STARTDATE: 408, ENDDATE: 9999, SCHEDULEDDOWNTIME: 1500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 2000 , PARENTID: 0");
			System.out.println("FACILITYID: 2, CAPACITY: 2, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 50000, UNSCHEDULEDDOWNTIME: 50000, DOWNTIME: 100000 , PARENTID: 0");
			System.out.println("FACILITYID: 3, CAPACITY: 2, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 101, ENDDATE: 9999, SCHEDULEDDOWNTIME: 80000, UNSCHEDULEDDOWNTIME: 10000, DOWNTIME: 90000 , PARENTID: 0");
			
		
		//add BUILDINGS
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

			
			FacilityInterface building3 = new Building();
			building3.setFacilityId(3);
			building3.setCapacity(2);
			building3.setDownTime(90000);
			building3.setEndDate(9999);
			building3.setParentId(0);
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
			room1.setParentId(1);
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
			room2.setParentId(1);
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
			room3.setParentId(2);
			room3.setScheduledDownTime(250000);
			room3.setStartDate(101);
			room3.setUnscheduledDownTime(250000);
			room3.assignFacilityToUse("Rental");
			room3.vacateFacility(false);
			facilityInfo.add(room3);

			FacilityInterface room4 = new Room();
			room4.setFacilityId(7);
			room4.setCapacity(3);
			room4.setIsUsed(false);
			room4.setDownTime(500000);
			room4.setEndDate(9999);
			room4.setParentId(2);
			room4.setScheduledDownTime(250000);
			room4.setStartDate(101);
			room4.setUnscheduledDownTime(250000);
			room4.assignFacilityToUse("Rental");
			room4.vacateFacility(false);
			facilityInfo.add(room4);
			
			FacilityInterface room5 = new Room();
			room5.setFacilityId(8);
			room5.setCapacity(2);
			room5.setDownTime(30000);
			room5.setEndDate(9999);
			room5.setParentId(1);
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
			room6.setParentId(1);
			room6.setScheduledDownTime(30000);
			room6.setStartDate(101);
			room6.setUnscheduledDownTime(30000);
			room6.assignFacilityToUse("Rental");
			room6.vacateFacility(false);
			facilityInfo.add(room6);
			
//			adding to db
			Iterator<FacilityInterface> it1 = facilityInfo.iterator();
			while(it1.hasNext())
			{
				facilityTableLength++;
				FacilityInterface obj = it1.next();
				facDAO.addNewFacility(obj);
			}
						
			System.out.println("***************** Searching for Facilities objects in Database *********************");
			//print facilities from Database
			System.out.println("id | capacity | hasVacancy | usage | startDate | endDate | scheduledDownTime | unscheduledDownTime | parentID");
			
			for(int j = 1; j <= facilityTableLength ; j++)
			{
				/** Works as expected
				FacilityInterface tempFac = facilityInfo.get(j);
				System.out.println(tempFac.getFacilitySerialNumber() + "  | " + tempFac.getCapacity() + " | " + 
						tempFac.getVacancy() + " | " + tempFac.getFacilityUse() + " | "	+ tempFac.getStartDate() + 
						" | " + tempFac.getEndDate() + " | " + tempFac.getScheduledDownTime() + " | " + tempFac.getUnscheduledDownTime() +
						" | " + tempFac.getParentId());
				*/
				
			
				
				/**
				 * 0  | 0 | false | null | 0 | 0 | 0 | 0 | 0
				 * Error: [SQLITE_SCHEMA]  The database schema changed (no such column: capacity)
				 */
//				FacilityInterface tempFac = facDAO.getBuilding(j);
//				System.out.println(tempFac.getFacilitySerialNumber() + "  | " + tempFac.getCapacity() + " | " + 
//						tempFac.getVacancy() + " | " + tempFac.getFacilityUse() + " | "	+ tempFac.getStartDate() + 
//						" | " + tempFac.getEndDate() + " | " + tempFac.getScheduledDownTime() + " | " + tempFac.getUnscheduledDownTime() +
//						" | " + tempFac.getParentId());
//				
				
				
				
				/**
				 * 0  | 0 | false | null | 0 | 0 | 0 | 0 | 0
				 * Error: [SQLITE_SCHEMA]  The database schema changed (no such column: capacity)
				 */
//				Building tempFac = new Building();
//				tempFac = facDAO.getBuilding(j);
//				System.out.println(tempFac.getFacilitySerialNumber() + "  | " + tempFac.getCapacity() + " | " + 
//						tempFac.getVacancy() + " | " + tempFac.getFacilityUse() + " | "	+ tempFac.getStartDate() + 
//						" | " + tempFac.getEndDate() + " | " + tempFac.getScheduledDownTime() + " | " + tempFac.getUnscheduledDownTime() +
//						" | " + tempFac.getParentId());
				
				
				/**
				 * 0  | 0 | false | null | 0 | 0 | 0 | 0 | 0
				 * Error: [SQLITE_SCHEMA]  The database schema changed (no such column: capacity)
				 */
				
				 System.out.println(facDAO.getBuilding(j).getFacilitySerialNumber() + " | " + facDAO.getBuilding(j).getCapacity() + " | " + 
						facDAO.getBuilding(j).getVacancy() + " | " + facDAO.getBuilding(j).getFacilityUse() + " | "	+ facDAO.getBuilding(j).getStartDate() + 
						" | " + facDAO.getBuilding(j).getEndDate() + " | " + facDAO.getBuilding(j).getScheduledDownTime() + " | " + facDAO.getBuilding(j).getUnscheduledDownTime() +
						" | " + facDAO.getBuilding(j).getParentId());
				 
			}			
			
			System.out.println("************************* Generating Maintenance objects ****************************");
			
			MaintRequest maint1 = new MaintRequest();
			maint1.setRequestID(1);
			maint1.setFacilitySerialNumber(2);
			maint1.setIsOpen(true);
			maint1.setIsScheduled(false);
			maint1.setMaintType("SEV 3");
			maint1.setStartDate(102);
			maint1.setTimeToComplete(999999999);
			maintenanceInfo.add(maint1);
			
			MaintRequest maint2 = new MaintRequest();
			maint2.setRequestID(1);
			maint2.setFacilitySerialNumber(1);
			maint2.setIsOpen(true);
			maint2.setIsScheduled(true);
			maint2.setMaintType("INSPECTION");
			maint2.setStartDate(400);
			maint2.setTimeToComplete(120);
			maintenanceInfo.add(maint2);
			
			MaintRequest maint3 = new MaintRequest();
			maint3.setRequestID(1);
			maint3.setFacilitySerialNumber(3);
			maint3.setIsOpen(true);
			maint3.setIsScheduled(true);
			maint3.setMaintType("INSPECTION");
			maint3.setStartDate(400);
			maint3.setTimeToComplete(120);
			maintenanceInfo.add(maint3);
			
			MaintRequest maint4 = new MaintRequest();
			maint4.setRequestID(1);
			maint4.setFacilitySerialNumber(3);
			maint4.setIsOpen(true);
			maint4.setIsScheduled(true);
			maint4.setMaintType("SEV 1");
			maint4.setStartDate(410);
			maint4.setTimeToComplete(120);
			maintenanceInfo.add(maint4);
			
			Iterator<MaintenanceInterface> it2 = maintenanceInfo.iterator();
			while(it2.hasNext())
			{
				MaintenanceInterface obj = it2.next();
				MaintRequest m = (MaintRequest) obj;
				maintDAO.addMaintenanceReq(m);
			}
		
			maintDetailProcessor.setMaintenanceList(maintenanceInfo);
			
			System.out.println("***************** Searching for Maintenance objects in Database *********************");
	
			
			//print out Maintenance reports for each facility			
			Iterator<FacilityInterface> it3 = facilityInfo.iterator();
			while(it3.hasNext())
			{
				FacilityInterface obj = it3.next();
				
				System.out.println("Down time for facility " + obj.getFacilitySerialNumber() + " " + maintDetailProcessor.calcDownTimeForFaciliity(obj.getFacilitySerialNumber()));
				System.out.println("Maintenance cost for facility " + obj.getFacilitySerialNumber() + " " + maintDetailProcessor.calcMaintCostForFacility(obj.getFacilitySerialNumber()));
				System.out.println("Problem rate for facility "+ obj.getFacilitySerialNumber() + " " + maintDetailProcessor.calcProblemRateForFacility(obj));
				
				ArrayList<MaintenanceInterface> maintList = maintDetailProcessor.listFacilityProblems(obj.getFacilitySerialNumber());
				if (maintList.size() >0){
					Iterator<MaintenanceInterface> it4 = maintList.iterator();
					while(it4.hasNext())
					{
						MaintenanceInterface obj2 = it4.next();
						MaintRequest m = (MaintRequest) obj2;
						System.out.println("Current problem with facility" + obj.getFacilitySerialNumber() + ": " + m.getRequestID() +", "+ m.getMaintType());
					}
				}
				else{
					System.out.println("There are no current problems with facility " + obj.getFacilitySerialNumber());
				}
				
				ArrayList<MaintenanceInterface> openMaintList = maintDetailProcessor.listMaintRequestsForFacility(obj.getFacilitySerialNumber());
				if(openMaintList.size() > 0){
					Iterator<MaintenanceInterface> it5 = openMaintList.iterator();
					while(it5.hasNext())
					{
						MaintenanceInterface obj2 = it5.next();
						MaintRequest m = (MaintRequest) obj2;
					System.out.println("Maintenance problem for facility "+ obj.getFacilitySerialNumber() + ": " + m.getRequestID() +", "+ m.getMaintType());
					}
				}
				else{
					System.out.println("There are no past problems with facility " + obj.getFacilitySerialNumber());
				}
			}
			
		}
		//clear db
	}
}