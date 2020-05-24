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
@Table(name="mark_table")
public class Mark {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int  Mark_id;
	@Column(name="Mark_value")
    private String head;
	
	
	@OneToOne (optional=false, mappedBy="mark",cascade = CascadeType.ALL)
    private Employee employee;

	public int getMark_id() {
		return Mark_id;
	}
	public void setMark_id(int mark_id) {
		Mark_id = mark_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
}
