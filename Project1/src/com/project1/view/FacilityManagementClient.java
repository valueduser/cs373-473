package com.project1.view;

import com.project1.model.Facility.*;
import com.project1.model.Maintenance.*;

import java.util.List;

public class FacilityManagementClient {
	
	public static void main (String args[]) throws Exception {
		System.out.println("*********** Searching for existing Facilities objects in Database ****************");
		System.out.println("/n");
		//we need to add the logic check here. Just connect and check the db table length
		
		
		System.out.println("*************************** No Facilites Found ***********************************");
		System.out.println("/n");
		System.out.println("ADDING FACILITIES");
		System.out.println("BUILDINGS:");
		System.out.println("FACILITYID: 1, CAPACITY: 2, ISUSED: true, HASVACANCY: true, USAGE: Rental, STARTDATE: 20120408, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 1500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 2000 , PARENTID: 0");
		System.out.println("FACILITYID: 2, CAPACITY: 2, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 00010101, ENDDATE: 00010101, SCHEDULEDDOWNTIME: 500000, UNSCHEDULEDDOWNTIME: 500000, DOWNTIME: 1000000 , PARENTID: 0");
		System.out.println("FACILITYID: 3, CAPACITY: 2, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 21000101, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 80000, UNSCHEDULEDDOWNTIME: 10000, DOWNTIME: 90000 , PARENTID: 0");
		
		System.out.println("ROOMS: ");
		System.out.println("FACILITYID: 4, CAPACITY: 2, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 20120408, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 1000 , PARENTID: 1");
		System.out.println("FACILITYID: 5, CAPACITY: 3, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 20120408, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 500, UNSCHEDULEDDOWNTIME: 500, DOWNTIME: 1000 , PARENTID: 1");
		System.out.println("FACILITYID: 6, CAPACITY: 2, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 00010101, ENDDATE: 00010101, SCHEDULEDDOWNTIME: 250000, UNSCHEDULEDDOWNTIME: 250000, DOWNTIME: 500000 , PARENTID: 2");
		System.out.println("FACILITYID: 7, CAPACITY: 3, ISUSED: false, HASVACANCY: true, USAGE: Rental, STARTDATE: 00010101, ENDDATE: 00010101, SCHEDULEDDOWNTIME: 250000, UNSCHEDULEDDOWNTIME: 250000, DOWNTIME: 500000 , PARENTID: 2");
		System.out.println("FACILITYID: 8, CAPACITY: 2, ISUSED: true, HASVACANCY: true, USAGE: Rental, STARTDATE: 20120408, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 15000, UNSCHEDULEDDOWNTIME: 15000, DOWNTIME: 30000 , PARENTID: 3");
		System.out.println("FACILITYID: 9, CAPACITY: 3, ISUSED: true, HASVACANCY: false, USAGE: Rental, STARTDATE: 21000101, ENDDATE: 21000101, SCHEDULEDDOWNTIME: 30000, UNSCHEDULEDDOWNTIME: 30000, DOWNTIME: 60000 , PARENTID: 3");

		//add facilities to db
		
		System.out.println("************ Searching for existing Facilities objects in Database *****************");
		//print facilities from Database
		
		
		System.out.println("************ Searching for existing Maintenance objects in Database *****************");
		
		//print out Maintenance reports for each facility
		
		//facility
		//room
		//room

		
		//clear facility table
	}
}