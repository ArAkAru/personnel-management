package Controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Entity.Calendar;
import Entity.Department;
import Entity.Employee;
import Service.EmployeeService;


@Controller
@PropertySource("classpath:config.properties")
@RequestMapping("/table")
public class CustomerController {
	String monthParam=null;
	String DepID1=null;
	@Value("${month.number}")private Integer numberOfMonth; 
	@Autowired
	private EmployeeService customerService;
	List<Object[]> employes = null;
	List<Integer> daysList=null;
	List<Object> marks = null;
	List<Object[]> calc = null;
	@RequestMapping("/list")
	public String listCustomers(Model depModel,Model empModel,Model model,Model marksModel,@RequestParam(value="name",required = false) String DepID) {
		
		List<Department> departments=customerService.getDep();

		if(DepID!=null) {
			DepID1=DepID;
			
		}
		if(DepID1!=null) {
			System.out.println(DepID1);
			
			employes=customerService.getEmpByDep(Integer.valueOf(DepID1));
			
			empModel.addAttribute("employes",employes);
			
			if(monthParam!=null) {
				
				daysList=customerService.daysInMonth(monthParam);
				marks=customerService.getMarks(monthParam,DepID1);
				model.addAttribute("daysMod",daysList);
				marksModel.addAttribute("markMod",marks);
			
			}
		}
		
		depModel.addAttribute("departments",departments);
		monthParam=null;
		return "main-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel,Model depList) {
		List<Department> depart=customerService.getDep().stream().map(x -> {
			Department n = new Department(); 
            n.setName(x.getName().replace("\"", ""));
            return n;
           
        }).collect(Collectors.toList());
		
		depList.addAttribute("depList", depart);
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "customer-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveCustomer(@ModelAttribute("employee") Employee theEmployee,@RequestParam(value="nameDEP",required = false)String depName) {
		theEmployee.setDepartment(customerService.getDepbyName(depName));
		
		customerService.addEmp(theEmployee);
		return "redirect:/table/list";
	}


	@RequestMapping("/list/setData")
	public String SetData(@RequestParam(value="monthParam",required = false) String month) {
		
		this.monthParam=month;
		return "redirect:/table/list";
		
	}

	
	@RequestMapping(value = "/setup/{year}", method=RequestMethod.GET)
	public String getOrder(@PathVariable String year){
		
		YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(year), numberOfMonth);
		Integer daysInMonth = yearMonthObject.lengthOfMonth(); //28 
		customerService.addCalendar(year, daysInMonth);
		return "redirect:/table/list";
	}
	
	@RequestMapping(value = "/add/{newDep}", method=RequestMethod.GET)
	public String addDep(@PathVariable String newDep){
		
		customerService.addDep(newDep);
		return "redirect:/table/list";
	}
	
}










