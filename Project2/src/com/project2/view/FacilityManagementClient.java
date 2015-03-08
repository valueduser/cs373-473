package com.project2.view;

import com.project2.DAO.BuildingDAO;
import com.project2.model.Facility.Building;
import com.project2.model.Facility.FacilityInterface;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Map;

public class FacilityManagementClient {
    //todo stub

    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
        try {
        //            System.out.println("querying all the managed entities...");
        //            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
        //            for (Object key : metadataMap.keySet()) {
        //                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
        //                final String entityName = classMetadata.getEntityName();
        //                final Query query = session.createQuery("from " + entityName);
        //                System.out.println("executing: " + query.getQueryString());
        //                for (Object o : query.list()) {
        //                    System.out.println("  " + o);
        //                }




            System.out.println("*************** INSERT EXAMPLE *************************");
            System.out.println("*************** This example involves Instantiating and Saving Building ***********************");

            System.out.println("*************** Instantiating Building ***********************");
            BuildingDAO facDAO = new BuildingDAO();

            Building building1 = new Building();
            building1.setFacilitySerialNumber(1);
            building1.setCapacity(2);
            building1.setDownTime(2000);
            building1.setEndDate(9999);
            building1.setParentId(0);
            building1.setScheduledDownTime(1500);
            building1.setStartDate(408);
            building1.setUnscheduledDownTime(500);
            building1.setUsage("Rental");
            building1.setIsVacant(true);
            facDAO.addBuilding(building1);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}