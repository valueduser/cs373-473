package com.project1.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAL {
	public FacilityDAL() {}
	
	public void listFacilities (){
		//TODO stub
	}
	public void addNewFacility(){
		Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);
          
          statement.executeUpdate("CREATE TABLE person (id integer, name string)");
          statement.executeUpdate("INSERT INTO person values(1, 'leo')");
          
          ResultSet custRS = st.executeQuery(selectCustomerQuery);      

        }
	}
	public void addFacilityDetails(int facilitySerialNumber){
		//TODO stub
	}
	public void removeFacility(int facilitySerialNumber){
		//TODO stub
	}
}
