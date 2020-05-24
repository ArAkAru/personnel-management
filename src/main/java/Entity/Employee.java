package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Employee;
    
    @Column(name="Name")
    private String name;
    
    @Column(name="LastName")
    private String lastName;
    
    @Column(name="years")
    private int years;
    
    @Column(name="position")
    private String position;
    
    @OneToOne (optional=true, cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn (name="Calendar_ref_ID")
    private Calendar calendar;
   
    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="Department_FK")
    private Department department;
    
    
    
    @OneToOne (optional=true, cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn (name="Mark_FK",nullable = true)
    private Mark mark;
    
    public int getId_Employee() {
		return id_Employee;
	}

    public void setId_Employee(int id_Employee) {
		this.id_Employee = id_Employee;
	}

    public Department getDepartment() {
		return department;
	}

    public void setDepartment(Department department) {
		
		this.department = department;
	}

    public Mark getMark() {
		return mark;
	}

    public void setMark(Mark mark) {
		this.mark = mark;
	}
    
    public Employee() {
    }

    public int getId() {
        return id_Employee;
    }

    public void setId(int id) {
        this.id_Employee = id;
    }

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public String getLastName() {
		return lastName;
	}
    
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public int getYears() {
		return years;
	}

    public void setYears(int years) {
		this.years = years;
	}

    public String getPosition() {
		return position;
	}

    public void setPosition(String position) {
		this.position = position;
	}

    public Calendar getCalendar() {
		return calendar;
	}

    public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

  
}