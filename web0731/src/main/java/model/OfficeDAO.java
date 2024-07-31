package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;
public class OfficeDAO {
	EntityManager createManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("web0731");
		return factory.createEntityManager();
	}
	
	 public List<Office> getAll() {
		   EntityManager em=createManager();
		   em.getTransaction().begin();
		   
//		 List<Supplier> sups=em.createNativeQuery("select * from classicmodels.suppliers").getResultList();
		 
		   List<Office> ofs=em.createQuery("select o from Office o").getResultList();
		   return ofs;
	   }

	public boolean saveOffice() {
		EntityManager em = createManager();
		try {
			em.getTransaction().begin();			
			Office f1=new Office();
			f1.setOfficeCode("10");
			f1.setCity("Taipei");
			f1.setCountry("TW");
			f1.setPhone("0223826015");
			f1.setAddressLine1("Kung Yuan Road");
			f1.setPostalCode("100");
			f1.setState("TW");
			f1.setTerritory("ASIA");
			List<Employee> data=new ArrayList<>();
			Employee e1=new Employee();
			e1.setEmployeeNumber(2000);
			e1.setFirstName("May");
			e1.setLastName("Wang");
			e1.setEmail("may@gjun.com");
			e1.setExtension("0x123");
			e1.setJobTitle("Sales");
			e1.setReportsTo(1056);
//			e1.setOffice(f1);
			data.add(e1);
			e1=new Employee();
			e1.setEmployeeNumber(2001);
			e1.setFirstName("Cindy");
			e1.setLastName("Lin");
			e1.setEmail("cindy@gjun.com");
			e1.setExtension("0x456");
			e1.setJobTitle("Sales");
			e1.setReportsTo(1056);
//			e1.setOffice(f1);
			data.add(e1);
			f1.setEmployees(data);
			em.persist(f1);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			System.out.println("Office 1-> * error:" + ex.getMessage());
			return false;
		}

	}
}
