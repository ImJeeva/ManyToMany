package ManyToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "eName")
	private String eName;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "emp_pro",
			joinColumns = @JoinColumn (name ="emp_id"),
			inverseJoinColumns = @JoinColumn(name = "pro_id")
			)
	
	private List <Project> project;
	
	public Employee() {
		
	}
	
	public Employee(int id, String eName) {
		super();
		this.id = id;
		this.eName = eName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEName() {
		return eName;
	}
	
	public void setEName(String eName) {
		this.eName = eName;
	}
	
	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public String toString() {
		return id+", "+eName;
	}

}
