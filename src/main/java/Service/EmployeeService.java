package Service;


import java.util.List;
import Entity.Department;
import Entity.Employee;


public interface EmployeeService {
	void addEmp(Employee mes);
	List<Department> getDep();
    public List<Object[]> getEmpByDep(int id);
    public List<Integer> daysInMonth(String month);
    public List<Object> getMarks(String month,String depId);
    Department getDepbyName(String nameDEP) ;
    public void addCalendar(String year,Integer month);
    public void addDep(String name);
}
