
package org.pran.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.pran.spring.model.Employee;
import org.pran.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author  Prannoy Chandra
 *
 */
@Controller
public class EmployeeController {

	/*private static final Logger logger = Logger.getLogger(EmployeeController.class);*/

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;
	
// this is the default login page for the welearn app 
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("welearn-home");
		return model;
	}
	


	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("signUpPage");
		return model;
	}


	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
			return new ModelAndView("redirect:/loginPage");
		} else {
			employeeService.updateEmployee(employee);
			ModelAndView model = new ModelAndView("postLogin");
			model.addObject("employee", employee);
			return model;
		}
		
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("editProfilePage");
		model.addObject("employee", employee);

		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView modelAndView) {
		Employee employee = new Employee();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/userHomepage", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request, @ModelAttribute Employee employee, BindingResult result, SessionStatus status) {
		boolean error = false;
		System.out.println(employee);
		if(employee.getUserName().isEmpty()){
		        result.rejectValue("userName", "userName.required");
		        error = true;
		}
		if(employee.getPassword().isEmpty()){
	        result.rejectValue("password", "password.required");
	        error = true;
		}
		String userName = request.getParameter("userName");
		String password= request.getParameter("password"); 
		Employee employee2 = employeeService.validateUser(userName,password);
		if(employee2 == null && !employee.getPassword().isEmpty() && !employee.getUserName().isEmpty()) {
			result.rejectValue("password", "combinationWrong");
			error = true;
		}
		ModelAndView model = new ModelAndView();
		if(error) {
			model.setViewName("loginPage");
			return model;
		} else {
			model.addObject("employee", employee2);
			model.setViewName("postLogin");
			status.setComplete();
			return model;	
		}
	}
	
	@RequestMapping(value = "/userHomepage", method = RequestMethod.GET)
	public ModelAndView userHomepage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("postLogin");
		
		return model;
	}
	
	@RequestMapping(value = "/initialPage", method = RequestMethod.GET)
	public ModelAndView initialPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("welearn-home");
		return model;
	}
	
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView aboutUs(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(empId);
		ModelAndView model = new ModelAndView();
		model.addObject("employee", employee);
		model.setViewName("aboutUs");
		return model;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView customers(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(empId);
		ModelAndView model = new ModelAndView();
		model.addObject("employee", employee);
		model.setViewName("customers");
		return model;
	}
}