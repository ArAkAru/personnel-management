package Entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    	private int id_Department;
	
	@Column(name="Department_name")
		private String name;
	 
	@OneToMany (mappedBy="department",cascade = CascadeType.ALL)
		private Collection<Employee> employes;
	 
	 

	public int getId_Department() {
		return id_Department;
	}

	public void setId_Department(int id_Department) {
		this.id_Department = id_Department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employee> employes) {
		this.employes = employes;
	}
	
	public Department(String name) {
		this.name = name;
	}
	public Department() {
	}


	

	
	
	
}
