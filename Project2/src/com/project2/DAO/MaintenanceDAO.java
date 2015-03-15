package com.project2.DAO;
import java.util.List;

import com.project2.model.Facility.Building;
import com.project2.model.Facility.FacilityInterface;
import com.project2.model.Maintenance.MaintRequest;
import com.project2.model.Maintenance.MaintenanceInterface;
import org.hibernate.Query;
import org.hibernate.Session;

public class MaintenanceDAO {
    public void addMaintenanceReq(MaintRequest maintReq){
        System.out.println("Adding Maint Req to DB: " + maintReq.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(maintReq);
        session.getTransaction().commit();
    }



    public MaintenanceInterface getMaintenanceReq(int requestID){
        try {
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting Maint Req from DB: " + requestID);

            Query getMaintReqQuery = session.createQuery("From MaintRequest mr where mr.requestID = :id");
            getMaintReqQuery.setParameter("id", requestID);

            List maintList = getMaintReqQuery.list();

            session.getTransaction().commit();
            return (MaintenanceInterface)maintList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeMaintenanceReq(int requestID){
        System.out.println("Removing Maint Req from DB: " + requestID);
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(requestID);
        session.getTransaction().commit();
    }

}
