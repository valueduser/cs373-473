package com.project2.facilityManagementApp.client;

import com.project2.facilityManagementApp.DAO.BuildingDAO;
import com.project2.facilityManagementApp.model.Facility.Building;
import com.project2.facilityManagementApp.model.Facility.FacilityInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
        try {
            BuildingDAO facDAO = new BuildingDAO();

            //Add the buildings
            Building building1 = new Building();
            building1.setFacilitySerialNumber(99);
            building1.setCapacity(2);
            building1.setDownTime(2000);
            building1.setEndDate(9999);
            building1.setParentId(0);
            building1.setScheduledDownTime(1500);
            building1.setStartDate(408);
            building1.setUnscheduledDownTime(500);
            building1.setUsage("Rental");
            building1.setIsVacant(false);
            facDAO.addBuilding(building1);
            System.out.println("Building serial" + building1.getFacilitySerialNumber() + " added.");

            Building building2 = new Building();
            building2.setFacilitySerialNumber(42);
            building2.setCapacity(15);
            building2.setDownTime(0);
            building2.setEndDate(5013);
            building2.setParentId(0);
            building2.setScheduledDownTime(0);
            building2.setStartDate(0);
            building2.setUnscheduledDownTime(0);
            building2.setUsage("Bank");
            building2.setIsVacant(false);
            facDAO.addBuilding(building2);
            System.out.println("Building serial" + building2.getFacilitySerialNumber() + " added.");


            //Delete the Building
            //Find a customer if already exists; if not, create a new one.
            FacilityInterface bldg1 = facDAO.retrieveBuilding(99);
            FacilityInterface bldg2 = facDAO.retrieveBuilding(42);
            System.out.println(bldg1.getFacilitySerialNumber());
            System.out.println(bldg2.getFacilitySerialNumber());


            facDAO.removeBuilding(building1);
            facDAO.removeBuilding(building2);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}