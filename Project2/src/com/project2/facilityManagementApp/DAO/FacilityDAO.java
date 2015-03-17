package com.project2.facilityManagementApp.DAO;

import java.util.List;

import com.project2.facilityManagementApp.model.Facility.FacilityImpl;
import org.hibernate.Query;
import org.hibernate.Session;

public class FacilityDAO {

    public void addFacility(FacilityImpl bldg) {
        System.out.println("Adding Facility to DB: " + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        if (session.getTransaction() != null
                && session.getTransaction().isActive()) {
            session.getTransaction();
        } else {
            session.beginTransaction();
        }
//        session.beginTransaction();
        session.save(bldg);
        session.getTransaction().commit();
    }

    public void removeFacility(FacilityImpl bldg) {
        System.out.println("Removing Facility from DB: " + bldg.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        if (session.getTransaction() != null
                && session.getTransaction().isActive()) {
            session.getTransaction();
        } else {
            session.beginTransaction();
        }

//        session.beginTransaction();
        session.delete(bldg);
        session.getTransaction().commit();
    }

    public FacilityImpl retrieveFacility(int id) {
        try {
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                session.getTransaction();
            } else {
                session.beginTransaction();
            }
//            session.beginTransaction();
            System.out.println("Getting Facility from DB: " + id);
            Query getFacilityQuery = session.createQuery("From FacilityImpl bl where bl.FacilitySerialNumber = :id");
            getFacilityQuery.setParameter("id", id);

            List bldgList = getFacilityQuery.list();

            session.getTransaction().commit();
            return (FacilityImpl)bldgList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
