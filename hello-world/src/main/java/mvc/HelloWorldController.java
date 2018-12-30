package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(value="/", method = RequestMethod.GET)	
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/hello-world/", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}
	
	@RequestMapping(value = "/Bienvenus", method = RequestMethod.GET)
	public String sayBienvenue(ModelMap model) {
		model.addAttribute("greeting", "Bienvenue dans Spring 5.0.1 MVC");
		return "welcome";
	}
}