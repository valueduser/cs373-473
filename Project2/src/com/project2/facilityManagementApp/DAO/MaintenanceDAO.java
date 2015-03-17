package com.project2.facilityManagementApp.DAO;
import java.util.List;

import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;
import org.hibernate.Query;
import org.hibernate.Session;

public class MaintenanceDAO {
    public void addMaintenanceReq(MaintRequest maintReq){
        System.out.println("Adding Maint Req to DB: " + maintReq.getFacilitySerialNumber());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        if (session.getTransaction() != null
                && session.getTransaction().isActive()) {
            session.getTransaction();
        } else {
            session.beginTransaction();
        }
//        session.beginTransaction();
        session.save(maintReq);
        session.getTransaction().commit();
    }



    public MaintRequest getMaintenanceReq(int requestID){
        try {
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                session.getTransaction();
            } else {
                session.beginTransaction();
            }
//            session.beginTransaction();
            System.out.println("Getting Maint Req from DB: " + requestID);

            Query getMaintReqQuery = session.createQuery("From MaintRequestImpl mr where mr.requestId = :id");
            getMaintReqQuery.setParameter("id", requestID);

            List maintList = getMaintReqQuery.list();

            session.getTransaction().commit();
            return (MaintRequest)maintList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeMaintenanceReq(MaintRequest maintReq){
        System.out.println("Removing Maint Req from DB: " + maintReq.getRequestId());
        Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
        if (session.getTransaction() != null
                && session.getTransaction().isActive()) {
            session.getTransaction();
        } else {
            session.beginTransaction();
        }
//        session.beginTransaction();
        session.delete(maintReq);
        session.getTransaction().commit();
    }
}
