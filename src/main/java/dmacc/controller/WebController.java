package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Contact;
import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;

@Controller
public class WebController {
	@Autowired
	EmployeeRepository repo; 

	@GetMapping("/addEmployee")
	public String addNewEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("newEmployee", e);
		return "add";
	}

	@PostMapping("/addEmployee")
	public String addNewContact(@ModelAttribute Employee e, Model model) {
		repo.save(e);
		model.addAttribute("employees", repo.findAll());
		return "results";
		}

	@GetMapping("/viewAll")
	public String viewAllEmployees(Model model) {
		model.addAttribute("employees", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		Employee e = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + id));
		repo.delete(e);
		model.addAttribute("employees", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Employee e = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + id));
		model.addAttribute("employee", e);
		return "update";
	}

	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") int id, @Valid Employee e, BindingResult result, Model model) {
		if (result.hasErrors()) {
			e.setId(id);
			return "update";
		}
		repo.save(e);
		model.addAttribute("employees", repo.findAll());
		return "results";
	}
}
