package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")    //адресс класса
public class FirstController {

	@GetMapping("/helloPage")
	public String helloPage (HttpServletRequest request){   //передача параметров запроса( пример http://localhost:8081/first/helloPage?name=Tom&age=65)
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("Name: " + name + ", " + "age" + Integer.valueOf(age));		
		return "/first/hello_page";
	}
	
	@GetMapping("/goodbyePage")
	public String byePage (@RequestParam(name = "city", required = false) String city, 
								@RequestParam(name = "address") String address, Model model){
		//System.out.println("City: " + city + ", " + "address" + address);	
		model.addAttribute("message", "Cyti: " + city + ", " + "address " + address);
		return "/first/bye_Page"; //возвращаем представление (jsp)
	}
	
	//примитивный калькулятор
	@GetMapping("/calculate")
	public String  calculate (@RequestParam(name = "firstTerm") String firstTerm,
									@RequestParam(name = "operation") String operation,
											@RequestParam(name = "secondTerm") String secondTerm,
																		Model model) {
			
		model.addAttribute("message", expres(firstTerm,secondTerm,operation));
		
		return "/first/calculate";
	}
	
	private Integer expres(String firstTerm, String secondTerm, String oper) {
		int i = Integer.valueOf(firstTerm);
		int j = Integer.valueOf(secondTerm);
		
		switch(oper) {
		case "+" : 
			return i+j;
		case "-" : 
			return i-j;
		case "*" : 
			return i*j;
		case "/" : 
			return i/j;
		default :
			return 0;
		}		
	}
	
	
	
}
