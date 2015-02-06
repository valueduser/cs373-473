package com.project1.model.Facility

import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {

	public static final int MAX_BUILDING_CAPACITY = 15;

	private int serialNumber;
	private int capacity; //number of rooms being used multiplied by the capacity of each room
	private boolean isUsed = false;
	private boolean isVacant = false;
	private String usage;
	private List<Facility> rooms = new ArrayList<Facility>();
	private String inspectionInfo; //will probably change this to a list of inspection objects or, to keep it simple, structs
	private String startDate; //yyyymmdd
	private String endDate; //yyyymmdd
	private float downTime;
}