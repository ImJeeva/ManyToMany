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
		  Employee e1 = new Employee(3,"Jee");
		  Employee e2 = new Employee(4,"Keri");
		  Project p1 = new Project(3,"Google");
		  Project p2 = new Project(4,"Google_mapPP");
		  
		  ArrayList<Project> al = new ArrayList<Project>();
		  al.add(p1);
		  al.add(p2);
		  e1.setProject(al);
		  e2.setProject(al);
		  s.save(e1);
		  s.save(e2);
		  s.save(p1);
		  s.save(p2);
		  
		  t.commit();
		  System.out.println("Success.");
	}

}
