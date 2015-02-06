package com.project1.model.Facility


import java.util.ArrayList;
import java.util.List;

public class Room implements Facility {

	public static final int MAX_ROOM_CAPACITY = 3;

	private int serialNumber;
	private int capacity; //number of people in using the room
	private boolean isUsed = false;
	private boolean isVacant = false;
	private String usage;
	private List<Facility> rooms = new ArrayList<Facility>();
	private String inspectionInfo; //will probably change this to a list of inspection objects or, to keep it simple, structs
	private String startDate; //yyyymmdd
	private String endDate; //yyyymmdd
	private float downTime;
}