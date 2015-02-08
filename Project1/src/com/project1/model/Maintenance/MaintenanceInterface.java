package com.project1.model.Maintenance;

import com.project1.model.Facility.*;
import java.util.ArrayList;


public interface MaintenanceInterface {

	public void ScheduleMaintenance();
	public void makeFacilityMaintRequest();
	public float calcMaintCostForFacility();
	public float calcProblemRateForFacility();
	public float calcDownTimeForFaciliity();
	public ArrayList<Maintenance> listMaintRequestsForFacility(); //lifetime requests accross all facilities
	public ArrayList<Maintenance> listMaint(); //open requests accross all facilities
	public ArrayList<Maintenance> listFacilityProblems(); // currently open requests for a facility


}