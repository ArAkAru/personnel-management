package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="calendar")
public class Calendar {
	public Calendar(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Calendar;
	@Column(name="day")
    private String day;
    @Column(name="month")
    private String month;
    @Column(name="year")
    private String year;
    @OneToOne (mappedBy="calendar",cascade = CascadeType.ALL)
    private Employee employee;
 
    public Calendar() {
		
	}

	public int getId_Calendar() {
		return id_Calendar;
	}

	public void setId_Calendar(int id_Calendar) {
		this.id_Calendar = id_Calendar;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	
	
}
