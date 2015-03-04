package com.project2.DAO;

import java.util.List;

import com.project2.model.Facility.Building;
import org.hibernate.Query;
import org.hibernate.Session;


public class BuildingDAO {

    public void addBuilding(Building bldg) {
        System.out.println("Adding building to DB" + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(bldg);
        session.getTransaction().commit();
    }

    public void removeBuilding(Building bldg) {
        System.out.println("Removing building from DB " + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(bldg);
        session.getTransaction().commit();
    }

    public Building retrieveBuilding(int id) {
        try {
            //todo
            Building bldg = new Building();
            return bldg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
