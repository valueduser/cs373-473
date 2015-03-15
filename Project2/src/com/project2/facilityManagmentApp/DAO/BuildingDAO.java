package com.project2.facilityManagmentApp.DAO;

import java.util.List;

import com.project2.facilityManagmentApp.model.Facility.Building;
import com.project2.facilityManagmentApp.model.Facility.FacilityInterface;
import org.hibernate.Query;
import org.hibernate.Session;

public class BuildingDAO {

    public void addBuilding(FacilityInterface bldg) {
        System.out.println("Adding building to DB" + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(bldg);
        session.getTransaction().commit();
    }

    public void removeBuilding(FacilityInterface bldg) {
        System.out.println("Removing building from DB " + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(bldg);
        session.getTransaction().commit();
    }

    public FacilityInterface retrieveBuilding(int id) {
        try {
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getBuildingQuery = session.createQuery("From Building bl where bl.FacilitySerialNumber = :id");
            getBuildingQuery.setParameter("id", id);

            List bldgList = getBuildingQuery.list();

            session.getTransaction().commit();
            return (FacilityInterface)bldgList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<FacilityInterface> retrieveFacNums(){
//        try{
//            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//
//            Query getAllFacNumsQuery = session.createQuery("From Building bl");
//
//            List bldgList = getAllFacNumsQuery.list();
//
//            session.getTransaction().commit();
//            return bldgList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
