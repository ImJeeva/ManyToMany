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
@Table(name = "Project")
public class Project {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "projectName")
	private String projectName;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "emp_pro",
			joinColumns = @JoinColumn(name = "pro_id"),
			inverseJoinColumns = @JoinColumn(name = "emp_id")
			)
	private List<Employee> employee;
	public Project() {
		
	}
	
	public Project(int id, String projectName) {
		super();
		this.id = id;
		this.projectName = projectName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getprojectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public String toString() {
		return id+", "+projectName;
	}
	

}
