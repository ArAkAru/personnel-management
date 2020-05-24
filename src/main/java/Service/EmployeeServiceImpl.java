package Service;

import java.math.BigInteger;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import Entity.Calendar;
import Entity.Department;
import Entity.Employee;
import Entity.Mark;




@Repository
public class EmployeeServiceImpl implements EmployeeService {
		@Autowired
		private SessionFactory sessionFactory;
		@Value("${month.number}")private Integer numberOfMonth; 
		

		
		

		@Transactional
		public List<Integer> daysInMonth(String month) {
			Session currentSession = sessionFactory.getCurrentSession();
			BigInteger count=null;
			List<Integer>dayList=new ArrayList<Integer>();
			Query query=currentSession.createSQLQuery("SELECT count(*) FROM hb_student_tracker.calendar where month=:MONTH").setParameter("MONTH", month);
			List<BigInteger> list = query.list();
			for (BigInteger objects : list) {
				count =(objects);
	        }
	        for(int i=1;i<=count.intValue();i++)
				dayList.add((i));
			
			return dayList;
			
			
		}

		@Transactional
		public List<Object>  getMarks(String month,String depId) {
			Session currentSession = sessionFactory.getCurrentSession();
			SQLQuery<Object> query = currentSession.createSQLQuery("SELECT  Mark_value FROM hb_student_tracker.employee inner join hb_student_tracker.calendar on Calendar_ref_ID=id_Calendar  join hb_student_tracker.mark_table on hb_student_tracker.employee.Mark_FK=hb_student_tracker.mark_table.Mark_id where month=:MONTH AND Department_FK=:DEPID order by id_Employee");
			query.setParameter("MONTH",  month);
			query.setParameter("DEPID",  depId);
			List<Object> rows = query.list();
			return rows;
		}
		
		@Transactional
		public List<Object[]> getEmpByDep(int id) {
			Session currentSession = sessionFactory.getCurrentSession();
			SQLQuery<Object[]> query = currentSession.createSQLQuery("SELECT distinct Name ,LastName,years,position FROM hb_student_tracker.employee where Department_FK=:DEPID");
			query.setParameter("DEPID", id);
			List<Object[]> rows = query.list();
			return rows;
		}
	
		@Transactional
		public List<Department> getDep() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Department> query = currentSession.createQuery("from Department",
																	Department.class);
			List<Department> customers = query.getResultList();
			return customers;
		}
		
		@Transactional
		public Department getDepbyName(String nameDEP) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Department> query = 
					currentSession.createQuery("from Department where name=:nameDEP",
							Department.class);
			query.setParameter("nameDEP",  nameDEP);
			List<Department> customers = query.getResultList();
			return customers.get(0);
		}

		@Transactional
		public void addEmp(Employee mes) {
			Session currentSession = sessionFactory.getCurrentSession();
			
			System.out.println(mes.getName());
			System.out.println(numberOfMonth);
			//System.out.println(getIdOfMonth(2).);
			//System.out.println(getRandomElement(getIdOfMonth(2)));
			//Mark s= (Mark)currentSession.load(Mark.class,11);
			for(Integer i:getIdOfMonth(numberOfMonth)) {
				Employee temp =new Employee();
				temp.setName(mes.getName());
				temp.setLastName((mes.getLastName()));
				temp.setPosition((mes.getPosition()));
				temp.setYears((mes.getYears()));
				temp.setDepartment(mes.getDepartment());
				temp.setCalendar(currentSession.load(Calendar.class,i));
				temp.setMark(currentSession.load(Mark.class,getRandomElement(1,11)));
				currentSession.save(temp);
			}
				
			//mes.setMark(s);
			
			//Month jan = Month.of(2);
			//
		
		}
		public int getRandomElement(int min, int max)

	    {

			max -= min;
			return (int) (Math.random() * ++max) + min;

	    }
		private List<Integer> getIdOfMonth(Integer monthID) {
			Session currentSession = sessionFactory.getCurrentSession();
			List<Integer> idList = currentSession.createQuery("select id_Calendar from Calendar where month=:MONTH").setParameter("MONTH", getNameMonthByID(monthID)).getResultList();
			return idList;
		}
		private String getNameMonthByID(Integer monthID) {
			Month jan = Month.of(monthID);
			Locale loc = Locale.forLanguageTag("ru");
			return jan.getDisplayName(TextStyle.FULL_STANDALONE, loc).toLowerCase();
		}
		@Transactional
		public void addCalendar(String year,Integer month) {
			
			for(Integer i=1;i<=month;i++) {
				
				
				String monthName=getNameMonthByID(numberOfMonth);
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			
				currentSession.save(new Calendar(String.valueOf(i),monthName,year));
			}
		}
		@Transactional
		public void addDep(String name) {
			
			
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			
				currentSession.save(new Department(name));
			
		}
		
	

}











