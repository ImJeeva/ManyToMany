package ManyToMany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		
		  Configuration cf = new Configuration ();
		  cf.configure();
		  cf.addAnnotatedClass(Employee.class);
		  cf.addAnnotatedClass(Project.class);
		  SessionFactory sf = cf.buildSessionFactory();
		  Session s = sf.openSession();
		  Transaction t = s.beginTransaction();
		  Employee e1 = new Employee(7,"fahad");
		  Employee e2 = new Employee(8,"ram");
		  Project p1 = new Project(7,"mete");
		  Project p2 = new Project(8,"instagramlit");
		  
		  ArrayList<Project> al = new ArrayList<Project>();
		  al.add(p1);
		  al.add(p2);
		  e1.setProject(al);
		  e2.setProject(al);
		  s.persist(e1);
		  s.persist(e2);
		  s.persist(p1);
		  s.persist(p2);
		  
		  t.commit();
		  
		  System.out.println("Success.");
	}

}
