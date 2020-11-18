package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.nit.domain.UserManagement;
import in.nit.service.IUserManagementService;

@Controller
public class userManagementController {
	@Autowired
	private IUserManagementService userService;

	@GetMapping(value = { "/load" })
	public String loadPage(Model model) {
		UserManagement user = new UserManagement();
		model.addAttribute("user", user);
		return "index";
	}

	@PostMapping("/saved")
	public String saveUser(@ModelAttribute("user") UserManagement usermanagement, Model model) {
		boolean saveUser = userService.saveUser(usermanagement);
		if (saveUser) {
			model.addAttribute("sucMsg", "USER REGISTER SUCESSED");
		} else {
			model.addAttribute("failMsg", "USER REGISTER FAILDE");

		}
		return "index";
	}

	@GetMapping("/admin")
	public String loadAdmin() {
		return "admin";
	}

	@GetMapping("/employee")
	public String loadEmployee() {
		return "employee";
	}

	@GetMapping("/student")
	public String loadStudent() {
		return "student";
	}

	@GetMapping("/user")
	public String loadUser() {
		return "user";
	}

	@GetMapping("/welcome")
	public String loadWelcome() {
		return "welcome";
	}

	@GetMapping("/accessdenied")
	public String loadAccessdenied() {
		return "accessdenied";
	}
}
